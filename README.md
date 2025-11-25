## Лабораторна 1 — XML-конфігурація + 3 рівні DI
- Person → Dog → Collar
- DI через конструктор і сеттери
- Використання `myApp.properties`  
  → Запуск: відкрити `lab1` → `Test3.java`

## Лабораторна 2 — Повний перехід на анотації
- Без XML
- `@Component`, `@Autowired`, `@Value`, `@PostConstruct/@PreDestroy`  
  → Запуск: відкрити `lab2` → `Test3.java`

## Лабораторна 3 — Spring Boot REST CRUD + профілі dev/prod
**Функціонал:**
- CRUD операції над книгами (`/books`)
- Swagger UI: http://localhost:8080/swagger-ui.html
- У `dev`-режимі заборонено створення/оновлення/видалення
- У `prod`-режимі — все дозволено
- PostgreSQL