package Customers;


import java.util.Objects;
import java.util.Scanner;

public class Customers {
    private String IdNumber;
    private String fName;
    private String lName;
    private String phoneNumber;
    private Pet pet;

    public Customers(){
        
    }
    
    public Customers(String IdNumber, String fName, String lName, String phoneNumber,Pet pet) {
        this.IdNumber = IdNumber;
        this.fName = fName;
        this.lName = lName;
        this.phoneNumber = phoneNumber;
        this.pet = pet;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    
    public Pet getPet() {
        return pet;
    }

    public String getCustomerID() {
        return IdNumber;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customers other = (Customers) obj;
        if (this.IdNumber != other.IdNumber) {
            return false;
        }
        if (!Objects.equals(this.fName, other.fName)) {
            return false;
        }
        if (!Objects.equals(this.lName, other.lName)) {
            return false;
        }
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.pet, other.pet)) {
            return false;
        }
        return true;
    }

    
  

    @Override
    public String toString() {
        return "Customers{" + "Customer ID: " + IdNumber + ", Customer name: " + fName +" " + lName + ", Phone Number: " + phoneNumber +" your pet: "+getPet()+'}';
    }
    
    
}
