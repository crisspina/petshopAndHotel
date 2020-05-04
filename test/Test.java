
import CounterService.HotelCounter;
import Customers.Customers;
import Customers.Pet;
import Customers.PetType;
import Customers.ReservedCustomers;
import Room.RoomType;
import pethotel.PetHotel;

//create object not recieve input //เทส สัตว์ ลูกค้า ลูกค้าจองได้แล้ว
public class Test {

    static void testPet() {
        Pet p1 = new Pet("pretty", "10", PetType.DOG, "0816903023");
        Pet p2 = new Pet("obog", "3", PetType.DOG, "0912369854");

        System.out.println(p1);
        System.out.println(p2);
    }

    static void testCustomer() {
        Pet p1 = new Pet("pretty", "10", PetType.DOG, "0816903023");
        Pet p2 = new Pet("obog", "3", PetType.DOG, "0912369854");

        Customers c1 = new Customers("1909856987412", "praepanwa", "phaeng", "0816903023", p1);
        Customers c2 = new Customers("9855697744113", "jungwoo", "kim", "0693214568", p2);
        System.out.println(c1);
        System.out.println(c2);
    }

    static void testReservedCustomer() {
        Pet p1 = new Pet("pretty", "10", PetType.DOG, "0816903023");
        Pet p2 = new Pet("obog", "3", PetType.DOG, "0912369854");
        Pet p3 = new Pet("bobby", "5", PetType.RABBIT, "0366985214");

        Customers c1 = new Customers("1909856987412", "praepanwa", "phaeng", "0816903023", p1);
        Customers c2 = new Customers("9855697744113", "jungwoo", "kim", "0693214568", p2);
        Customers c3 = new Customers("3100136699552", "jrpat", "guy", "0816903023", p3);

        ReservedCustomers rc1 = new ReservedCustomers(RoomType.DELUXE, c1);
        ReservedCustomers rc2 = new ReservedCustomers(RoomType.DELUXE, c2);
        ReservedCustomers rc3 = new ReservedCustomers(RoomType.DELUXE, c3);
        System.out.println(rc1);
        System.out.println(rc2);
        System.out.println(rc3);
    }

    static void testHotelCounter() {
        PetHotel p = new PetHotel("samsahai");
        System.out.println(p);
        System.out.println("-----------------------------");
        Pet p1 = new Pet("pretty", "10", PetType.DOG, "0816903023");
        Pet p2 = new Pet("obog", "3", PetType.DOG, "0912369854");
        Pet p3 = new Pet("bobby", "5", PetType.RABBIT, "0366985214");
        Pet p4 = new Pet("vivi", "7", PetType.DOG, "0698523147");
        Pet p5 = new Pet("lhong", "1", PetType.CAT, "0894081600");
//        System.out.println(p1);

        Customers c1 = new Customers("1909856987412", "praepanwa", "phaeng", "0816903023", p1);
        Customers c2 = new Customers("9855697744113", "jungwoo", "kim", "0693214568", p2);
        Customers c3 = new Customers("3100136699552", "jrpat", "guy", "0816903023", p3);
        Customers c4 = new Customers("8419632587410", "sehun", "oh", "0816903023", p4);
        Customers c5 = new Customers("2013658922467", "sunanta", "gift", "0816903023", p5);
        //     System.out.println(c1);
        /*   ReservedCustomers rc1 = new ReservedCustomers(RoomType.DELUXE,c1);
        System.out.println(rc1);
        System.out.println("------------------------------------");
        HotelCounter h = new HotelCounter(p,rc1);
        System.out.println(h.cusUpdate(rc1));
        System.out.println("--------------------------");
        System.out.println(h.hotelUpdate(p));
        System.out.println(h.checkBill(rc1));*/
//        System.out.println(p);
//        
        ReservedCustomers rc2 = new ReservedCustomers(RoomType.DELUXE, c2);
        System.out.println(rc2);
        System.out.println("------------------------------------");
        HotelCounter h2 = new HotelCounter(p, rc2);
        h2.reserved(p, rc2);
        h2.checkBill(rc2);
        System.out.println("--------------HOTEL-------------");
        System.out.println(h2.cusUpdate(rc2));
        System.out.println(h2.hotelUpdate(p));
        System.out.println(h2.checkBill(rc2));
        System.out.println("------EXTRA-------------");
        h2.cancelled(p, rc2);
        System.out.println(h2.cusUpdate(rc2));
        System.out.println(h2.hotelUpdate(p));

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

    public static void main(String[] args) {
        testHotelCounter();

    }

}
