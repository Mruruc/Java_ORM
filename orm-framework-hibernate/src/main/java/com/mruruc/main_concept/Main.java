package com.mruruc.main_concept;

public class Main {

       /*
    public static void main(String[] args) {


        // configuration class read meta data from hibernate.cfg.xml
        Configuration configuration = new Configuration();
        configuration.configure();

        // session factory for Session objects. its is created once and is thread safe, used to create 'Session' instance.
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // A session is a single-threaded, short-lived object representing a conversation between the application and the database.
        // It is used to create, read and delete persistent object.
        Session session = sessionFactory.openSession();

        // Transactions in hibernate are used to ensure data integrity and consistency.
        // They are managed using Transaction interface.

        Transaction transaction = session.beginTransaction();
        TransactionStatus status = transaction.getStatus();
        System.out.println("Transaction Status: " + status);

//        User user = new User();
//        user.setUsername("jane@doe");
//        user.setPassword("raw_password");
//
//        session.persist(user);


        System.out.println(
                session.get(User.class, UUID.fromString("de4c8535-8575-4fc2-8014-8c2a94e44d42"))
        );

        transaction.commit();

        session.close();

        sessionFactory.close();

    }
         */
}
