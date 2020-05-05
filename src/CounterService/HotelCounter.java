package CounterService;

import Activities.ActivitiesFee;
import Customers.ReservedCustomers;
import Room.RoomInformation;
import Room.RoomStatus;
import Room.RoomType;
import java.io.FileWriter;
import java.io.IOException;
import pethotel.PetHotel;

public class HotelCounter implements Payment, ReserveOperation, Check, Update {

    private PetHotel p;
    private ReservedCustomers rc;
    private int amount;

    public HotelCounter() {

    }

    public HotelCounter(PetHotel petHotel, ReservedCustomers rc) {
        this.p = petHotel;
        this.rc = rc;
    }

    @Override
    public int checkBill() {
        int price = 0;
        switch (rc.getResRoom()) {
            case DELUXE:
                price += RoomInformation.DELUXE_ROOM_PER_NIGHT;
                amount = price;
                break;
            case STANDARD:
                price += RoomInformation.STANDARD_ROOM_PER_NIGHT;
                amount = price;
                break;
            case SUPERIOR:
                price += RoomInformation.SUPERIOR_ROOM_PER_NIGHT;
                amount = price;
                break;
        }
        switch (rc.getResAct()) {
            case GROOMING:
                price += ActivitiesFee.GROOMING;
                amount = price;
                rc.setAmount(amount);
                break;
            case PLAYTIME:
                price += ActivitiesFee.PLAYTIME;
                amount = price;
                rc.setAmount(amount);
                break;
            case EXERCISE:
                price += ActivitiesFee.EXERCISE;
                amount = price;
                rc.setAmount(amount);
                break;
            case MESSAGEANDSPA:
                price += ActivitiesFee.MESSAGEANDSPA;
                amount = price;
                rc.setAmount(amount);
                break;
            case GARDEN:
                price += ActivitiesFee.GARDEN;
                amount = price;
                rc.setAmount(amount);
                break;
            case PHOTOSET:
                price += ActivitiesFee.PHOTOSET;
                amount = price;
                rc.setAmount(amount);
                break;
        }
        printSlip();
        return price;
    }

    @Override
    public void printSlip() {
        FileWriter fw = null;

        try {
            fw = new FileWriter("customersSlip" + ((rc.getCustomers()).getCustomerID()) + ".txt");
            fw.write("YOUR RESERVED INFORMATION \n");
            fw.flush();
            switch (rc.getResRoom()) {
                case DELUXE:
                    fw.write("Deluxe Room " + RoomInformation.DELUXE_ROOM_PER_NIGHT + " baht \n");
                    fw.flush();
                    break;
                case STANDARD:
                    fw.write("Standard Room " + RoomInformation.STANDARD_ROOM_PER_NIGHT + " baht \n");
                    fw.flush();
                    break;
                default:
                    fw.write("Superior Room " + RoomInformation.SUPERIOR_ROOM_PER_NIGHT + " baht \n");
                    fw.flush();
                    break;
            }

            fw.write("Reserved Acitvities for your pet \n");

            switch (rc.getResAct()) {
                case GROOMING:
                    fw.write("Grooming " + ActivitiesFee.GROOMING + " baht \n");
                    fw.flush();
                    break;
                case PLAYTIME:
                    fw.write("Playtime " + ActivitiesFee.PLAYTIME + " baht \n");
                    fw.flush();
                    break;
                case EXERCISE:
                    fw.write("Exercise " + ActivitiesFee.EXERCISE + " baht \n");
                    fw.flush();
                    break;
                case MESSAGEANDSPA:
                    fw.write("Message and spa " + ActivitiesFee.MESSAGEANDSPA + "baht \n");
                    fw.flush();
                    break;
                case GARDEN:
                    fw.write("Garden " + ActivitiesFee.GARDEN + " baht \n");
                    fw.flush();
                    break;
                case PHOTOSET:
                    fw.write("Photoset " + ActivitiesFee.PHOTOSET + " baht \n");
                    fw.flush();
                    break;
            }
            fw.write("total: " + amount + "bath \n");
            fw.flush();
            fw.write("your reserved status: " + rc.getStatus());
            fw.flush();
            System.out.println("-----------check your slip at customerSlip+your customer id .txt--------------------");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void reserved() {
        if (!(checkIsFull()) || (checkReserveHistory())) {
            if (rc.getResRoom().equals(RoomType.DELUXE)) {
                for (int i = 0; i < p.getHr().getDRoomLength(); i++) {
                    if (p.getHr().getdRooms(i).getStatus().equals(RoomStatus.FULL)) {
                        continue;
                    } else if (p.getHr().getdRooms(i).getStatus().equals(RoomStatus.AVAILABLE)) {
                        (p.getHr()).setdRoom(i, rc);
                        (p.getHr()).addCountDe();
                        (p.getHr()).getdRooms(i).setStatus(RoomStatus.FULL);
                        setStatustoReservedCustomers();
                        return;
                    }
                }
            } else if (rc.getResRoom().equals(RoomType.SUPERIOR)) {
                for (int i = 0; i < p.getHr().getSupRoomLength(); i++) {
                    if (p.getHr().getSupRooms(i).getStatus().equals(RoomStatus.FULL)) {
                        continue;
                    } else if (p.getHr().getSupRooms(i).getStatus().equals(RoomStatus.AVAILABLE)) {
                        (p.getHr()).setSupRoom(i, rc);
                        (p.getHr()).addCountSup();
                        (p.getHr()).getSupRooms(i).setStatus(RoomStatus.FULL);
                        setStatustoReservedCustomers();
                        return;
                    }

                }
            } else {
                for (int i = 0; i < p.getHr().getStdRoomLength(); i++) {
                    if (p.getHr().getStdRooms(i).getStatus().equals(RoomStatus.FULL)) {
                        continue;
                    } else if (p.getHr().getStdRooms(i).getStatus().equals(RoomStatus.AVAILABLE)) {
                        (p.getHr()).setStdRoom(i, rc);
                        (p.getHr()).addCountStd();
                        (p.getHr()).getStdRooms(i).setStatus(RoomStatus.FULL);
                        setStatustoReservedCustomers();
                        return;
                    }

                }
            }
        } else {
            System.out.println("CANNOT ADD PET");
        }
    }

    @Override
    public void cancelled() {
        if (checkReserveHistory() == false) {
            System.out.println("you haven't reserved the room");
            return;
        } else {
            if (rc.getResRoom().equals(RoomType.DELUXE)) {
                for (int i = 0; i < p.getHr().getCountDe(); i++) {
                    if (p.getHr().getdRooms(i).getRc().getCustomers().getPet().equals(rc.getCustomers().getPet())) {
                        ((p.getHr()).getdRooms(search())).setStatus(RoomStatus.AVAILABLE);
                        (p.getHr()).setdRoom(search(), null);
                        (p.getHr()).minusCountDe();
                        rc.setAmount(0);
                        rc.setStatus(ReservedStatus.CANCELLED);
                    }
                }

            } else if (rc.getResRoom().equals(RoomType.STANDARD)) {
                for (int i = 0; i < p.getHr().getCountStd(); i++) {
                    ((p.getHr()).getStdRooms(search())).setStatus(RoomStatus.AVAILABLE);
                    (p.getHr()).setStdRoom(search(), null);
                    (p.getHr()).minusCountStd();
                    rc.setAmount(0);
                    rc.setStatus(ReservedStatus.CANCELLED);
                }

            } else if (rc.getResRoom().equals(RoomType.SUPERIOR)) {
                ((p.getHr()).getSupRooms(search())).setStatus(RoomStatus.AVAILABLE);
                (p.getHr()).setSupRoom(search(), null);
                (p.getHr()).minusCountSup();
                rc.setAmount(0);
                rc.setStatus(ReservedStatus.CANCELLED);
            }
            System.out.println("cancelled sucessfully");
            return;
        }
    }

    @Override
    public int search() {
        int i = 0;
        if (rc.getResRoom().equals(RoomType.DELUXE)) {
            if ((p.getHr()).getCountDe() != 0) {
                for (i = 0; i < p.getHr().getCountDe(); i++) {
                    if (p.getHr().getdRooms(i).getRc().getCustomers().getPet() == null) {

                        continue;
                    } else if ((rc.getCustomers().getPet()).equals(p.getHr().getdRooms(i).getRc().getCustomers().getPet())) {
                        return i;
                    }
                    System.out.println("search not found");
                    return -1;
                }

            }
            System.out.println("available room for reserve");

        } else if (rc.getResRoom().equals(RoomType.SUPERIOR)) {
            if ((p.getHr().getCountSup() != 0)) {
                for (i = 0; i < p.getHr().getCountSup(); i++) {
                    if (p.getHr().getdRooms(i).getRc().getCustomers().getPet() == null) {
                        System.out.println("not found");
                        continue;
                    } else if ((rc.getCustomers().getPet()).equals(p.getHr().getSupRooms(i).getRc().getCustomers().getPet())) {
                        return i;
                    }
                    System.out.println("search not found");
                    return -1;
                }

            }
            System.out.println("available");

        } else if (rc.getResRoom().equals(RoomType.STANDARD)) {
            if ((p.getHr()).getCountStd() != 0) {
                for (i = 0; i < p.getHr().getCountStd(); i++) {
                    if (p.getHr().getdRooms(i).getRc().getCustomers().getPet() == null) {
                        System.out.println("not found");
                        continue;
                    } else if ((rc.getCustomers().getPet()).equals(p.getHr().getStdRooms(i).getRc().getCustomers().getPet())) {
                        return i;
                    }
                    System.out.println("search not found");
                    return -1;
                }

            }
            System.out.println("available");
        } else {
            System.out.println("customers didn't reserved any room");
            return -1;
        }
        return i;
    }

    @Override
    public boolean checkReserveHistory() {
        if (search() != -1) {
            System.out.println("YOU HAVE ALREADY RESERVED");
            return true;
        }
        System.out.println("YOU DIDN'T RESERVED ANY ROOM");
        return false;
    }

    @Override
    public boolean checkIsFull() {

        switch (rc.getResRoom()) {
            case DELUXE:
                return (((p.getHr()).getCountDe()) - 1) == RoomInformation.MAX_DELUXE;

            case STANDARD:
                return (((p.getHr()).getCountStd()) - 1) == RoomInformation.MAX_STANDARD;

            default:
                return (((p.getHr()).getCountSup()) - 1) == RoomInformation.MAX_SUPERIOR;

        }
    }

    @Override
    public void setStatustoReservedCustomers() {
        switch (rc.getResRoom()) {
            case DELUXE:
                if ((p.getHr()).getCountDe() == RoomInformation.MAX_DELUXE) {
                    rc.setStatus(ReservedStatus.FULL);
                } else {
                    rc.setStatus(ReservedStatus.SUCESS);
                }
            case SUPERIOR:
                if ((p.getHr()).getCountSup() == RoomInformation.MAX_SUPERIOR) {
                    rc.setStatus(ReservedStatus.FULL);
                } else {
                    rc.setStatus(ReservedStatus.SUCESS);
                }
            case STANDARD:
                if ((p.getHr()).getCountStd() == RoomInformation.MAX_STANDARD) {
                    rc.setStatus(ReservedStatus.FULL);
                } else {
                    rc.setStatus(ReservedStatus.SUCESS);
                }
        }
    }

    @Override
    public String cusUpdate() {

        return rc.toString();
    }

    @Override
    public String hotelUpdate() {
        return p.toString();
    }
}
