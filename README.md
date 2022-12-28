# my-JDBC-app
JDBC Application for practicing JDBC usage.

- JDBC is an API used to connect Java Applications with variety of Databases.
- JDBC offers same set of APIs to perform CRUD operations with any database.
- JDBC is dependent on the driver provided by specific database to use that particular database.


Software used for this Project:
- Database: MySQL 8.0.31
- Java 19
- MySQL Driver

Steps to Connect Java application with Database:

We use Connection interface for creating connections.

1) Load the driver:
```
	Class.forName("com.mysql.jdbc.Driver"); 
	
	or
	
	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
```
	
2) Create a Connection:
```
	Connection con = DriverMAnager.getConnection("url <jdbc:mysql://ip-address:port-no/dbname>","username<root>","password");
```

3) Create a SQL Query: [Statement. PreparedStatement, CallableSattement]
```
Ex:
	String q = "select * from students";
	Statement stmt = con.createStatement();
	ResultSet set = stmt.executeQuery(q);
```

4) Process the Data:
```
 while(set.next()){
 	int id = set.getInt(<col-num> or <"column name">);
 	String name = set.getString("studentName <column name>");
 	System.out.println(id);
 	System.out.println(name);
 }
```

5) Close the Connection:
```
	con.close();
```

	
