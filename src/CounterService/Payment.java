
package CounterService;
import  Activities.ActivitiesFee;
import Customers.ReservedCustomers;
import pethotel.PetHotel;

public interface Payment extends ActivitiesFee {
    public  int checkBill(ReservedCustomers c);
    public  void printSlip(ReservedCustomers c); //fileOutputStream
}
