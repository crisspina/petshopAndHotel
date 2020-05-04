package Room;

import Customers.Customers;
import Customers.ReservedCustomers;
import java.util.Iterator;

public class HotelRoom{

    private Room[] dRooms;
    private Room[] supRooms;
    private Room[] stdRooms;
    private int countDe, countStd, countSup;
  

    public HotelRoom() {
        createRoom();
        createRoomrunningNumber();
        this.countDe=0;
        this.countStd=0;
        this.countSup=0;
    }

    public void createRoom() {
        this.dRooms = new Room[RoomInformation.MAX_DELUXE];
        this.stdRooms = new Room[RoomInformation.MAX_STANDARD];
        this.supRooms = new Room[RoomInformation.MAX_SUPERIOR];
    }

    public void createRoomrunningNumber() {
        for (int i = 0; i < supRooms.length; i++) {
            supRooms[i] = new Room("Sup" + (i + 1), RoomType.SUPERIOR);
        }
        for (int i = 0; i < dRooms.length; i++) {
            dRooms[i] = new Room("De" + (i + 1), RoomType.DELUXE);
        }
        for (int i = 0; i < stdRooms.length; i++) {
            stdRooms[i] = new Room("Std" + (i + 1), RoomType.STANDARD);
        }

    }

    
    public Room getdRooms(int index) {
        return dRooms[index];
    }

    public Room getSupRooms(int index) {
        return supRooms[index];
    }

    public Room getStdRooms(int index) {
        return stdRooms[index];
    }

    public void setdRoom(int index, ReservedCustomers c) {
        this.dRooms[index].setRc(c);
    }

    public void setSupRoom(int index, ReservedCustomers c) {
        this.supRooms[index].setRc(c);
    }

    public void setStdRoom(int index, ReservedCustomers c) {
        this.stdRooms[index].setRc(c);
    }

    public int getDRoomLength() {
        return this.dRooms.length;
    }

    public int getStdRoomLength() {
        return this.stdRooms.length;
    }

    public int getSupRoomLength() {
        return this.supRooms.length;
    }

    public int getCountDe() {
        return countDe;
    }

    public int getCountStd() {
        return countStd;
    }

    public int getCountSup() {
        return countSup;
    }

    public void addCountDe() {
        this.countDe = countDe+1;
    }

    public void addCountStd() {
        this.countStd = countStd+1;
    }

    public void addCountSup() {
        this.countSup = countSup+1;
    }

    public void minusCountDe() {
        this.countDe = countDe-1;
    }

    public void minusCountStd() {
        this.countStd = countStd-1;
    }

    public void minusCountSup() {
        this.countSup = countSup-1;
    }

    @Override
    public  String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" : A number of Available room for reserve:  ");
        sb.append("\n");
        sb.append("Deluxe Room: ");
        sb.append("We have " + (RoomInformation.MAX_DELUXE-countDe) + " rooms");
        sb.append("\n");
        sb.append("There are: ");
        for (int i = 0; i < dRooms.length; i++) {
            sb.append(dRooms[i].toString());
            sb.append("\t");
        }
        sb.append("\n");
        sb.append("Superior Room: ");
        sb.append("We have " + (RoomInformation.MAX_SUPERIOR-countSup) + " rooms");
        sb.append("\n"); 
        sb.append("There are: ");
        for (int i = 0; i < supRooms.length; i++) {
            sb.append(supRooms[i].toString());
             sb.append("\t");
        }
        sb.append("\n");
        sb.append("Standard Room: ");
        sb.append("We have " + (RoomInformation.MAX_STANDARD-countStd) + " rooms");
        sb.append("\n");
        sb.append("There are: ");
        for (int i = 0; i < stdRooms.length; i++) {
            sb.append(stdRooms[i].toString());
             sb.append("\t");
        }
        sb.append("\n");
        return sb.toString();
    }

}

