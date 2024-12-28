package com.amigoscode;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Book(Long id, String name, Integer pageCount,
                   Long authorId) {

  public static List<Book> books = Arrays.asList(
      new Book(1L, "aws", 100, 3L),
      new Book(2L, "ms", 200, 1L),
      new Book(3L, "apple", 300, 2L)
  );

  public static Optional<Book> getBookById(Long id) {
    return books.stream()
        .filter(b -> b.id.equals(id))
        .findFirst();
  }
}
