package org.chdtu;

public class Dog implements Pet {
    private Collar collar;
    private String name;

    public Dog() {
        System.out.println("Dog bean is created (no-arg constructor)");
    }

    public Dog(Collar collar) {
        System.out.println("Dog bean is created with Collar");
        this.collar = collar;
    }

    @Override
    public void say() {
        System.out.println("Woof-woof!");
    }
    public void setCollar(Collar collar) {
        System.out.println("Class Dog: set Collar");
        this.collar = collar;
    }

    public void setName(String name) {
        System.out.println("Class Dog: set name = " + name);
        this.name = name;
    }

    public Collar getCollar() {
        return collar;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dog{name='" + name + "', collar=" + collar + "}";
    }
}