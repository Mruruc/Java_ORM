# What is the N+1 Problem?

The N+1 problem occurs when an application executes N additional SQL queries to fetch associated entities for each entity in a result set. This typically happens in scenarios where you have a `OneToMany` or `ManyToOne` relationship.

## Example Scenario

Consider two entities: `Employee` and `Department`. An `Employee` belongs to a `Department`, and a `Department` can have many `Employees`.

If you run a query to fetch all employees and their departments, the following might happen:

1. One query is executed to fetch all employees (1 query).
2. For each employee, an additional query is executed to fetch the associated department (N queries).

Thus, if there are 100 employees, you end up executing 101 queries (1 + N), which can significantly impact performance.

#### Example Code with N+1 Problem
````java
public static void main(String[] args) {
    try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {
        List<Employee> employees = entityManager
                .createQuery("FROM Employee", Employee.class)
                .getResultList();

        for (Employee employee : employees) {
            System.out.println(employee.getDepartment().getDepartmentName());
        }
    }
    JPAUtil.shutDown();
}
````
# Solutions to the N+1 Problem in JPA

## 1. Fetch Joins

Fetch joins can be used to fetch associated entities in a single query, thereby eliminating the N+1 problem.

```java
public static void main(String[] args) {
    try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {
        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee e JOIN FETCH e.department", Employee.class)
                .getResultList();

        for (Employee employee : employees) {
            System.out.println(employee.getDepartment().getDepartmentName());
        }
    }
    JPAUtil.shutDown();
}
````
In this query, JOIN FETCH is used to fetch employees along with their associated departments in a single query.

## 2. Entity Graphs

Entity graphs can be used to specify the fetch plan at runtime, ensuring associated entities are fetched with the main query.

```java
public static void main(String[] args) {
    try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {
        EntityGraph<Employee> entityGraph = entityManager.createEntityGraph(Employee.class);
        entityGraph.addAttributeNodes("department");

        List<Employee> employees = entityManager
                .createQuery("FROM Employee", Employee.class)
                .setHint("jakarta.persistence.fetchgraph", entityGraph)
                .getResultList();

        for (Employee employee : employees) {
            System.out.println(employee.getDepartment().getDepartmentName());
        }
    }
    JPAUtil.shutDown();
}
```
Here, an EntityGraph is used to fetch employees and their associated departments in a single query.