
[Go to English Version](#book-rental-project)


# Kitap Kiralama Projesi
Kitap Kiralama Projesi, stoklardaki kitapları insanlara kiralayıp bilgilerini takip etmek amacıyla geliştirilmiş bir Spring Boot uygulamasıdır.

## Özellikler
- Kitap, yazar, yayın evi ve kiralanan kitap bilgilerini yönetme
- DTO kullanımı ile veri transferi
- Spring Data JPA ile repository sorguları (custom @Query ve JPA keywords)
- Global exception handling ile güvenli hata yönetimi
- Spring Security ile Basic Authentication
- RabbitMQ ile mesajlaşma desteği
- Aspect (AOP) ile iş mantığı ve logging yönetimi
- Maven ile bağımlılık yönetimi ve build
- Unit testler H2 veritabanı ve JUnit 5 ile yazılmıştır

## Kullanılan Teknolojiler
- Java 17
- Spring Boot 3.5.4
- Maven
- PostgreSQL (lokal)
- RabbitMQ
- Docker 
- ModelMapper
- Spring AOP, Spring Security
- JUnit 5 ve H2 (unit testler için)

## Kurulum
Projeyi klonlayın:
```bash
git clone <https://github.com/KemalKeskin/kitap-kiralama-projesi.git>
cd kitap-kiralama-projesi
```

## Docker ile RabbitMQ kurulumu

Proje klasörüne docker-compose.yml dosyası ekleyin: 

```bash
version: "3.8"
services:
  rabbitmq:
    image: rabbitmq:3-management
    container_name: rabbitmq
    ports:
      - "5672:5672"     # Uygulamanın bağlandığı port
      - "15672:15672"   # Yönetim paneli portu
    environment:
      RABBITMQ_DEFAULT_USER: guest
      RABBITMQ_DEFAULT_PASS: guest
    networks:
      - rabbitmq_net

networks:
  rabbitmq_net:
    driver: bridge
```

## Docker ile RabbitMQ ayağa kaldırmak için

Terminale aşağıdaki kodu yazınız:

```bash
docker compose up -d
```

## Maven ile projeyi çalıştırın:
```bash
mvn clean install
mvn spring-boot:run
```



## Testler

Unit testler H2 veritabanı ve JUnit 5 kullanılarak yazılmıştır. Testleri çalıştırmak için:

```bash
mvn test
```


## API Endpointleri

Tüm endpointler /api/ ile başlar:

- Publishers: http://localhost:8080/api/publishers

- Books: http://localhost:8080/api/books

- Authors: http://localhost:8080/api/authors

- Rented Books: http://localhost:8080/api/rented


  
## Ek bilgiler

Tüm bu bilgiler projede bulunan src/main/resources/application.properties dosyasında bulunmaktadır

Database Bilgileri:

```bash
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update 
spring.jpa.hibernate.show-sql=true
spring.datasource.url=jdbc:postgresql://localhost:5432/rentedbook
spring.datasource.username=postgres
spring.datasource.password=54321
spring.jpa.properties.javax.persistence.validation.mode = none
```

RabbitMQ yapılandırması ve erişim bilgileri

```bash
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest

rabbitmq.exchange=appExchange
rabbitmq.queue=appQueue
rabbitmq.routingkey=appRoutingKey
```

Spring security kullanıcı adı ve şifre:

```bash
spring.security.user.name=kemal
spring.security.user.password=user123
```





# Book Rental Project
The Book Rental Project is a Spring Boot application developed to manage and track books available for rent.

## Features
- Manage books, authors, publishers, and rented book information
- Data transfer using DTOs
- Repository queries with Spring Data JPA (custom @Query and JPA keywords)
- Secure error handling with global exception management
- Basic Authentication using Spring Security
- Messaging support with RabbitMQ
- Business logic and logging management with Aspect (AOP)
- Dependency management and build with Maven
- Unit tests written using H2 database and JUnit 5

## Technologies Used
- Java 17
- Spring Boot 3.5.4
- Maven
- PostgreSQL (local)
- RabbitMQ
- Docker
- ModelMapper
- Spring AOP, Spring Security
- JUnit 5 and H2 (for unit tests)

## Setup
Clone the project:
```bash
git clone <https://github.com/KemalKeskin/kitap-kiralama-projesi.git>
cd kitap-kiralama-projesi
```

## Installing RabbitMQ with Docker

Add a docker-compose.yml file to the project directory:

```bash
version: "3.8"
services:
  rabbitmq:
    image: rabbitmq:3-management
    container_name: rabbitmq
    ports:
      - "5672:5672"     # Uygulamanın bağlandığı port
      - "15672:15672"   # Yönetim paneli portu
    environment:
      RABBITMQ_DEFAULT_USER: guest
      RABBITMQ_DEFAULT_PASS: guest
    networks:
      - rabbitmq_net

networks:
  rabbitmq_net:
    driver: bridge
```

## Start RabbitMQ with Docker:
Type the following command into the terminal:
```bash
docker compose up -d
```

## Run the project with Maven:
```bash
mvn clean install
mvn spring-boot:run
```



## Tests

Unit tests are written using H2 database and JUnit 5. To run the tests:

```bash
mvn test
```

## API Endpoints

All endpoints start with /api/:

- Publishers: http://localhost:8080/api/publishers

- Books: http://localhost:8080/api/books

- Authors: http://localhost:8080/api/authors

- Rented Books: http://localhost:8080/api/rented

  


## Additional Information

All of this information can be found in the src/main/resources/application.properties file in the project.

Database information:

```bash
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update 
spring.jpa.hibernate.show-sql=true
spring.datasource.url=jdbc:postgresql://localhost:5432/rentedbook
spring.datasource.username=postgres
spring.datasource.password=54321
spring.jpa.properties.javax.persistence.validation.mode = none
```

RabbitMQ configuration and access credentials

```bash
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest

rabbitmq.exchange=appExchange
rabbitmq.queue=appQueue
rabbitmq.routingkey=appRoutingKey
```

Spring security user name and password:

```bash
spring.security.user.name=kemal
spring.security.user.password=user123
```




                                                                                                                                                                                                                                                                                                                                                                         
