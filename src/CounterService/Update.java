
package CounterService;

import Customers.ReservedCustomers;
import pethotel.PetHotel;

public interface Update {
     public String cusUpdate(ReservedCustomers c);
     public String hotelUpdate(PetHotel petHotel);
}
