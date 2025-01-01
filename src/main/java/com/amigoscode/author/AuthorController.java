package com.amigoscode.author;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AuthorController {

  private final AuthorRepository authorRepository;

  @MutationMapping
  public Author saveAuthor(@Argument String name) {
    AuthorEntity newAuthor = authorRepository.save(
        AuthorEntity.builder()
            .name(name)
            .build()
    );

    return Author.entityToModel(newAuthor);
  }

  @QueryMapping
  public List<Author> authors() {
    List<AuthorEntity> results = authorRepository.findAll();
    return results.stream()
        .map(Author::entityToModel)
        .toList();
  }

}
