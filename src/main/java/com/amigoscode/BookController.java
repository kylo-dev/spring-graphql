package com.amigoscode;

import java.util.List;
import java.util.Optional;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

  /**
   * schma.graphqls 파일에 있는 Query 유형과 매핑 존재하는 유형의 이름으로 메서드명 설정
   */
  @QueryMapping
  public List<Book> books() {
    return Book.books;
  }

  /**
   * @Argument를 통해 매개변수 처리하기 Integer - Long 자료형 신경써야 함.
   */
  @QueryMapping
  public Optional<Book> bookById(@Argument Long id) {
    return Book.getBookById(id);
  }

  /**
   *
   */
  @SchemaMapping
  public Optional<Author> author(Book book) {
    return Author.getAuthorById(book.authorId());
  }
}
