## Лабораторна 1 — XML-конфігурація + 3 рівні DI
- Person → Dog → Collar
- DI через конструктор і сеттери
- Використання `myApp.properties`  
  → Запуск: відкрити `lab1` → `Test3.java`

## Лабораторна 2 — Повний перехід на анотації
- Без XML
- `@Component`, `@Autowired`, `@Value`, `@PostConstruct/@PreDestroy`  
  → Запуск: відкрити `lab2` → `Test3.java`

## Лабораторна 3 — Spring AOP (Aspect-Oriented Programming)
- 1 клас-аспект: `LoggingAspect`
- 4 Pointcut
- 4 Advice (`@Before`, `@AfterReturning`, `@Around`, `@After`)
- Логування всіх викликів, вимірювання часу `say()`, логування створення бінів
- Запуск: `Test3.java` у папці `lab3_spring_course`
- # Лабораторна 0 — Spring Boot REST CRUD + профілі dev/prod

## Лабораторна 4 — Spring Data JPA + PostgreSQL + відношення
- Підключено **PostgreSQL**
- Класи `Person`, `Dog`, `Collar` — `@Entity`
- Автоматичне створення таблиць (`ddl-auto: update`)
- **Відношення**:
  - `@OneToOne` (Dog ↔ Collar — EAGER)
  - `@OneToOne` (Person → Dog — LAZY)
- Реалізовано **CRUD** через `JpaRepository`
- Демонстрація **EAGER vs LAZY** завантаження (з `LazyInitializationException` при закритій сесії — правильна поведінка!)
- Запуск: `Test4.java` у корені проєкту

**Функціонал:**
- CRUD операції над книгами (`/books`)
- Swagger UI: http://localhost:8080/swagger-ui.html
- У `dev`-режимі заборонено створення/оновлення/видалення
- У `prod`-режимі — все дозволено
- PostgreSQL