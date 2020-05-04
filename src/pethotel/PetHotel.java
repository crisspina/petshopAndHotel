package pethotel;

import CounterService.HotelCounter;
import Customers.Pet;
import Customers.PetType;
import Customers.ReservedCustomers;
import Room.HotelRoom;
import Room.RoomType;

import java.util.Scanner;

public class PetHotel {

    private HotelRoom hr;
    private String name;
//    private HotelCounter hc;

    public PetHotel(String name) {
       this.name=name;
       this.hr= new HotelRoom();
    }


    public String getHotelName() {
        return name;
    }

    public HotelRoom getHr() {
        return hr;
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getHotelName() + " Hotel");
        sb.append("\n");
        sb.append("Hotel room information " + hr.toString());
        return sb.toString();
    }

}
