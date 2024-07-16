## Java ORM

The repository aims to explain how ORM (Object-Relational Mapping) works in Java. It mainly explains Hibernate and its specification, JPA, and also includes how Spring Boot abstracts away the complexity. This tutorial repository's main focus is to teach how things work internally and how Spring Boot hides the complexity.

### Repository Has Many Subprojects and Each Subproject Has Its Own Documentation
- **ORM Framework Hibernate**
  - Explains how Hibernate manages entities through `SessionFactory`, `Session`, and the persistence context.

- **Intro JPA**
  - Explains how JPA sets a set of rules for its implementation through `EntityManagerFactory`, `EntityManager`, and `EntityTransaction`, as well as the persistence context.
  - Shows database interactions through `EntityManager` methods (persist, remove, find, etc.).
  - Demonstrates how to perform queries with JPQL, Criteria API, Native query, and so on.

- **JPA Associations**
  - Explains different types of entity association relationships and how to manage them with OOP.
  - Most importantly, it explains solutions and optimizations while fetching the associated entity (especially the N+1 problem and possible solutions).

- **Spring Boot JPA Starter**
  - Explains how Spring Data JPA abstracts away JPA and its implementation, dynamic query generation, as well as JPA repositories.

- **E-learning Platform**
  - A comprehensive project that includes major concepts in ORM and real-life challenges.

Overall, the repository focuses on explaining ORM in the Java programming language. The repository may contain bugs and outdated dependencies and is open for improvements and contributions.

