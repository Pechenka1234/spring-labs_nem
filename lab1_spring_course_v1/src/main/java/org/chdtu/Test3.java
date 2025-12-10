package org.chdtu;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Person person = context.getBean("person", Person.class);

        System.out.println("\n=== Інформація про людину ===");
        System.out.println("Прізвище: " + person.getSurname());
        System.out.println("Вік: " + person.getAge());

        System.out.println("\n=== Викликаємо собаку ===");
        person.callYourPet();

        Dog dog = (Dog) person.getPet();
        System.out.println("\nСобака: " + dog.getName());
        System.out.println("Нашийник: " + dog.getCollar());

        context.close();
    }
}