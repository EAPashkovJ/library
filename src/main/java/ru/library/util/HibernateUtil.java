package ru.library.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {
    private static SessionFactory sessionFactory=initSessionFactory();

    private static SessionFactory initSessionFactory(){
        try {
            return new Configuration()
                    .configure(new File("src/main/resources/hibernate.cfg.xml"))
                    .buildSessionFactory();
        }catch (Exception e){
            e.printStackTrace();
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
