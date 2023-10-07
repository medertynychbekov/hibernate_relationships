package org.example.config;

import org.example.model.License;
import org.example.model.Person;
import org.example.model.Pet;
import org.example.model.SocialMedia;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static SessionFactory getSessionFactory() {
        return new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(License.class)
                .addAnnotatedClass(Pet.class)
                .addAnnotatedClass(SocialMedia.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

//    public static SessionFactory getSessionFactory(){
//        SessionFactory sessionFactory = null;
//
//        try {
//            sessionFactory = new Configuration()
//                    .configure("hibernate.cfg.xml")
//                    .addAnnotatedClass(Person.class)
//                    .buildSessionFactory();
//        }catch (HibernateError e){
//            System.out.println(e.getMessage());
//        }
//        return sessionFactory;
//    }
}
