package org.chdtu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        Person person = context.getBean(Person.class);

        System.out.println("\n=== Інформація про людину ===");
        System.out.println("Прізвище: " + person.getSurname());
        System.out.println("Вік: " + person.getAge());

        System.out.println("\n=== Викликаємо собаку ===");
        person.callYourPet();

        Dog dog = (Dog) person.getPet();
        System.out.println("\nСобака: " + dog.getName());
        System.out.println("Нашийник: " + dog.getCollar());

        context.close(); // ← тут викличуться всі @PreDestroy
    }
}