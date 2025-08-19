
[Go to English Version](english-version)


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

## Maven ile projeyi çalıştırın:
```bash
mvn clean install
mvn spring-boot:run
```

## Docker ile rabbitMQ ayağa kaldırmak için
```bash
docker compose up -d
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


## English version

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

## Run the project with Maven:
```bash
mvn clean install
mvn spring-boot:run
```

## Start RabbitMQ with Docker:
```bash
docker compose up -d
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







                                                                                                                                                                                                                                                                                                                                                                         
