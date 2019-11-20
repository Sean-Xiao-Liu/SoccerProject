# Soccer Betting Project

## Getting Started

## Running the Tests

## Deployment

Migrate database schema
```
mvn clean compile flyway:migrate -Ddb_url=${db_url} -Ddb_name=${db_name} -Ddb_user=${db_user} -Ddb_password=${db_password} -Ddb_port=${db_port}

```

Test the methods
```
mvn test -Ddb_driver=org.postgresql.Driver -Ddatabase.dialect=org.hibernate.dialect.PostgreSQL9Dialect -Ddatabase.url=${db_url} -Ddatabase.user=${db_user} -Ddatabase.password=${db_password} -Dsecret.key=123456 -Dlogging.level.org.springframework=INFO 
```

