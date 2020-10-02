# Tutorial
## 1. Create database and user
a. Create database

```java
mysql> create database springSecurityLogin1;
```

b. Create database user identified by custom password.

```java
mysql> create user 'springSecurityLogin1'@'localhost' identified by '<password>';
```

c. Set grant privileges on database to user.

```java
mysql> grant all privileges on springSecurityLogin1.* to 'springSecurityLogin1'@'localhost';
mysql> flush privileges;
```

## 2. Clone git code and change settings in application.properties.
`# MySQL database configuration`

 `spring.datasource.url=jdbc:mysql://localhost:3306/springSecurityLogin1?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true`

`spring.datasource.username=springSecurityLogin1`

`spring.datasource.password=123abb`

`spring.datasource.sqlScriptEncoding=UTF-8`

`spring.jpa.hibernate.ddl-auto=create`

`spring.datasource.initialization-mode=always`


`#servler`

`server.servlet.context-path=/`

`server.port=8080`
