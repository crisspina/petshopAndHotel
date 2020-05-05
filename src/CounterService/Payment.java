
package CounterService;
import  Activities.ActivitiesFee;
import Customers.ReservedCustomers;
import pethotel.PetHotel;

public interface Payment extends ActivitiesFee {
    public  int checkBill();
    public  void printSlip(); 
}
