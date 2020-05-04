
package CounterService;

import Customers.ReservedCustomers;
import pethotel.PetHotel;

public interface ReserveOperation {
public void reserved(PetHotel p,ReservedCustomers c);
public void cancelled(PetHotel p,ReservedCustomers c);
public int search(PetHotel p,ReservedCustomers c);
public void setStatustoReservedCustomers(PetHotel p,ReservedCustomers c);

}
