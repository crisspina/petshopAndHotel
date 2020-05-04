package Dao;

import Customers.Customers;
import Customers.GeneralList;
import Customers.Pet;
import Customers.ReservedCustomers;


public interface ReservedCustomerDao {
    int addToReservedCustomer(ReservedCustomers obj);

    int removeFromReservedCustomer(ReservedCustomers obj);
    GeneralList<ReservedCustomers> findCustomerByname(Customers obj);
    GeneralList<ReservedCustomers> findCustomerByPetname(String name);   //all โดยชื่อสัตว์

    ReservedCustomers loadyourStatus(Customers obj); //1 person
    
}
