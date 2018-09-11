# spring-hibernate-crm-api-rest
REST API for Tiny Customer Relationship Manager (CRM) with a Customer entity CRUD

## Configuration

- Spring Framework 5.8.0
- Spring Web MVC 5.8.0
- Spring Security 5.7.0
- Servlet API 3.1.0
- Servlet JSP API 2.3.1
- Servlet JSTL 1.2
- Hibernate 5.3.0.Final
- MySQL Java Connector 8.0.12
- C3P0 0.9.5.2
- Jackson 2.9.5

## Use case

REST API for Tiny Customer Relationship Manager (CRM) with a Customer entity CRUD

- Basic Authentication
- CRUD (Create Read Update Delete):
  - C - CREATE:
		Http.POST	=> 	addCustomer(Customer)
  - R - READ:
		Http.GET	=>	getCustomers()
		Http.GET	=>	getCustomer(int)
  - U - UPDATE:
		Http.PUT	=>	updateCustomer(Customer)
  - D - DELETE:
		Http.DELETE	=>	deleteCustomer(int)
- Customized exceptions for Customer Not Found and for any other.

The following features are covered:

- Spring Java Configuration. No XML configuration is used in this project at all. But, just to clarify: I'm not against; it's just the chosen strategy.
  - Two DataSource's created (Customer and Spring Security DB's)
    - SessionFactory Bean support
    - HibernateTransactionManager support
- Spring Security:
  - Basic Authentication to access the REST API
- Spring MVC
  - Controller for the main Customer operations
  - Independent Service (transactional) and DAO layers
- Hibernate
  - Customer Entity
  - Main database operations

## Getting started

To get this Maven project working:

- Database
  - Install latest MySQL version
  - Execute two scripts:
    - `01-create-user.sql`
    - `02-customer-tracker.sql`
    - `03-setup-spring-security-bcrypt-demo-database.sql`
  - A user (springstudent/springstudent) and two databases are created:
    - [Spring Security Database](https://github.com/pgbonino/spring-hibernate-crm-api-rest/blob/master/sql-scripts/spring-security-demo-database.png)
    - [Customer Database](https://github.com/pgbonino/spring-hibernate-crm-api-rest/blob/master/sql-scripts/customer-database.png)
  - Note that the first script creates three users with the following access details:
     - john/fun123/[ROLE_EMPLOYEE]
     - mary/fun123/[ROLE_EMPLOYEE, ROLE_MANAGER]
     - susan/fun123/[ROLE_EMPLOYEE, ROLE_ADMIN]
  - The roles are not relevant in this project
  - Note that passwords are stored using bscrypt algorithm.  

- Java
  - Clone this repo
  - Build using Maven
  - In your IDE, run the application on a Server (I use Tomcat 9.0)
  - Install Postman on your computer (a postman collection JSON export is stored in this location:
    - [Postman Collection](https://github.com/pgbonino/spring-hibernate-crm-api-rest/blob/master/sql-scripts/spring-hibernate-crm-api-rest.postman_collection.json)
  - Play around