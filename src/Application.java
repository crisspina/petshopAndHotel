

//
//import Customers.Customers;
//import Customers.GeneralList;
//import Dao.CustomerDao;
//import dataaccess.CustomerDaoImp;
//import java.util.Scanner;
//
//
//public class Application {
//    
//        static String menu = "----------<<PETS HOTEL>>----------\n"
//            + "1. list all customers\n" // name id
//            + "3. List all pets\n"   //(petlish)name age type
//            + "4. List All Acivities\n"   
//            + "5. l"
//            + "5. List all room\n" //list room and status
//            + "0. exit\n"
//            + ">>>>>Select menu: " ;
//        static Scanner input = new Scanner(System.in);
//        static CustomerDao custDao = new CustomerDaoImp();
//        
//        
//          public static void main(String[] args) {
//        int select;
//        do {
//            select = menuSelection();
//            switch (select) {
//                case 1: //list all customers
//                    listCustomer();
//                    break;
//                case 2: //list all pets
//                    addCustomer();
//                    break;
//                case 3: //list all activities
//                    listProduct();
//                    break;
//                case 4: //list all room
//
//                    break;
//                case 5://show wishlist
//            }
//        } while (select != 0);
//        System.out.println("Good by");
//    }
//          
//           public static int menuSelection() {
//        System.out.print("\n----------------------------\n");
//        System.out.print(menu);
//        return input.nextInt();//Integer.parseInt(input.nextLine());
//    }
//
//    private static void listCustomer() {
//        GeneralList<Customers> custs = custDao.getAll()  ;
//        int i = 0;
//        for (Customers temp : custs) {
//            System.out.println(i++ + ". " + temp);
//        }
//    }
//
//    private static void addCustomer() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private static void listProduct() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

   
    
