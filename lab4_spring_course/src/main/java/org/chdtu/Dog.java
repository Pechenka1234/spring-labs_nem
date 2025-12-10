package org.chdtu;

import jakarta.persistence.*;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Entity
@Table(name = "dogs")
@Component
@Data
public class Dog implements Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Value("${dog.name}")
    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "collar_id")
    private Collar collar;

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
}