package org.chdtu;

import jakarta.persistence.*;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Entity
@Table(name = "persons")
@Component
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Value("${person.surname}")
    private String surname;

    @Value("${person.age}")
    private int age;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "favorite_dog_id")
    private Dog favoriteDog;

    public Person() {
        System.out.println("Person bean is created");
    }

    @Autowired
    public void setPet(Pet pet) {
        if (pet instanceof Dog) {
            this.favoriteDog = (Dog) pet;
        }
    }

    @Transient
    private Pet pet;

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
}