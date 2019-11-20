# Soccer Betting Project

## Getting Started

## Running the Tests

## Deployment

Migrate database schema
```
mvn clean compile flyway:migrate -Ddb_url=${db_url} -Ddb_driver=org.postgresql.Driver -Ddb_name=${db_name} -Ddb_user=${db_user} -Ddb_password=${db_password} -Ddb_port=${db_port}

```

Test the methods
```
mvn test -Ddb_driver=${db_driver} -Ddatabase.dialect=org.hibernate.dialect.PostgreSQL9Dialect -Ddatabase.url=${db_url} -Ddatabase.user=${db_user} -Ddatabase.password=${db_password} -Dsecret.key=${db_secretkey} -Dlogging.level.org.springframework=INFO 
```

