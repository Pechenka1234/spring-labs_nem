package org.chdtu;

import org.chdtu.repository.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        PersonRepository personRepo = context.getBean(PersonRepository.class);
        DogRepository dogRepo = context.getBean(DogRepository.class);
        CollarRepository collarRepo = context.getBean(CollarRepository.class);

        personRepo.deleteAll();
        dogRepo.deleteAll();
        collarRepo.deleteAll();

        Collar collar = new Collar();
        collar.setColor("Red");
        collar.setSize(40);

        Dog sharik = new Dog();
        sharik.setName("Sharik");
        sharik.setCollar(collar);

        Person person = new Person();
        person.setSurname("Ivanov");
        person.setAge(30);
        person.setFavoriteDog(sharik);

        collarRepo.save(collar);
        dogRepo.save(sharik);
        personRepo.save(person);

        System.out.println("Успішно збережено!");

        Person fromDb = personRepo.findById(person.getId()).orElse(null);
        System.out.println("З БД: " + fromDb);
        System.out.println("Собака: " + fromDb.getFavoriteDog().getName());
        System.out.println("Нашийник: " + fromDb.getFavoriteDog().getCollar());

        context.close();
    }
}