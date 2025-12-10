package org.chdtu;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Collar {

    @Value("${collar.color}")
    private String color;

    @Value("${collar.size}")
    private int size;

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

    public String getColor() { return color; }
    public int getSize() { return size; }

    @Override
    public String toString() {
        return "Collar{color='" + color + "', size=" + size + "}";
    }
}