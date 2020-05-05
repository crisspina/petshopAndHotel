
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
    static ReservedCustomers recus ;

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int menuId;
        do {
            System.out.println("WELCOME TO MY HOTEL");
            System.out.println("1.Reserved room");
            System.out.println("0. exit");
            System.out.print("Enter yout menu [0-1] : ");
            menuId = input.nextInt();
            switch (menuId) {
                case 1:
                    hotelCounter();
                    break;
            }
        } while (menuId == 1);
        System.out.println(">>>>>Exit<<<<<");
        System.out.println("Thank you");
        System.out.println("SAWASDEEKA");
        System.exit(0);
    }

    public static Pet addPet() {
        Scanner sc = new Scanner(System.in);
        Pet pet = null;
        PetType petType = null;

        System.out.println("-----Add PET-----");
        System.out.print("Enter pet name : ");
        String name = sc.nextLine();
        System.out.print("Enter pet age : ");
        String age = sc.nextLine();
        int choicePet;
        System.out.println("Pet type: ");
        System.out.println("\t 1. DOG ");
        System.out.println("\t 2. CAT ");
        System.out.println("\t 3. RABBIT");
        System.out.println("\t 4. RACOON ");
        System.out.print("Enter your number Pet type: ");
        choicePet = sc.nextInt();
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
        return pet;
    }

    public static Customers addCust() {
        Scanner sc = new Scanner(System.in);
        Customers customer = null;
        Pet pet = addPet();
        System.out.println("-----Create new Customer-----");
        System.out.print("Enter first name: ");
        String fName = sc.nextLine();
        System.out.print("Enter last name: ");
        String lName = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter Customer ID: ");
        String CustomerID = sc.nextLine();
        customer = new Customers(CustomerID, fName, lName, phoneNumber, pet);
        return customer;
    }

    public static ReservedCustomers reCus() {
        ReservedCustomers recus ;

        Scanner sc = new Scanner(System.in);
        ReservedCustomers reCus = null;
        Customers customer = addCust();
        System.out.println("-----Add Room-----");
        RoomType room;
        int choiceRoom;
        System.out.println("Room: ");
        System.out.println("\t 1. DELUXE");
        System.out.println("\t 2. SUPERIOR");
        System.out.println("\t 3. STANDARD");
        System.out.print("Enter your number Room: ");
        choiceRoom = sc.nextInt();
        switch (choiceRoom) {
            case 1:
                room = RoomType.DELUXE;
                System.out.println("Test");
                reCus = new ReservedCustomers(room, customer);
                break;
            case 2:
                room = RoomType.SUPERIOR;
                reCus = new ReservedCustomers(room, customer);
                break;
            case 3:
                room = RoomType.STANDARD;
                reCus = new ReservedCustomers(room, customer);
                break;
        }

        System.out.println("_______________________________");
        System.out.println("-----Add Activities for your pet-----");
        Activities act = null;
        int choiceAct;
        System.out.println("Activities: ");
        System.out.println("\t 1. GROOMING");
        System.out.println("\t 2. PLAYTIME ");
        System.out.println("\t 3. GARDEN");
        System.out.println("\t 4. EXERCISE ");
        System.out.println("\t 5. MESSAGEANDSPA");
        System.out.println("\t 6. PHOTOSET");
        System.out.print("Enter your number Activities: ");
        choiceAct = sc.nextInt();
        switch (choiceAct) {
            case 1:
                act = Activities.GROOMING;
                reCus.setReservedActivities(act);
                break;
            case 2:
                act = Activities.PLAYTIME;
                reCus.setReservedActivities(act);
                break;
            case 3:
                act = Activities.GARDEN;
                reCus.setReservedActivities(act);
                break;
            case 4:
                act = Activities.EXERCISE;
                reCus.setReservedActivities(act);
                break;
            case 5:
                act = Activities.MESSAGEANDSPA;
                reCus.setReservedActivities(act);
                break;
            case 6:
                act = Activities.PHOTOSET;
                reCus.setReservedActivities(act);
                break;
        }
        recus = reCus;
        return recus;

    }

    public static ReservedCustomers Cancelled() {
        ReservedCustomers rc = null;
        HotelCounter hc = hotelCounter();
        ReservedCustomerDao resDao = new ReservedCustomerDaoImp();
        System.out.println("Do you want to cancel the reservation?");
        System.out.println("1.No");
        System.out.println("2.Yes");
        int menu;
        menu = input.nextInt();
        switch (menu) {
            case 1:
                System.out.println("reservation confirmmed");
                return rc;

            case 2:
                hc.cancelled();
                resDao.removeFromReservedCustomer(rc);
                break;
        }
        return rc;
    }

    public static HotelCounter hotelCounter() {
        HotelCounter hotelCounter = null;
        ReservedCustomerDao resDao = new ReservedCustomerDaoImp();
        ReservedCustomers reservedCustomers = reCus();
        hotelCounter = new HotelCounter(petHotel, reservedCustomers);
        System.out.println( hotelCounter.hotelUpdate() );
        hotelCounter.reserved();
        hotelCounter.checkBill();
        resDao.addToReservedCustomer(reservedCustomers);
        System.out.println(reservedCustomers.toString());
 
        return hotelCounter;
    }
}
