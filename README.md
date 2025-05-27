# Spring Web Java 프로젝트 템플릿

이 프로젝트는 Spring Boot 기반의 Java 웹 애플리케이션을 위한 템플릿입니다. 기본적인 프로젝트 구조와 설정이 포함되어 있어 빠르게 개발을 시작할 수 있습니다.

## 주요 기능

- Spring Boot 3.x 기반
- JPA/Hibernate를 사용한 데이터베이스 연동
- PostgreSQL 데이터베이스 지원
- Swagger UI를 통한 API 문서화
- JUnit을 사용한 테스트 예시
- 기본적인 REST API 예시

## 프로젝트 구조

```
com.kt.{{ cookiecutter.package_name }}/
├── common/                    # 공통 기능
│   ├── exception/            # 예외 처리
│   ├── model/               # 공통 모델 (BaseEntity 등)
│   └── dto/                 # 공통 DTO (선택사항)
├── exampleUser/             # 샘플 업무 단위 패키지
│   ├── config/             # 설정
│   ├── controller/         # API 컨트롤러
│   ├── dto/                # 데이터 전송 객체
│   ├── model/              # JPA 엔티티
│   ├── repository/         # JPA Repository
│   └── service/            # 비즈니스 로직
└── {{ cookiecutter.project_name }}Application.java

src/main/resources/
├── conf/
│   └── db/                 # 데이터베이스 초기화 SQL
│       ├── schema.sql     # 테이블 생성 스크립트
│       └── data.sql       # 초기 데이터 삽입 스크립트
└── application.yml        # 애플리케이션 설정
```

## 패키지 설명

### 1. Common 패키지

- `exception`: 전역 예외 처리
- `model`: 공통 엔티티 (BaseEntity 등)
- `dto`: 공통 DTO (선택사항)

### 2. ExampleUser 패키지

- 개발자들이 참고할 수 있는 샘플 업무 단위
- JPA를 사용한 User 관련 CRUD 기능 구현 예시
- 실제 개발 시 이 구조를 참고하여 새로운 업무 단위 패키지를 생성

## 시작하기

### 1. 프로젝트 생성

KDP Create 메뉴를 사용하여 해당 템플릿을 복제 할 수 있습니다.

### 2. 데이터베이스 설정

`src/main/resources/application.yml` 파일에서 데이터베이스 연결 정보를 설정합니다:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/your_database
    username: your_username
    password: your_password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect
```

### 3. 애플리케이션 실행

```bash
./mvnw spring-boot:run
```

### 4. API 문서 확인

Swagger UI를 통해 API 문서를 확인할 수 있습니다:

```
http://localhost:8080/api/swagger-ui.html
```

## 개발 가이드

### 1. 새로운 업무 단위 추가

- `exampleUser` 패키지 구조를 참고하여 새로운 업무 단위 패키지 생성
- 각 계층별 패키지 구조 유지 (controller, service, repository 등)
- JPA 엔티티는 `BaseEntity`를 상속받아 구현

### 2. 공통 기능 구현

- 여러 업무 단위에서 공통으로 사용되는 기능은 `common` 패키지에 구현
- 예외 처리, 공통 엔티티, 공통 DTO 등

### 3. JPA 엔티티 작성

- 모든 엔티티는 `BaseEntity`를 상속받아 구현
- `@Entity`, `@Table` 어노테이션 사용
- 컬럼 제약조건 설정 (`@Column` 어노테이션)
- Lombok 어노테이션 활용 (`@Getter`, `@Setter`, `@Builder` 등)

### 4. Repository 작성

- JPA Repository 인터페이스 구현
- 필요한 경우 커스텀 쿼리 메서드 추가

## 테스트 실행

```bash
./mvnw test
```
