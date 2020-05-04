
package CounterService;

import Customers.ReservedCustomers;
import Room.RoomInformation;
import pethotel.PetHotel;


public interface Check{
    
    public  boolean checkReserveHistory(PetHotel p,ReservedCustomers c);
    public  boolean checkIsFull(PetHotel p,ReservedCustomers c);
   
    
}
