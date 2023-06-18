# Spring Native with Multiple DataSources

This repository includes creating native images with Spring Boot and using multiple data sources within the project content.

The schema structure is as follows: PostgreSQL (Primary) & MySQL.

### PostgreSQL:
```
docker run --detach --name=local-postgres -e POSTGRES_USER=root -e POSTGRES_PASSWORD=root  -p 5432:5432 postgres:latest
```
```
create table person
(
    id     bigserial
        primary key ,
    gender varchar(255)
        constraint person_gender_check
            check ((gender)::text = ANY ((ARRAY ['FEMALE'::character varying, 'MALE'::character varying])::text[])),
    name   varchar(255)
);

alter table person
    owner to root;
```

### MySQL:
```
docker run --detach --name=local-mysql -p 33060:3306 --env="MYSQL_ROOT_PASSWORD=root"  mysql:latest
```

```
CREATE TABLE product
(
    id    BIGINT(20)     NOT NULL PRIMARY KEY AUTO_INCREMENT,
    code  VARCHAR(255)   NULL,
    name  VARCHAR(255)   NULL,
    price DECIMAL(18,2)  NULL
);
```

In the project, since ddl-auto is set to "none," these tables need to be created using their respective drivers.


### Native Image
In the project, Java 17 is being used as the SDK. Consequently, please take into consideration using GraalVM's Java 17 version as well.

### Build image:
```
./mvnw spring-boot:build-image -Pnative
```


### Run it on Docker:
```
docker run --rm -p 8080:8080 spring-native-multiple-datasource:0.0.1-SNAPSHOT
```

If you encounter any issues at this stage, you can refer to the [HELP.md](HELP.md) for assistance.

