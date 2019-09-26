# Construction Company Web
> 건설회사 웹 페이지로 관리자 권한으로 사업 실적, 특허, 뉴스등 업데이트 관리 시스템



[![Video Label](/Reference/mainView.PNG)](https://www.youtube.com/watch?v=tNeKzvV7PvQ)
---------------------------------------

### ENVIROMENT
- java8
- tomcat9.0
- spring 5.0.7
- oracle11g(DB), HikariCP(DBCP)
- css, js : [bootstrapk] http://bootstrapk.com/

---------------------------------------

### PATTERN(MVC -> Spring 5Layer)

#### MVC
- View
- Controller
- Command
- DAO
- DTO

#### Spring 5Layer
- View(Presentation Layer)
- Controller(Control Layer)
- Command and Service(Business Logic Layer)
- Mapper(Persistence Layer)
- DTO(Domain Model Layer)
        
---------------------------------------

### TECH
#### 1. 사업분야
- 각 테이블 관리를 따로 하되, DB테이블 동일 구조로 페이지 호출시 하나의 세션 키에 덮어씌우는 방식
- 페이지 호출시 페이지 이름에 따라 테이블명 판별(mybatis) 동일 쿼리 사용
- 페이지 최초 호출시 DB 테이블 호출 후 모달 기능을 통해 각 사업에 맞는 테이블 내의 행 호출
- 관리자 권한(admin=2)으로 등록관리  

#### 2. 특허 보드
- 관리자 권한(admin=2)으로 등록관리  

#### 3. 뉴스
- 뉴스 테이블의 페이징(10개), 상세 보기 창과 페이지 테이블 창 일치
- 최고 조회수 4개 게시판 상단에 배치  

#### 4. 회원관리
- 전체 회원 리스트(페이징)
- 각 관리 번호에 따라 통계
- 관리 번호에 따른 회원 리스트(페이징 유지)
- 동적 쿼리 사용

#### 5. mybatis
- 동적 쿼리 및 sql 관리를 위해 적용  

#### 6. library
- lombok : 반복적 DTO 작업 간결화 작업
- hikariCP : tomcat DBCP 사용중 hikariCP의 뛰어난 성능을 가지고 있다기에 사용(hikariCP 깃허브 참조)
<img src="https://github.com/brettwooldridge/HikariCP/wiki/HikariCP-bench-2.6.0.png">  

