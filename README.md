<h1 align="center">Spendev Users Microservice</h1>

<p align="center">
  <img alt="Sonar quality gate status metric" src="https://sonarcloud.io/api/project_badges/measure?project=leonardolocatti_spendev-users-ms&metric=alert_status" />
  <img alt="Sonar maintainability rate metric" src="https://sonarcloud.io/api/project_badges/measure?project=leonardolocatti_spendev-users-ms&metric=sqale_rating" />
  <img alt="Sonar reliability rate metric" src="https://sonarcloud.io/api/project_badges/measure?project=leonardolocatti_spendev-users-ms&metric=reliability_rating" />
  <img alt="Sonar security rate metric" src="https://sonarcloud.io/api/project_badges/measure?project=leonardolocatti_spendev-users-ms&metric=security_rating" />
  <img alt="Sonar coverage metric" src="https://sonarcloud.io/api/project_badges/measure?project=leonardolocatti_spendev-users-ms&metric=coverage" />
  <img alt="Sonar vulnerability metric" src="https://sonarcloud.io/api/project_badges/measure?project=leonardolocatti_spendev-users-ms&metric=vulnerabilities" />
  <img alt="Sonar bugs metric" src="https://sonarcloud.io/api/project_badges/measure?project=leonardolocatti_spendev-users-ms&metric=bugs" />
  <img alt="Sonar code smells metric" src="https://sonarcloud.io/api/project_badges/measure?project=leonardolocatti_spendev-users-ms&metric=code_smells" />
</p>

## 📓 About

Users microservice used in Spendev (financial control app)

## 🔗 Prerequisites

This project depends on [Spendev Discovery Microservice](https://github.com/leonardolocatti/spendev-discovery-ms) and
[Spendev Gateway Microservice](https://github.com/leonardolocatti/spendev-gateway-ms). To run this one first run the
others.

## ⏩ Running

```bash
mvn spring-boot:run

# The application will start a user's microservice on random port that can be accessed by gateway using localhost:8765/users 
```

## 🔨 Tech stack

- **[Spring Cloud Netflix](https://spring.io/projects/spring-cloud-netflix)**
- **[ModelMapper](http://modelmapper.org/)**
- **[H2 Database](https://www.h2database.com/html/main.html)**
- **[Lombok](https://projectlombok.org/)**

> See the file [pom.xml](./pom.xml)