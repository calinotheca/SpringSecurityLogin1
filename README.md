# Tutorial
## 1. Used components
[Colorlib form template](https://colorlib.com/wp/template/login-form-v10/)

## 2. Create database and user
a. Create database

```sql
mysql> create database springSecurityLogin1;
```

b. Create database user identified by custom password.

```sql
mysql> create user 'springSecurityLogin1'@'localhost' identified by '<password>';
```

c. Set grant privileges on database to user.

```sql
mysql> grant all privileges on springSecurityLogin1.* to 'springSecurityLogin1'@'localhost';
mysql> flush privileges;
```

## 3. Clone git code and change settings in application.properties.
```java
# aplication.properties
# MySQL database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/springSecurityLogin1?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=springSecurityLogin1
spring.datasource.password=123abb
spring.datasource.sqlScriptEncoding=UTF-8
spring.jpa.hibernate.ddl-auto=create
spring.datasource.initialization-mode=always

#servler
server.servlet.context-path=/
server.port=8080
```

## 4. Screenshots
![Image1](http://kwascow.civ.pl/public_html/file_repository/springSecurityLogin1_1.png "Screen 1")
![Image1](http://kwascow.civ.pl/public_html/file_repository/springSecurityLogin1_2.png "Screen 1")

