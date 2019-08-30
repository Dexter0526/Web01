# Construction company WebSite

### Environment
1. java8
2. tomcat8.5
3. spring 4.3.1
4. oracle11g(DB), HikariCP(DBCP)
5. css, js : [bootstrapk] http://bootstrapk.com/

---------------------------------------

### pattern

#### MVC
- View
  - Controller
    - Command
      -DAO
        DTO

#### Spring 5Layer
- View(Presentation Layer)
  - Controller(Control Layer)
    - Command and Service(Business Logic Layer)
      - Mapper(Persistence Layer)
        - DTO(Domain Model Layer)
        
