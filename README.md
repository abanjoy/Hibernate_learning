Frame Work
	Set of codes that are predefined to mak the task and operations easier to the programmer.
	A framework is a pre-built structure or platform that provides a foundation and set of tools for developing software applications. It offers
	reusable components, pre-written code, and guidelines to help developers efficiently create and organize their projects. Frameworks promote
	standardization and reduce the need to write repetitive code, allowing developers to focus on the unique aspects of their application.
	
	-> Reusable
	-> Inversion of Control -> Unlike libraries, where developers control the flow, frameworks often take control of the flow of an application. 
	-> Structure and Organisation -> eg: MVC
	-> Best practise and Standerds

HIBERNATE
	Is an alternative for JDBC.
	JDBC is used in DAO implementation classes

Entity class --> Class that represents the table called as Entity class in hibernate.
		Normally that type of class is called as Model class.
		but in hibernate we call it as Entity class because it is mapped to table
		That is when model class get mapped to table, then it is called as Entity class.

	POJO Class -> Any class with private members, constructors,setters and getters, toString methods.
	MODEL Class --> pojo class that represents a table in database.
	ENTITY Class --> Model class with some extra codes and which indicates each private members of the class is mapped to a column in the database.

Hibernate is called as HibernateORM
	Object relational mapping
	
	Hibernate is a common term that used for the entire Hibernate eco system, which includes multiple modules like Hibernate ORM, Hibernate Validator,
	Hibernate Search, Hibernate Envers, etc.
	Hibernate just offers the full suites of features and tools offered by hibernate, not just orm.

Hibernate ORM
	Is a specific module with in Hibernate, its main focus is to map java objects and manage database operations using object oriented approach.
	Its is the most popular and widely used module, its just one part of the larger hibernate framework.

Java is main for its object orintation. But Jbdc is not dealing like the object orientation of java. But hibernate deals as Objects
	This is a drawback of JDBC, To deal with this hibernate use it as "Object as a Whole".

	ORM means mapping of Object to the relational database.
	2 ways of mapping
		1-> xml configuration. (like in web.xml file .It is an outdated approach.)
		2-> Annotations

In jdbc we use jar files of mysql connector to connect with database.But for a big project it is so deficult. For that purpose we use adding dependencies
pom.xml file in hibernate
	-> mysql 
	-> hibernate core

There is a file other than Main.java, 
			   Entity.java,
			   pom.xml
	also needed , it is hibernate.cfg.xml( we can write any name here, but hibernate by defaulty looking for hibernate.cfg.xml. Otherwise we need to explicitly 
	mention in main.java or where it is used.
			-> hibernate.cfg.xml
				it contains 
					-> username
					-> password
					-> database name
					-> url

	In main method we used to connect to database, that is establishing session and deal with database.
		But it is not a good way, So create a sepearate HibernateManager.java file to deal with database and create objects
			-> HibernateManager.xml
				- Connect to database
				- Inset object
				- Modify object
				- fetch data


Annotations way of mapping.

1.Create a maven project
2. add dependecies to pom.xml
	-> mysql connector
	-> hibernate orm core
3. right click -> properties -> java facets -> java version -> java 17
4. right click -> maven -> update project -> force update
5. check maven dependecy in project section
	added dependencies are present along with other dependencies
6. create an model class (here Employee ) in a package named as entity
	-> add private variables
	-> add setters and getters
	-> constructors
	-> toString methods
	
	As of now, it is just a model class, bcz it is not mapped with any database table
7. model class is mapped to database using annotations
	@Entity  -> imported from jakarta.persistance.Entity  -> From hibernate core dependencies
	@Table(name=" ")  -> mapped to the table's name  that is already created-> imported from jakarta.persistance.Table
	@Column(name=" ") -> mapped to columns names that is present in the table. from jakarta.persistance.Column
	@Id  -> Used to map primary key, imported from jakarta.persistance.Id


	package com.tap.Entity;

	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;

	@Entity
	@Table(name="employee")
	public class Employee {
		@Id
		@Column(name="eId")
		private int empId;
		@Column(name="name")
		private String name;
		@Column(name="desig")
		private String desig;
		@Column(name="salary")
		private int salary;
	}


8. To connect to the table we use hibernate.cfg.xml, Inside the sesson factory to establish session
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://hibernate.org/dtd/hibernate-configuration-3.0.dtd">
    <hibernate-configuration>
    <session-factory>
        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hibernate</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">123456</property>
        <property name="hibernate.connection.pool_size">3</property>
        <property name="hibernate.show_sql">true</property>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
    </session-factory>
    </hibernate-configuration>

	if we use xml way of mapping. we need to mention ,what type of mapping resource did we used inside the sesson factory
	<mapping resource="name_Of_File.hib.xml" />

	if we have any error showing in the codes of <!Doctype..../> which blocks you from using external resources.So to allow
	windows -> preferences -> maven -> tick all from 3 to 7.
	if the problem still unsolved, just deselect all the of them and apply.After select 3 to 7 and again apply.

9. Check that weather we can create a session or not. So we create a main.java file in the main package
	Main.java
10. 1-> Create an object of configuration class
	Configuration config = new Configuration();
    2 -> add the supporting files to the config object to connect connect to database. They are called hibernate.cfg.xml
	Configuration config1 = config.configure(); -> if the name is same as hibernate.cfg.xml
	or
	Configuration config1 = config.configure( "name_Of_File.hib.xml" );  -> if the name of file is not the default name
    3 -> add annotated class to the configuration
	Configuration config2 = config1.addAnnotatedClass(Employee.class);
	we need to add Entity class as parameter as class file not Entity object

    4 -> When we print the object of each config file, we get
	 System.out.println(config); --> org.hibernate.cfg.Configuration@50313382
	 System.out.println(config1);  --> org.hibernate.cfg.Configuration@50313382
	 System.out.println(config2);  --> org.hibernate.cfg.Configuration@50313382

	Every object has same address, that is same object.
	That means, this is a singleton object design pattern.

	5 -> So, there is no need of, multiple objects. Therefor we can write it the above 1,2,3 steps as a single Step

		Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Entity_class_name.class);

    6-> We need to create a session from the config object.
	a-> first we need to create a session factory to get session. from import org.hibernate.SessionFactory;
		SessionFactory sf = config.buildSessionFactory();
	b -> the get session from session factory.  from import org.hibernate.Session;
		Session session = sf.openSession();

	check session 
	System.out.print(session); -> SessionImpl(1741892180<open>)

    This entire code has to short and write it as
	Session session = new Configuration()
			  .configure("hibernate.cfg.xml")
			  .addAnnotatedClass(Employee.class)
			  .buildSessionFactory()
			  .openSession();

In JDBC --> setAutoCommit() is by defaultly true.
	But in hibernate setAutoCommit() is by defaultly true.
	
Here hibernate internally make use of jdbc.
	so in hibernate to set auto commit to true we need a command --> 
	Transaction t = session.beginTransaction();   from org.hibernate.Transaction

	and need to commit that transaction by t.commit();

     7 -> Begin transaction
	Transaction t = session.beginTransaction();

     8 -> Create Entity class object.
		
	Employee e = new Employee(1,"Alex","proffesor",200000);
		
     9 -> Save in the session

	session.save(e);
	
	Save is a depctipted method. It is always recommended to use "persist()" method.

     10 -> Commit the transaction
	 t.commit();
		System.out.println("Data is inserted");

	Transaction t = session.beginTransaction();
		
		Employee e = new Employee(1,"Alex","proffesor",200000);
		
		session.save(e);
		
		t.commit();
		System.out.println("Data is inserted");


The save(), persist(), ...etc are called as HQL (Hibernate Query Language).
	
