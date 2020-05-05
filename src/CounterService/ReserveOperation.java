
package CounterService;

import Customers.ReservedCustomers;
import pethotel.PetHotel;

public interface ReserveOperation {
public void reserved();
public void cancelled();
public int search();
public void setStatustoReservedCustomers();

}
