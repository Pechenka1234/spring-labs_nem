package org.chdtu;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Pet {

    private Collar collar;
    @Value("${dog.name}")
    private String name;

    public Dog() {
        System.out.println("Dog bean is created (no-arg constructor)");
    }

    @Autowired
    public Dog(Collar collar) {
        System.out.println("Dog bean is created with Collar (constructor injection)");
        this.collar = collar;
    }

    @PostConstruct
    public void init() {
        System.out.println("Dog: init-method called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Dog: destroy-method called");
    }

    @Override
    public void say() {
        System.out.println("Woof-woof!");
    }

    public Collar getCollar() { return collar; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Dog{name='" + name + "', collar=" + collar + "}";
    }
}