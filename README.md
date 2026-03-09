
sequenceDiagram
    autonumber
    box Браузер
    participant UI as Интерфейс админа
    end
    box Сервер
    participant API as Backoffice API
    participant DB as SQL Database
    end

    UI->>API: 1. POST /admin/data
    Note over UI,API: Content-Type: application/json<br>{name: "value", ...}
    
    API->>API: 2. Проверка прав доступа (isAdmin)
    API->>API: 3. Валидация входных данных
    API->>DB: 4. Выполняет SQL запрос
    Note over API,DB: INSERT INTO items (...) VALUES (...)
    
    DB-->>API: 5. Возвращает ID новой записи
    API->>API: 6. Логирование операции
    API-->>UI: 7. HTTP 200 с ID новой записи
    
    UI->>UI: 8. Показывает уведомление "Успешно!"
```