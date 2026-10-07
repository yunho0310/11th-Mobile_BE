# UMC 4주차 - ORM으로 생산성 높이고 첫 API 완성하기 (Spring Boot)

3주차 Raw SQL(JdbcTemplate) 도서 API를 Spring Data JPA + DTO 구조로 리팩터링.

## 실행
- IntelliJ 실행 구성 환경 변수: `DB_URL`, `DB_USER`, `DB_PW`
- `ddl-auto: validate` — 기존 `book`, `category` 테이블과 엔티티가 맞지 않으면 서버가 뜨지 않음

## API
| Method | URL | 설명 | 성공 |
|---|---|---|---|
| GET | `/books` | 전체 도서 최신순 | 200 |
| GET | `/books?keyword=코드` | 제목 검색 (선택 미션) | 200 |
| GET | `/books/category/{categoryId}` | 카테고리별 조회 | 200 |
| POST | `/books` | 도서 등록 | 201 |

### 오류 응답
| 상황 | 상태 |
|---|---|
| `title` 빈 값 / `categoryId` 누락 / 제목 100자 초과 | 400 |
| 존재하지 않는 `categoryId` | 404 |

## 구조
```
domain/      Book, Category (JPA Entity, Book N : 1 Category)
dto/         CreateBookRequest, BookResponse, ErrorResponse
repository/  BookRepository, CategoryRepository (JpaRepository)
service/     BookService
controller/  BookController
exception/   CategoryNotFoundException, GlobalExceptionHandler
```
대여(rentals) API는 3주차 Raw SQL 버전을 그대로 유지.
