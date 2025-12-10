package org.chdtu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Person {

    @Autowired
    private Pet pet;

    @Value("${person.surname}")
    private String surname;

    @Value("${person.age}")
    private int age;

    public Person() {
        System.out.println("Person bean is created");
    }

    @PostConstruct
    public void init() {
        System.out.println("Person: init-method called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Person: destroy-method called");
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely pet");
        pet.say();
    }

    public Pet getPet() { return pet; }
    public String getSurname() { return surname; }
    public int getAge() { return age; }
}