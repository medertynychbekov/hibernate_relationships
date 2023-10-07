package org.example.service;

import org.example.config.HibernateUtil;
import org.example.model.Person;
import org.hibernate.Session;

public class PersonService {

    public void save(Person person){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.persist(person);
            session.getTransaction().commit();
        }
    }
}
