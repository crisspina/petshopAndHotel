
import Activities.Activities;
import CounterService.HotelCounter;
import Customers.Customers;
import Customers.Pet;
import Customers.PetType;
import Customers.ReservedCustomers;
import Dao.ReservedCustomerDao;
import Room.RoomType;
import dataaccess.ReservedCustomerDaoImp;
import pethotel.PetHotel;
import java.util.Scanner;


public class Test {    
    static String menu = "-----------<<PETS HOTEL>>----------\n"
            + "1. Booking The Hotel\n"  //create customer, add pet,add activities , addroom
            + "2. Check room\n" //เช็คห้องว่าว่างมั้ย คือ HotelUpdate()
            + "3. Check your Status\n" //กรอกไอดี
            + "4. Cancel Booking\n" // Cancel() obj.hotel , obj.customer +  
            + "0. exit\n"
            + ">>>>>Select menu: ";
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {    
        int select;
        do {  
            System.out.println("Select: ");
            select = input.nextInt();
            switch (select) {
                case 1:
                    createNewCustomer();
                case 2:
                    checkRoomStatus();
                case 3:
                    checkMyStatus();
                case 4:
                    cancelBooking();
                    break;
            }
        } while (select != 0);
        System.out.println(">>>>>Exit<<<<<");
        System.out.println("Thank you");
        System.out.println("SAWASDEEKA");
    }

    private static void createNewCustomer() {
        Scanner sn = new Scanner(System.in);
        PetType petType=null;
        
        System.out.println("-----Add PET-----");
        System.out.print("Enter pet name: ");
        String name = sn.nextLine();

        System.out.print("Enter pet age: ");
        String age = sn.nextLine();

        int choicePet;
        System.out.println("Pet type: ");
        System.out.println("\t 1. DOG ");
        System.out.println("\t 2. CAT ");
        System.out.println("\t 3. RABBIT");
        System.out.println("\t 4. RACOON ");
        System.out.print("Enter your number Pet type: ");
        choicePet = sn.nextInt();
        switch (choicePet) {
            case 1:
                petType = PetType.DOG;
                break;
            case 2:
                petType = PetType.CAT;
                break;
            case 3:
                petType = PetType.RABBIT;
                break;
            case 4:
                petType = PetType.RACOON;
                break;
        }
        Pet pet = new Pet(name, age, petType);
        System.out.println("_______________________________");
        
        
        System.out.println("-----Create new Customer-----");
        System.out.print("Enter first name: ");
        String fName = sn.nextLine();
        
        System.out.print("Enter last name: ");
        String lName = sn.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = sn.nextLine();

        System.out.print("Enter Customer ID: ");
        String CustomerID = sn.nextLine();
        
        Customers C = new Customers( CustomerID, fName, lName,pet);
        System.out.println("_______________________________");
        
        System.out.println("-----Add Activities for your pet-----");
        Activities Act;
        ReservedCustomers rc = new ReservedCustomers();
        int choiceAct;
        System.out.println("Activities: ");
        System.out.println("\t 1. GROOMING");
        System.out.println("\t 2. PLAYTIME ");
        System.out.println("\t 3. GARDEN");
        System.out.println("\t 4. EXERCISE ");
        System.out.println("\t 5. MESSAGEANDSPA");
        System.out.println("\t 6. PHOTOSET");
        System.out.print("Enter your number Activities: ");
        choiceAct = sn.nextInt();
        switch (choiceAct) {
            case 1:
                Act = Activities.GROOMING;
                rc.setReservedActivities(Act);
                break;
            case 2:
               Act = Activities.PLAYTIME;
               rc.setReservedActivities(Act);
                break;
            case 3:
                Act = Activities.GARDEN;
                rc.setReservedActivities(Act);
                break;
            case 4:
                 Act = Activities.EXERCISE;
                 rc.setReservedActivities(Act);
                break;
            case 5:
                 Act = Activities.MESSAGEANDSPA;
                 rc.setReservedActivities(Act);
                 break;
            case 6:
                 Act = Activities.PHOTOSET;
                 rc.setReservedActivities(Act);
                 break;
    }
        System.out.println("_______________________________");
        
        System.out.println("-----Add Room-----");
        RoomType room;
        int choiceRoom;
        System.out.println("Room: ");
        System.out.println("\t 1. DELUXE");
        System.out.println("\t 2. SUPERIOR");
        System.out.println("\t 3. STANDARD");
        System.out.print("Enter your number Room: ");
        choiceRoom = sn.nextInt();
        switch (choiceRoom){
            case 1:
                room = RoomType.DELUXE;
                break;
            case 2:
                room = RoomType.SUPERIOR;
                break;
            case 3:
                room = RoomType.STANDARD;
                break;
        }
        
        System.out.println("_______________________________");
//        RC = new ;
//        ReservedCustomerDao ResDao = new ReservedCustomerDaoImp();
//        ResDao.addToReservedCustomer(RC);
//        return RC;
    }

    private static void checkRoomStatus() {
        HotelCounter hc = new HotelCounter();
        PetHotel p = new PetHotel("samsahai");
        hc.hotelUpdate(p);
    }

    private static void checkMyStatus() {
        
    }

    private static void cancelBooking() {
        HotelCounter hc = new HotelCounter();
        PetHotel p = new PetHotel("samsahai");
        ReservedCustomers rc = new ReservedCustomers();
        hc.cancelled(p,rc);
    }
//
//    public void test(){
//        System.out.println("test");
//    }
//   
//        ReservedCustomerDao ResDao = new ReservedCustomerDaoImp()
//        
//        C = new Customers(CustomerID, fName, lName, phoneNumber);
////        Customers c = new Customers();
////        c.cusScan();
//        CustomerDao custDao = new CustomerDaoImp();
//        custDao.insert(C);
//        return C;
//    }
//
//    
//
//    public void printReservedRoom() {
//        Scanner sn = new Scanner(System.in);
//        RoomType type1;
//        System.out.println("-Room-");
//
//        int choice;
//        System.out.println("Room type: ");
//        System.out.println("\t 1.Standard Room");
//        System.out.println("\t 2.Deluxe Room");
//        System.out.println("\t 3.Superior Room ");
//        System.out.print("Enter your number room type: ");
//        choice = sn.nextInt();
//        switch (choice) {
//            case 1:
//                type1 = RoomType.STANDARD;
//                break;
//            case 2:
//                type1 = RoomType.DELUXE;
//                break;
//            case 3:
//                type1 = RoomType.SUPERIOR;
//                break;
//        }
//        System.out.println("---------------------");
//        ReservedCustomers rc = new ReservedCustomers();
//        addCustomersList(rc);
//    }
//
//}
//
////create object not recieve input //เทส สัตว์ ลูกค้า ลูกค้าจองได้แล้ว
//public class Test {
//
//    ReservedCustomerDao ResDao = new ReservedCustomerDaoImp();
//
//    static void testPet() {
//        Pet p1 = new Pet("pretty", "10", PetType.DOG, "0816903023");
//        Pet p2 = new Pet("obog", "3", PetType.DOG, "0912369854");
//
//        System.out.println(p1);
//        System.out.println(p2);
//    }
//
//    static void testCustomer() {
//        Pet p1 = new Pet("pretty", "10", PetType.DOG, "0816903023");
//        Pet p2 = new Pet("obog", "3", PetType.DOG, "0912369854");
//
//        Customers c1 = new Customers("1909856987412", "praepanwa", "phaeng", "0816903023", p1);
//        Customers c2 = new Customers("9855697744113", "jungwoo", "kim", "0693214568", p2);
//        System.out.println(c1);
//        System.out.println(c2);
//
//    }
//
//    static void testReservedCustomer() {
//        Pet p1 = new Pet("pretty", "10", PetType.DOG, "0816903023");
//        Pet p2 = new Pet("obog", "3", PetType.DOG, "0912369854");
//        Pet p3 = new Pet("bobby", "5", PetType.RABBIT, "0366985214");
//
//        Customers c1 = new Customers("1909856987412", "praepanwa", "phaeng", "0816903023", p1);
//        Customers c2 = new Customers("9855697744113", "jungwoo", "kim", "0693214568", p2);
//        Customers c3 = new Customers("3100136699552", "jrpat", "guy", "0816903023", p3);
//
//        ReservedCustomers rc1 = new ReservedCustomers(RoomType.DELUXE, c1);
//        ReservedCustomers rc2 = new ReservedCustomers(RoomType.DELUXE, c2);
//        ReservedCustomers rc3 = new ReservedCustomers(RoomType.DELUXE, c3);
//        System.out.println(rc1);
//        System.out.println(rc2);
//        System.out.println(rc3);
//    }
//
//   public void testHotelCounter() {
//        PetHotel p = new PetHotel("samsahai");
//        System.out.println(p);
//        System.out.println("-----------------------------");
//        Pet p1 = new Pet("pretty", "10", PetType.DOG, "0816903023");
//        Pet p2 = new Pet("obog", "3", PetType.DOG, "0912369854");
//        Pet p3 = new Pet("bobby", "5", PetType.RABBIT, "0366985214");
//        Pet p4 = new Pet("vivi", "7", PetType.DOG, "0698523147");
//        Pet p5 = new Pet("lhong", "1", PetType.CAT, "0894081600");
////        System.out.println(p1);
//
//        Customers c1 = new Customers("1909856987412", "praepanwa", "phaeng", "0816903023", p1);
//        Customers c2 = new Customers("9855697744113", "jungwoo", "kim", "0693214568", p2);
//        Customers c3 = new Customers("3100136699552", "jrpat", "guy", "0816903023", p3);
//        Customers c4 = new Customers("8419632587410", "sehun", "oh", "0816903023", p4);
//        Customers c5 = new Customers("2013658922467", "sunanta", "gift", "0816903023", p5);
//        //     System.out.println(c1);
//        /*   ReservedCustomers rc1 = new ReservedCustomers(RoomType.DELUXE,c1);
//        System.out.println(rc1);
//        System.out.println("------------------------------------");
//        HotelCounter h = new HotelCounter(p,rc1);
//        System.out.println(h.cusUpdate(rc1));
//        System.out.println("--------------------------");
//        System.out.println(h.hotelUpdate(p));
//        System.out.println(h.checkBill(rc1));*/
////        System.out.println(p);
////        
//        ReservedCustomers rc2 = new ReservedCustomers(RoomType.DELUXE, c2);
//        System.out.println(rc2);
//        System.out.println("------------------------------------");
//        HotelCounter h2 = new HotelCounter(p, rc2);
//        h2.reserved(p, rc2);
//        h2.checkBill(rc2);
//        System.out.println("--------------HOTEL-------------");
//        System.out.println(h2.cusUpdate(rc2));
//        System.out.println(h2.hotelUpdate(p));
//        System.out.println(h2.checkBill(rc2));
//        System.out.println("------EXTRA-------------");
//        h2.cancelled(p, rc2);
//        System.out.println(h2.cusUpdate(rc2));
//        System.out.println(h2.hotelUpdate(p));
//        
//        ResDao.addToReservedCustomer(rc2);
//             

        

        /*      ReservedCustomers rc3 = new ReservedCustomers(RoomType.DELUXE,c3);
        System.out.println(rc3);
        System.out.println("------------------------------------");
        HotelCounter h3 = new HotelCounter(p,rc3);
        System.out.println(h3.cusUpdate(rc3));
        System.out.println("--------------------------");
         System.out.println(h3.hotelUpdate(p));*/
//   
//        ReservedCustomers rc4 = new ReservedCustomers(RoomType.STANDARD,c4);
//        System.out.println(rc4);
//        System.out.println("------------------------------------");
//        HotelCounter h4 = new HotelCounter(p,rc4);
//        System.out.println(h4.cusUpdate(rc1));
//        System.out.println("--------------------------");
//         System.out.println(h4.hotelUpdate(p));
//        
//        ReservedCustomers rc5 = new ReservedCustomers(RoomType.SUPERIOR,c5);
//        System.out.println(rc5);
//        System.out.println("------------------------------------");
//        HotelCounter h5 = new HotelCounter(p,rc5);
//        System.out.println(h5.cusUpdate(rc5));
//        System.out.println("--------------------------");
//         System.out.println(h5.hotelUpdate(p));
//       
    }



