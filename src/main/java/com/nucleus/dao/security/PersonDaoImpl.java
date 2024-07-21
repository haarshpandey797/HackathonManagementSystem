package com.nucleus.dao.security;

import com.nucleus.model.security.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PersonDaoImpl implements PersonDao{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Person getPerson(String personName) {
        Session session = sessionFactory.openSession();

        return session.createQuery("FROM Person WHERE personName = :personName", Person.class)
                .setParameter("personName", personName)
                .uniqueResult();

    }

    @Override
    public void insertPerson(int id) {
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Person person = new Person(Integer.toString(id) ,  "$2a$10$I5NggY9aTiPBigDGZCtgVOZDSHMo9j.WvR7cQCosmchICkosxrhha" , "ADMIN" ,1);
        session.save(person);
        transaction.commit();
        session.close();
    }



}
