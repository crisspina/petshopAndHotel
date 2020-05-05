package Customers;

import Activities.Activities;
import CounterService.ReservedStatus;
import Room.RoomType;
import java.util.Scanner;

public class ReservedCustomers {

    private RoomType resRoom;
    private Activities resAct;
    private Customers customer;
    private ReservedStatus status;
    private int amount;

    public ReservedCustomers() {

    }

    public ReservedCustomers(RoomType resRoom, Activities resAct, Customers customer, ReservedStatus status, int amount) {
        this.resRoom = resRoom;
        this.resAct = resAct;
        this.customer = customer;
        this.status = status;
        this.amount = amount;
    }

    public ReservedCustomers(RoomType resRoom, Customers customer) {
        this.resRoom = resRoom;
        this.customer = customer;
    }

    public void setReservedActivities(Activities act) {
          this.resAct = act;
        setStatus(ReservedStatus.PROCESSING);
    }

    public RoomType getResRoom() {
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
