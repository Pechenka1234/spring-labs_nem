package org.chdtu;

import jakarta.persistence.*;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "collars")
@Component
@Data
public class Collar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Value("${collar.color}")
    private String color;

    @Value("${collar.size}")
    private int size;

    // ТВІЙ СТАРИЙ КОНСТРУКТОР — ЗАЛИШАЄМО!
    public Collar() {
        System.out.println("Collar bean is created");
    }

    @PostConstruct
    public void init() {
        System.out.println("Collar: init-method called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Collar: destroy-method called");
    }

    @Override
    public String toString() {
        return "Collar{id=" + id + ", color='" + color + "', size=" + size + "}";
    }
}