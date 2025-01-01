package com.amigoscode.author;

import java.util.List;
import java.util.Optional;

public record Author(Long id, String name) {

  public static List<Author> authors =
      List.of(
          new Author(1L, "gyeom"),
          new Author(2L, "kylo"),
          new Author(3L, "kkkk")
      );

  public static Optional<Author> getAuthorById(Long id) {
    return authors.stream()
        .filter(a -> a.id.equals(id))
        .findFirst();
  }

  public static Author entityToModel(AuthorEntity entity) {
    return new Author(entity.getId(), entity.getName());
  }
}
