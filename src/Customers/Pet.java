
package Customers;

import java.util.Objects;
import java.util.Scanner;

public class Pet {
    private String name;
    private String age;
    private PetType type;
    
    public Pet(){
    
}
    public Pet(String name, String age,PetType type) {
        this.name = name;
        this.age = age;
        this.type=type;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public PetType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Pet{" + "name: " + name + ", age: " + age + ", type: " + type + '}';
    }

    
}

