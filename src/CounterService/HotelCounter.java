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

    public HotelCounter(PetHotel petHotel, ReservedCustomers rc) {
        this.p = petHotel;
        this.rc = rc;
    }

    @Override
    public int checkBill(ReservedCustomers c) {
        int price = 0;
        switch (c.getResRoom()) {
            case DELUXE:
                price += RoomInformation.DELUXE_ROOM_PER_NIGHT;
                amount =price;
                break;
            case STANDARD:
                price += RoomInformation.STANDARD_ROOM_PER_NIGHT;
                 amount =price;
                break;
            case SUPERIOR:
                price += RoomInformation.SUPERIOR_ROOM_PER_NIGHT;
                 amount =price;
                break;
        }
            switch (c.getResAct()) {
                case GROOMING:
                    price += ActivitiesFee.GROOMING;
                     amount =price;
                      c.setAmount(amount);
                    break;
                case PLAYTIME:
                    price += ActivitiesFee.PLAYTIME;
                     amount =price;
                      c.setAmount(amount);
                    break;
                case EXERCISE:
                    price += ActivitiesFee.EXERCISE;
                     amount =price;
                      c.setAmount(amount);
                    break;
                case MESSAGEANDSPA:
                    price += ActivitiesFee.MESSAGEANDSPA;
                     amount =price;
                      c.setAmount(amount);
                    break;
                case GARDEN:
                    price += ActivitiesFee.GARDEN;
                     amount =price;
                      c.setAmount(amount);
                    break;
                case PHOTOSET:
                    price += ActivitiesFee.PHOTOSET;
                     amount =price;
                      c.setAmount(amount);
                    break;
        }
            printSlip(c);
            return price;
    }

    @Override
    public void printSlip(ReservedCustomers c) {
       FileWriter fw = null;
       
       try{
       fw = new FileWriter("customersSlip"+((c.getCustomers()).getCustomerID())+".txt");
       fw.write("YOUR RESERVED INFORMATION \n");
       fw.flush();
        switch (c.getResRoom()) {
            case DELUXE:
                fw.write("Deluxe Room " + RoomInformation.DELUXE_ROOM_PER_NIGHT + " baht \n");fw.flush();
                break;
            case STANDARD:
                fw.write("Standard Room " + RoomInformation.STANDARD_ROOM_PER_NIGHT + " baht \n");fw.flush();
                break;
            default:
                fw.write("Superior Room " + RoomInformation.SUPERIOR_ROOM_PER_NIGHT + " baht \n");fw.flush();
                break;
        }

        fw.write("Reserved Acitvities for your pet \n");

                switch (c.getResAct()) {
                    case GROOMING:
                        fw.write("Grooming " + ActivitiesFee.GROOMING + " baht \n");fw.flush();
                        break;
                    case PLAYTIME:
                        fw.write("Playtime " + ActivitiesFee.PLAYTIME + " baht \n");fw.flush();
                        break;
                    case EXERCISE:
                        fw.write("Exercise " + ActivitiesFee.EXERCISE + " baht \n");fw.flush();
                        break;
                    case MESSAGEANDSPA:
                        fw.write("Message and spa " + ActivitiesFee.MESSAGEANDSPA + "baht \n");fw.flush();
                        break;
                    case GARDEN:
                         fw.write("Garden " + ActivitiesFee.GARDEN + " baht \n");fw.flush();
                        break;
                    case PHOTOSET:
                       fw.write("Photoset " + ActivitiesFee.PHOTOSET + " baht \n");fw.flush();
                        break;
        } 
              fw.write("total: "+amount +"bath \n");fw.flush();
              fw.write("your reserved status: " + c.getStatus());fw.flush();
        System.out.println("-----------check your slip at customerSlip+your customer id .txt--------------------");
   
    }   catch (IOException ex) {
             System.out.println(ex.getMessage());
        }
    }
   @Override
    public void reserved(PetHotel petHotel,ReservedCustomers c) {
        if (!(checkIsFull(petHotel,c)) || (checkReserveHistory(petHotel,c))) {
            if (c.getResRoom().equals(RoomType.DELUXE)) {
                for (int i = 0; i < petHotel.getHr().getDRoomLength(); i++) {
                    if (petHotel.getHr().getdRooms(i).getStatus().equals(RoomStatus.FULL)) {
                        continue;
                    }else if(petHotel.getHr().getdRooms(i).getStatus().equals(RoomStatus.AVAILABLE)){
                    (petHotel.getHr()).setdRoom(i, c);
                    (petHotel.getHr()).addCountDe();
                    (petHotel.getHr()).getdRooms(i).setStatus(RoomStatus.FULL);
                    setStatustoReservedCustomers(petHotel,c);
                    return;}
                }
            } else if (c.getResRoom().equals(RoomType.SUPERIOR)) {
                for (int i = 0; i < petHotel.getHr().getSupRoomLength(); i++) {
                    if (petHotel.getHr().getSupRooms(i).getStatus().equals(RoomStatus.FULL)) {
                        continue;
                    }else if(petHotel.getHr().getSupRooms(i).getStatus().equals(RoomStatus.AVAILABLE)){
                    (petHotel.getHr()).setSupRoom(i, c);
                    (petHotel.getHr()).addCountSup();
                    (petHotel.getHr()).getSupRooms(i).setStatus(RoomStatus.FULL);
                    setStatustoReservedCustomers(petHotel,c);
                    return;
                    }
                    
                }
            } else {
                for (int i = 0; i < petHotel.getHr().getStdRoomLength(); i++) {
                    if (petHotel.getHr().getStdRooms(i).getStatus().equals(RoomStatus.FULL)) {
                       continue;
                    }else if(petHotel.getHr().getStdRooms(i).getStatus().equals(RoomStatus.AVAILABLE)){
                     (petHotel.getHr()).setStdRoom(i, c);
                    (petHotel.getHr()).addCountStd();
                    (petHotel.getHr()).getStdRooms(i).setStatus(RoomStatus.FULL);
                    setStatustoReservedCustomers(petHotel,c);
                    return;
                    }
                    
                }
            }
        } else{ System.out.println("CANNOT ADD PET");}
    }
    @Override
    public void cancelled(PetHotel petHotel, ReservedCustomers c) {
        if (checkReserveHistory(petHotel, c) == false) {
            System.out.println("you haven't reserved the room");
            return;
        } else {
            if (c.getResRoom().equals(RoomType.DELUXE)) {
                for (int i = 0; i < petHotel.getHr().getCountDe(); i++) {
                    if (petHotel.getHr().getdRooms(i).getRc().getCustomers().getPet().equals(c.getCustomers().getPet())) {
                ((petHotel.getHr()).getdRooms(search(petHotel, c))).setStatus(RoomStatus.AVAILABLE);
                (petHotel.getHr()).setdRoom(search(petHotel, c), null);
                (petHotel.getHr()).minusCountDe();
                    c.setAmount(0);
                    c.setStatus(ReservedStatus.CANCELLED);
                    }
                }
                
            } else if (c.getResRoom().equals(RoomType.STANDARD)) {
                for (int i = 0; i < petHotel.getHr().getCountStd(); i++) {
                    ((petHotel.getHr()).getStdRooms(search(petHotel, c))).setStatus(RoomStatus.AVAILABLE);
                (petHotel.getHr()).setStdRoom(search(petHotel, c), null);
                (petHotel.getHr()).minusCountStd();
                    c.setAmount(0);
                    c.setStatus(ReservedStatus.CANCELLED);
                }

            } else if (c.getResRoom().equals(RoomType.SUPERIOR)) {
                ((petHotel.getHr()).getSupRooms(search(petHotel, c))).setStatus(RoomStatus.AVAILABLE);
                (petHotel.getHr()).setSupRoom(search(petHotel, c), null);
                (petHotel.getHr()).minusCountSup();
                    c.setAmount(0);
                    c.setStatus(ReservedStatus.CANCELLED);  
            }
            System.out.println("cancelled sucessfully");
            return;
        }
    }
    @Override
    public int search(PetHotel petHotel, ReservedCustomers c) {
        int i = 0;
        if (c.getResRoom().equals(RoomType.DELUXE)) {
            if ((petHotel.getHr()).getCountDe() != 0) {
                for (i = 0; i < petHotel.getHr().getCountDe(); i++) {
                    if (petHotel.getHr().getdRooms(i).getRc().getCustomers().getPet() == null) {

                        continue;
                    } else if ((c.getCustomers().getPet()).equals(petHotel.getHr().getdRooms(i).getRc().getCustomers().getPet())) {
                        return i;
                    }
                    System.out.println("search not found");
                    return -1;
                }

            }
            System.out.println("available room for reserve");

        } else if (c.getResRoom().equals(RoomType.SUPERIOR)) {
            if ((petHotel.getHr().getCountSup() != 0)) {
                for (i = 0; i < petHotel.getHr().getCountSup(); i++) {
                    if (petHotel.getHr().getdRooms(i).getRc().getCustomers().getPet() == null) {
                        System.out.println("not found");
                        continue;
                    } else if ((c.getCustomers().getPet()).equals(petHotel.getHr().getSupRooms(i).getRc().getCustomers().getPet())) {
                        return i;
                    }
                    System.out.println("search not found");
                    return -1;
                }

            }
            System.out.println("available");

        } else if (c.getResRoom().equals(RoomType.STANDARD)) {
            if ((petHotel.getHr()).getCountStd() != 0) {
                for (i = 0; i < petHotel.getHr().getCountStd(); i++) {
                    if (petHotel.getHr().getdRooms(i).getRc().getCustomers().getPet() == null) {
                        System.out.println("not found");
                        continue;
                    } else if ((c.getCustomers().getPet()).equals(petHotel.getHr().getStdRooms(i).getRc().getCustomers().getPet())) {
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
    public boolean checkReserveHistory(PetHotel petHotel, ReservedCustomers c) {
        if (search(petHotel, c) != -1) {
            System.out.println("YOU HAVE ALREADY RESERVED");
            return true;
        }
        System.out.println("YOU DIDN'T RESERVED ANY ROOM");
        return false;
    }

    @Override
    public boolean checkIsFull(PetHotel petHotel, ReservedCustomers c) {

        switch (c.getResRoom()) {
            case DELUXE:
                return (((petHotel.getHr()).getCountDe()) - 1) == RoomInformation.MAX_DELUXE;

            case STANDARD:
                return (((petHotel.getHr()).getCountStd()) - 1) == RoomInformation.MAX_STANDARD;

            default:
                return (((petHotel.getHr()).getCountSup()) - 1) == RoomInformation.MAX_SUPERIOR;

        }
    }

    @Override
    public void setStatustoReservedCustomers(PetHotel petHotel, ReservedCustomers c) {
        switch (c.getResRoom()) {
            case DELUXE:
                if ((petHotel.getHr()).getCountDe() == RoomInformation.MAX_DELUXE) {
                    c.setStatus(ReservedStatus.FULL);
                } else {
                    c.setStatus(ReservedStatus.SUCESS);
                }
            case SUPERIOR:
                if ((petHotel.getHr()).getCountSup() == RoomInformation.MAX_SUPERIOR) {
                    c.setStatus(ReservedStatus.FULL);
                } else {
                    c.setStatus(ReservedStatus.SUCESS);
                }
            case STANDARD:
                if ((petHotel.getHr()).getCountStd() == RoomInformation.MAX_STANDARD) {
                    c.setStatus(ReservedStatus.FULL);
                } else {
                    c.setStatus(ReservedStatus.SUCESS);
                }
        }
    }

    @Override
    public String cusUpdate(ReservedCustomers c) {
        this.rc = c;
        return rc.toString();
    }

    @Override
    public String hotelUpdate(PetHotel petHotel) {
        this.p = petHotel;
        return petHotel.toString();
    }
}

