package com.umc.study.repository;

import com.umc.study.domain.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // 최신 등록순 전체 조회. category를 함께 가져와 N+1 쿼리를 방지
    @EntityGraph(attributePaths = "category")
    List<Book> findAllByOrderByBookIdDesc();

    // [선택 미션] 제목 키워드 검색 (LIKE %keyword%)
    @EntityGraph(attributePaths = "category")
    List<Book> findByTitleContainingOrderByBookIdDesc(String keyword);

    // 3주차 미션 API 유지: 특정 카테고리 도서 조회
    @EntityGraph(attributePaths = "category")
    List<Book> findAllByCategory_CategoryIdOrderByBookIdDesc(Long categoryId);
}
