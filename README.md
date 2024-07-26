# file-manager-utility

# Инструкция по запуску 

### Системные требования 
 - Java: JDK 20
 - Maven: 3.8.1 или выше

### Зависимости проекта
 В проекте используются следующие сторонние библиотеки:
 
 - **JCommander** 
 
    - Версия: 1.82
    - Описание: Парсер для командной строки для Java.
    - Зависимость Maven:
   ```xml 
   <dependency>
    <groupId>com.beust</groupId>
    <artifactId>jcommander</artifactId>
    <version>1.82</version>
   </dependency>
   ```
   - **Log4j2**

      - Версия: 2.17.0
      - Описание: Логирование для Java.
      - Зависимости Maven:  
      ```xml
     <dependency>
       <groupId>org.apache.logging.log4j</groupId>
       <artifactId>log4j-core</artifactId>
       <version>2.17.0</version>
     </dependency>
      ```
      ```xml
      <dependency>
       <groupId>org.apache.logging.log4j</groupId>
       <artifactId>log4j-api</artifactId>
       <version>2.17.0</version>
      </dependency>
     ```
     - **JUnit 5 (Jupiter)**
  
        - Версия: 5.10.3
        - Описание: Тестовый фреймворк для Java.
        - Зависимости Maven:
      ```xml
      <dependency>
         <groupId>org.junit.jupiter</groupId>
         <artifactId>junit-jupiter-api</artifactId>
         <version>5.10.3</version>
         <scope>test</scope>
       </dependency>
      ```
     ```xml
       <dependency>
         <groupId>org.junit.jupiter</groupId>
         <artifactId>junit-jupiter-engine</artifactId>
         <version>5.10.3</version>
         <scope>test</scope>
       </dependency>
      ```
- **Mockito**
  
  - Версия: 5.7.0.
  - Описание: Фреймворк для создания заглушек и макетов в тестах.
  - Зависимость Maven:
   ```xml
    <dependency>
       <groupId>org.mockito</groupId>
       <artifactId>mockito-core</artifactId>
       <version>5.7.0</version>
       <scope>test</scope>
    </dependency>
   ```
  
## Сборка проекта
1. Установить Maven  и JDK 20.
2. Выполните команду для сборки проекта:
```shell
mvn clean install
```
## Запуск утилиты 
Для запуска утилиты используйте следующую команду:
```shell
java -jar file-manager-utility-v1.0.jar -f -a -p sample_ input-files/in1.txt input-files/in2.txt
```
## Логирование
Проект использует Log4j2 для логирования.
Конфигурационный файл 'log4j2.xml' 
должен находиться в директории 'src/main/resources'

## Запуск тестов
Для запуска тестов используйте команду Maven:
```shell
mvn test
```
Эта команда выполнит все тесты, указанные в проекте.