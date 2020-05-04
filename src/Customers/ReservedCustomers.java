package Customers;

import Activities.Activities;
import CounterService.ReservedStatus;
import Room.RoomType;
import java.util.Scanner;

public class ReservedCustomers {

    private RoomType resRoom;
    private Activities resAct;
    private int countAct;
    private Customers customer;
    private ReservedStatus status;
    private int amount;

    public ReservedCustomers() {
        this.countAct = 0;
    }

    public ReservedCustomers(RoomType resRoom, Customers customer) {
        this.resRoom = resRoom;
        this.customer = customer;
        setReservedActivities();
    }
    
    public void setReservedActivities() {
        int choice = 0;
        Scanner sn = new Scanner(System.in);
        System.out.println("choosing Activities: ");
        System.out.println("\t 1. GROOMING");
        System.out.println("\t 2. PLAYTIME");
        System.out.println("\t 3. GARDEN");
        System.out.println("\t 4. EXERCISE");
        System.out.println("\t 5. MESSAGEANDSPA");
        System.out.println("\t 6. PHOTOSET");
        System.out.print("Enter your number activities: ");

            choice = sn.nextInt();
            switch (choice) {
                case 1:
                    this.resAct = Activities.GROOMING;
                    break;
                   
                case 2:
                    this.resAct = Activities.PLAYTIME;
                    break;
                case 3:
                    this.resAct = Activities.GARDEN;
                     break;
                case 4:
                    this.resAct = Activities.EXERCISE;
                    break;
                case 5:
                    this.resAct= Activities.MESSAGEANDSPA;
                    break;
                case 6:
                    this.resAct= Activities.PHOTOSET;
                     break;
                   
            }
            if(choice <= 6 ) {

                System.out.print("---------Activities for your pet: ");
                System.out.print( resAct);
                System.out.print("-------------------"+"\n");
            }
            if(choice>7){
                System.out.println("error insert value between 1-7");
            }

            setStatus(ReservedStatus.PROCESSING);
                    } 

    public int getCountAct() {
        return countAct;
    }


    public RoomType getResRoom(){
        return this.resRoom;
    }

    public Activities getResAct() {
        return this.resAct;
    }

    public Customers getCustomers() {
        return this.customer;
    }

    public ReservedStatus getStatus() {
        return this.status;
    }

    public void setStatus(ReservedStatus rs) {
        this.status = rs;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public int getAmount() {
        return this.amount;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: " + getCustomers());
        sb.append("\n");
        sb.append("reserved room: " + getResRoom());
        sb.append("\n");
        sb.append("reserved activities: ");
        sb.append(this.resAct);
        sb.append("\n");
        sb.append("amount due: " + getAmount());
        sb.append("\n");
        sb.append("status: " + getStatus());

        return sb.toString();
    }



}
