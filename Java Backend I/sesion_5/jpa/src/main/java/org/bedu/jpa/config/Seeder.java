package org.bedu.jpa.config;

import org.bedu.jpa.model.Person;
import org.bedu.jpa.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements CommandLineRunner {
    private IPersonRepository repository;

    @Autowired
    public Seeder(IPersonRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String[] args){
        Person p1 = new Person();
        p1.setId(1);
        p1.setName("Carlos");
        p1.setLastName("Elizalde");
        p1.setAge(26);

        Person p2 = new Person();
        p2.setId(2);
        p2.setName("Joaquin");
        p2.setLastName("Ballarta");
        p2.setAge(42);

        Person p3 = new Person();
        p3.setId(3);
        p3.setName("Marisela");
        p3.setLastName("Gonzalez");
        p3.setAge(19);

        repository.save(p1);
        repository.save(p2);
        repository.save(p3);
    }
}
