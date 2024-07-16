package com.mruruc.hql_query_language;

import com.mruruc.model.Employee;
import com.mruruc.model.User;
import com.mruruc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

/**
 * HQL(Hibernate Query Language): is a query language for Hibernate entities.
 * Hql allows developer to write queries against database with leveraging object model defined in Java Classes.
 **/
public class HQLQueries {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        // Select statement
        // Syntax: FROM EntityName WHERE conditions
        // Entities can be aliased to make query more readable, ex: FROM EntityName e

//        String hql = "FROM Employee ";
//        Query<Employee> query = session.createQuery(hql, Employee.class);
//        List<Employee> list = query.list();
//        System.out.println(list);

        // SELECT statement for specific properties:
        String hql_SELECT = "SELECT e.firstName, e.lastName FROM Employee e";
        String hql_SELECT2 = "SELECT new Employee(e.firstName, e.lastName) FROM Employee e WHERE e.salary > 4500";

//        Query<Employee> query = session.createQuery(hql_SELECT2, Employee.class);
//        System.out.println(query);
//        query.list()
//                .forEach(System.out::println);
//
        // ORDER BY
        String hql_ORDER_BY = "FROM Employee e WHERE e.salary > 4000 ORDER BY e.salary ASC";

        // HQL supports aggregate functions like COUNT, AVG, SUM, MIN, and MAX
        String hql_AGGREGATE_FUNC = "SELECT SUM(e.salary) FROM Employee e ";
//        Query<Double> query = session.createQuery(hql_AGGREGATE_FUNC, Double.class);
//        System.out.println(query.getSingleResult());


        session.close();
        sessionFactory.close();
    }
}


// sample data

//        Transaction transaction = session.beginTransaction();
//
//        session.persist(new Employee("John","Doe","john_doe@hotmail.com",4200.0, LocalDate.of(2019,7,5)));
//        session.persist(new Employee("Jane", "Smith", "jane_smith@gmail.com", 4500.0, LocalDate.of(2020, 3, 12)));
//        session.persist(new Employee("Michael", "Johnson", "michael_johnson@yahoo.com", 5000.0, LocalDate.of(2018, 11, 23)));
//        session.persist(new Employee("Emily", "Davis", "emily_davis@outlook.com", 4300.0, LocalDate.of(2019, 6, 1)));
//        session.persist(new Employee("Daniel", "Martinez", "daniel_martinez@gmail.com", 4700.0, LocalDate.of(2021, 8, 17)));
//        session.persist(new Employee("Laura", "Brown", "laura_brown@hotmail.com", 4200.0, LocalDate.of(2018, 4, 10)));
//        session.persist(new Employee("Kevin", "Wilson", "kevin_wilson@gmail.com", 4600.0, LocalDate.of(2020, 9, 29)));
//        session.persist(new Employee("Rachel", "Moore", "rachel_moore@yahoo.com", 4400.0, LocalDate.of(2019, 5, 21)));
//        session.persist(new Employee("Matthew", "Taylor", "matthew_taylor@outlook.com", 4800.0, LocalDate.of(2021, 12, 14)));
//        session.persist(new Employee("Anna", "Anderson", "anna_anderson@gmail.com", 4500.0, LocalDate.of(2020, 7, 7)));
//        session.persist(new Employee("David", "Thomas", "david_thomas@hotmail.com", 4900.0, LocalDate.of(2018, 10, 5)));
//
//        transaction.commit();
