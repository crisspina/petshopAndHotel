package CounterService;

import Activities.ActivitiesFee;
import Customers.ReservedCustomers;
//import Room.HotelRoom;
import Room.RoomInformation;
import Room.RoomStatus;
import Room.RoomType;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import pethotel.PetHotel;

public class HotelCounter implements Payment, ReserveOperation, Check {

    private PetHotel p;
    private ReservedCustomers rc;

    public HotelCounter(PetHotel petHotel, ReservedCustomers rc) {
        this.p = petHotel;
        this.rc = rc;

    }

    @Override
    public int checkBill(ReservedCustomers c) {
        int price = 0;
        int amount;
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
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("CustomersSlip/" + c.getCustomers().getCustomerID() + "slip.txt",true);
         /*   BufferedOutputStream bos = new BufferedOutputStream(fos);
            java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(bos);*/

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        PrintWriter pw = new PrintWriter(fos);
        pw.println("YOUR RESERVED INFORMATION");
        switch (c.getResRoom()) {
            case DELUXE:
                pw.println("Deluxe Room" + RoomInformation.DELUXE_ROOM_PER_NIGHT + "baht");
                break;
            case STANDARD:
                pw.println("Standard Room" + RoomInformation.STANDARD_ROOM_PER_NIGHT + "baht");
                break;
            default:
                pw.println("Superior Room" + RoomInformation.SUPERIOR_ROOM_PER_NIGHT + "baht");
                break;
        }

        pw.print("Reserved Acitvities for your pet");
        if (c.getCountAct() == 0) {
            System.out.println("you didnt reserved any activity");
        } else {
                switch (c.getResAct()) {
                    case GROOMING:
                        pw.println("Grooming" + ActivitiesFee.GROOMING + "baht");
                        break;
                    case PLAYTIME:
                        pw.println("Playtime" + ActivitiesFee.PLAYTIME + "baht");
                        break;
                    case EXERCISE:
                        pw.println("Exercise" + ActivitiesFee.EXERCISE + "baht");
                        break;
                    case MESSAGEANDSPA:
                        pw.println("Message and spa" + ActivitiesFee.MESSAGEANDSPA + "baht");
                        break;
                    case GARDEN:
                        pw.println("Garden" + ActivitiesFee.GARDEN + "baht");
                        break;
                    case PHOTOSET:
                        pw.println("Photoset" + ActivitiesFee.PHOTOSET + "baht");
                        break;
                    default:
                        pw.println("You reserved no activity for your pet");
                
            }
         pw.close();       
 /*private static void viewOrder() throws IOException {
//        FileWriter writer = new FileWriter("/doc/order.txt");
        Path path = Paths.get(user.toString());
        String textPath = path.toString() + ".txt";

        PrintWriter writer = new PrintWriter(textPath);
        for (String line : orderList) {
            writer.println(line);
        }
        writer.close();

        BufferedReader br = new BufferedReader(new FileReader(textPath));

        String st;
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }

        orderShabu();
    }*/
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
                    }else if(petHotel.getHr().getdRooms(i).getStatus().equals(RoomStatus.AVAILABLE)){
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
                ((petHotel.getHr()).getdRooms(search(petHotel, c))).setStatus(RoomStatus.AVAILABLE);
                (petHotel.getHr()).setdRoom(search(petHotel, c), null);
                (petHotel.getHr()).minusCountDe();

//                recallRoom(c);
                setStatustoReservedCustomers(petHotel, c);
            } else if (c.getResRoom().equals(RoomType.STANDARD)) {
                ((petHotel.getHr()).getStdRooms(search(petHotel, c))).setStatus(RoomStatus.AVAILABLE);
                (petHotel.getHr()).setStdRoom(search(petHotel, c), null);
                (petHotel.getHr()).minusCountStd();
//                recallRoom(c);
                setStatustoReservedCustomers(petHotel, c);
            } else if (c.getResRoom().equals(RoomType.SUPERIOR)) {
                ((petHotel.getHr()).getSupRooms(search(petHotel, c))).setStatus(RoomStatus.AVAILABLE);
                (petHotel.getHr()).setSupRoom(search(petHotel, c), null);
                (petHotel.getHr()).minusCountSup();
//                recallRoom(c);
                setStatustoReservedCustomers(petHotel, c);
            }
            System.out.println("cancelled sucessfully");
            return;
        }
    }

//    public void recallRoom(ReservedCustomers failcus) {
//        if (failcus.getStatus().equals(ReservedStatus.FAIL) && failcus.getResRoom().equals(RoomType.DELUXE) 
//                && (checkIsFull(failcus) == false)) {
//            reserved(failcus);
//
//        } else if (failcus.getStatus().equals(ReservedStatus.FAIL) && failcus.getResRoom().equals(RoomType.STANDARD) 
//                && (checkIsFull(failcus) == false)) {
//            reserved(failcus);
//
//        } else if (failcus.getStatus().equals(ReservedStatus.FAIL) && failcus.getResRoom().equals(RoomType.SUPERIOR) 
//                && (checkIsFull(failcus) == false)) {
//            reserved(failcus);
//
//        }
//    }
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
                    c.setStatus(ReservedStatus.PROCESSING);
                } else {
                    c.setStatus(ReservedStatus.SUCESS);
                }
            case SUPERIOR:
                if ((petHotel.getHr()).getCountSup() == RoomInformation.MAX_SUPERIOR) {
                    c.setStatus(ReservedStatus.PROCESSING);
                } else {
                    c.setStatus(ReservedStatus.SUCESS);
                }
            case STANDARD:
                if ((petHotel.getHr()).getCountStd() == RoomInformation.MAX_STANDARD) {
                    c.setStatus(ReservedStatus.PROCESSING);
                } else {
                    c.setStatus(ReservedStatus.SUCESS);
                }
        }

//        if(c.getResRoom().equals(RoomType.DELUXE)){
//              if (petHotel.getHr().getCountDe()==RoomInformation.MAX_DELUXE) {
//                  c.setStatus(ReservedStatus.FULL);
//              } else if(c.getResRoom().equals(RoomType.SUPERIOR)){
//                c.setStatus(ReservedStatus.FULL);
//              }else if(c.getResRoom().equals(RoomType.SUPERIOR)){
//              c.setStatus(ReservedStatus.FULL);
//              }
//          }
//        if (checkIsFull(petHotel,c)) {
//            c.setStatus(ReservedStatus.FULL);
//        } else {
//            c.setStatus(ReservedStatus.SUCESS);
//        }
    }

    public String cusUpdate(ReservedCustomers c) {
        this.rc = c;
        return rc.toString();
    }

    public String hotelUpdate(PetHotel petHotel) {
        this.p = petHotel;
        return petHotel.toString();
    }
}
