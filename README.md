# Spring Web Java 프로젝트 템플릿

이 프로젝트는 Spring Boot 기반의 Java 웹 애플리케이션을 위한 템플릿입니다. 기본적인 프로젝트 구조와 설정이 포함되어 있어 빠르게 개발을 시작할 수 있습니다.

## 주요 기능

- Spring Boot 3.x 기반
- MyBatis를 사용한 데이터베이스 연동
- Swagger UI를 통한 API 문서화
- JUnit을 사용한 테스트 예시
- 기본적인 REST API 예시

## 프로젝트 구조

```
com.kt.{{ cookiecutter.package_name }}/
├── common/                    # 공통 기능
│   ├── exception/            # 예외 처리
│   └── dto/                  # 공통 DTO (선택사항)
├── sampleUser/               # 샘플 업무 단위 패키지
│   ├── config/              # 설정
│   ├── controller/          # API 컨트롤러
│   ├── dto/                 # 데이터 전송 객체
│   ├── model/               # 도메인 모델
│   ├── repository/          # 데이터 접근 계층
│   ├── service/             # 비즈니스 로직
│   └── mapper/              # MyBatis 매퍼
└── {{ cookiecutter.project_name }}Application.java

src/main/resources/
├── conf/
│   ├── db/                  # 데이터베이스 초기화 SQL
│   │   ├── schema.sql      # 테이블 생성 스크립트
│   │   └── data.sql        # 초기 데이터 삽입 스크립트
│   └── mybatis/            # MyBatis 설정
└── application.yml         # 애플리케이션 설정
```

## 패키지 설명

### 1. Common 패키지
- `exception`: 전역 예외 처리
- `dto`: 공통 DTO (선택사항)

### 2. SampleUser 패키지
- 개발자들이 참고할 수 있는 샘플 업무 단위
- User 관련 조회 기능을 구현한 예시
- 실제 개발 시 이 구조를 참고하여 새로운 업무 단위 패키지를 생성

## 시작하기

### 1. 프로젝트 생성

```bash
cookiecutter https://github.com/your-username/template-springweb-java.git
```

### 2. 데이터베이스 설정

`src/main/resources/application.yml` 파일에서 데이터베이스 연결 정보를 설정합니다:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your_database
    username: your_username
    password: your_password
  sql:
    init:
      mode: always
      schema-locations: classpath:conf/db/schema.sql
      data-locations: classpath:conf/db/data.sql
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
- `sampleUser` 패키지 구조를 참고하여 새로운 업무 단위 패키지 생성
- 각 계층별 패키지 구조 유지 (controller, service, repository 등)

### 2. 공통 기능 구현
- 여러 업무 단위에서 공통으로 사용되는 기능은 `common` 패키지에 구현
- 예외 처리, 공통 DTO 등

### 3. 데이터베이스 초기화
- 테이블 생성 스크립트는 `conf/db/schema.sql`에 작성
- 초기 데이터 삽입 스크립트는 `conf/db/data.sql`에 작성

## 테스트 실행

```bash
./mvnw test
```

## 라이센스

MIT License 