# SqlConn-Library
A MySql Library for Java, Make it's work like Mysql at PHP

How to use it?<br>
Example of your 'table'
| firstName | midName | lastName |<br>
|Pocket     |Man      |Sad       |<br>
|Pocket2    |Man2     |Sad2      |<br>
|Pocket3    |Man3     |Sad3      |<br>
|Pocket4    |Man4     |Sad4      |<br>

```java
SqlConn conn = new SqlConn(ip,username,password,port);
conn.start();
conn.query('INSERT INTO table VALUES("Darius","Ellert","Klaus")');
//or
conn.query('SELECT * FROM table');
while(conn.rs.next()) {
  String firstName = conn.rs.getString('firstName');
  String midName = conn.rs.getString('midName');
  String lastName = conn.rs.getString('lastName');
  System.out.println(firstName + " " + midName + " " + lastName);
}
 conn.close();
 
 /* the output are */
 //Pocket Man Sad
 //Pocket2 Man2 Sad2
 //Pocket3 Man3 Sad3
 //Pocket4 Man4 Sad4
 //Darius Ellert Klaus
```
