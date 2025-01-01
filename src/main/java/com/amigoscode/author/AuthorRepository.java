package com.amigoscode.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

}
