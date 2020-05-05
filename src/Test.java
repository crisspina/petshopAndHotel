
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

    static PetHotel petHotel = new PetHotel("Hotel JA");

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int menuId;
        do {
            System.out.println("1. Booking The Hotel");
            System.out.println("2. Check room");
            System.out.println("3. Check your Status");
            System.out.println("4. Cancel Booking");
            System.out.println("0. exit");
            System.out.print("Enter yout menu [0-4] : ");
            menuId = input.nextInt();
            switch (menuId) {
                case 1:
                    hotelCounter();
                    break;
                case 2:
                    checkRoomStatus();
                    break;
                case 3:
                    checkMyStatus();
                    break;
                case 4:
                    cancelBooking();
                    break;

            }
        } while (menuId != 0);
        System.out.println(">>>>>Exit<<<<<");
        System.out.println("Thank you");
        System.out.println("SAWASDEEKA");
    }

    private static void createNewCustomer() {
        PetHotel p = new PetHotel("samsahai");
        Pet pet = null;
        PetType petType = null;
        Customers C = null;
        Activities Act;
        ReservedCustomers rc = null;
        Scanner sn = new Scanner(System.in); //number
        Scanner sc = new Scanner(System.in);
        System.out.println(p);

        try {
            System.out.println("-----Add PET-----");
            System.out.print("Enter pet name: ");
            String name = sc.nextLine();

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
            pet = new Pet(name, age, petType);
            System.out.println(pet.toString());
            System.out.println("_______________________________");
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        try {
            System.out.println("-----Create new Customer-----");
            System.out.print("Enter first name: ");
            String fName = sc.nextLine();

            System.out.print("Enter last name: ");
            String lName = sc.nextLine();

            System.out.print("Enter phone number: ");
            String phoneNumber = sc.nextLine();

            System.out.print("Enter Customer ID: ");
            String CustomerID = sc.nextLine();

            C = new Customers(CustomerID, fName, lName, phoneNumber, pet);
            System.out.println(C.toString());
            System.out.println("_______________________________");

        } catch (NullPointerException e) {
            System.out.println(e);
        }
        try {
            rc = new ReservedCustomers(RoomType.DELUXE, C);
            System.out.println("-----Add Room-----");
            RoomType room;
            int choiceRoom;
            System.out.println("Room: ");
            System.out.println("\t 1. DELUXE");
            System.out.println("\t 2. SUPERIOR");
            System.out.println("\t 3. STANDARD");
            System.out.print("Enter your number Room: ");
            choiceRoom = sn.nextInt();
            switch (choiceRoom) {
                case 1:
                    room = RoomType.DELUXE;
                    System.out.println("Test");
                    rc = new ReservedCustomers(room, C);
                    System.out.println(rc);
                    break;
                case 2:
                    room = RoomType.SUPERIOR;
                    rc = new ReservedCustomers(room, C);
                    break;
                case 3:
                    room = RoomType.STANDARD;
                    rc = new ReservedCustomers(room, C);
                    break;
            }

        } catch (NullPointerException e) {
            System.out.println(e);
        }

        try {
            System.out.println("_______________________________");
            System.out.println("-----Add Activities for your pet-----");
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
                    System.out.println(rc);
                    break;
                case 2:
                    Act = Activities.PLAYTIME;
                    rc.setReservedActivities(Act);
                    System.out.println(rc);
                    break;
                case 3:
                    Act = Activities.GARDEN;
                    rc.setReservedActivities(Act);
                    System.out.println(rc);
                    break;
                case 4:
                    Act = Activities.EXERCISE;
                    rc.setReservedActivities(Act);
                    System.out.println(rc);
                    break;
                case 5:
                    Act = Activities.MESSAGEANDSPA;
                    rc.setReservedActivities(Act);
                    System.out.println(rc);
                    break;
                case 6:
                    Act = Activities.PHOTOSET;
                    rc.setReservedActivities(Act);
                    System.out.println(rc);
                    break;
            }
            System.out.println("_______________________________");

        } catch (NullPointerException e) {
            System.out.println(e);
        }
        try {
            HotelCounter hc = new HotelCounter(p, rc);
            hc.reserved();
            hc.checkBill();
        } catch (NullPointerException e) {
            System.out.println("K" + e);
        }

        ReservedCustomerDao ResDao = new ReservedCustomerDaoImp();
        ResDao.addToReservedCustomer(rc);

        ResDao.removeFromReservedCustomer(rc);

//        System.out.println(hc.hotelUpdate());
//        System.out.println(hc.cusUpdate());
//        RC = new ;
//        ReservedCustomerDao ResDao = new ReservedCustomerDaoImp();
//        ResDao.addToReservedCustomer(RC);
//        return RC;
    }

    private static void checkRoomStatus() {

//        HotelCounter hc = new HotelCounter(p,);
//        PetHotel p = new PetHotel("samsahai");
//        hc.hotelUpdate(p);
    }

    private static void checkMyStatus() {
        System.out.println("Metho CheckStatus");
    }

    private static void cancelBooking() {
        HotelCounter hc = new HotelCounter();
        PetHotel p = new PetHotel("samsahai");
        ReservedCustomers rc = new ReservedCustomers();
        hc.cancelled();
    }

    public static Pet addPet() {
        Scanner sc = new Scanner(System.in);
        Pet pet = null;
        System.out.println("Name : ");
        String name = sc.nextLine();
        System.out.println("Age : ");
        String age = sc.nextLine();
        pet = new Pet(name, age, PetType.RABBIT);
        return pet;
    }

    public static Customers addCust() {
        Scanner sc = new Scanner(System.in);
        Customers customer = null;
        Pet pet = addPet();
        System.out.println("ID : ");
        String id = sc.nextLine();
        System.out.println("Firstname : ");
        String f = sc.nextLine();
        System.out.println("Lastname : ");
        String l = sc.nextLine();
        System.out.println("Phone : ");
        String phone = sc.nextLine();
        customer = new Customers(id, f, l, phone, pet);
        return customer;
    }

    public static ReservedCustomers reCus() {
        Customers customer = addCust();
        ReservedCustomers reservedCustomers = new ReservedCustomers(RoomType.DELUXE, customer);
        reservedCustomers.setReservedActivities(Activities.EXERCISE);
        return reservedCustomers;
    }

    public static HotelCounter hotelCounter() {
        HotelCounter hotelCounter = null;
        ReservedCustomerDao resDao = new ReservedCustomerDaoImp();
        ReservedCustomers reservedCustomers = reCus();
        hotelCounter = new HotelCounter(petHotel, reservedCustomers);
        hotelCounter.reserved();
        resDao.addToReservedCustomer(reservedCustomers);
        return hotelCounter;
    }
}
