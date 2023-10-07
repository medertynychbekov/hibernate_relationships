package org.example;

import org.example.model.License;
import org.example.model.Person;
import org.example.model.Pet;
import org.example.model.SocialMedia;
import org.example.model.enums.Category;
import org.example.service.PersonService;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        PersonService personService = new PersonService();

        Person user = new Person("user", "user last_name");
        Person admin = new Person("admin", "last_name");

        License license = new License(444555, Category.D);

        license.setPerson(user);
        user.setLicense(license);

        Pet cat = new Pet("Garfield", 2);
        Pet dog = new Pet("Aktosh", 5);

        cat.setPerson(user);
        dog.setPerson(user);

        user.setPets(new ArrayList<>(Arrays.asList(cat, dog)));

        SocialMedia instagram = new SocialMedia("instagram", 10_000_000);
        SocialMedia facebook = new SocialMedia("facebook", 5_000_000);

        instagram.setPersonList(new ArrayList<>(Arrays.asList(user, admin)));
        facebook.setPersonList(new ArrayList<>(Arrays.asList(user, admin)));

        user.setSocialMediaList(new ArrayList<>(Arrays.asList(instagram, facebook)));
        admin.setSocialMediaList(new ArrayList<>(Arrays.asList(instagram, facebook)));

        personService.save(user);
        personService.save(admin);
    }
}
