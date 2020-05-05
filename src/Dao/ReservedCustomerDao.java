package Dao;

import Customers.ReservedCustomers;

public interface ReservedCustomerDao {
    int addToReservedCustomer(ReservedCustomers obj);
    int removeFromReservedCustomer(ReservedCustomers obj);
}
