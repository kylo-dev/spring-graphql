package com.amigoscode.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import java.util.List;
import java.util.Map;
import lombok.Getter;

@Getter
public class GraphqlException extends RuntimeException implements GraphQLError {

  private final String message;
  private final int httpStatus;
  private final GraphqlErrorType errorType;

  public GraphqlException(String message, int httpStatus, GraphqlErrorType errorType) {
    super(message);
    this.message = message;
    this.httpStatus = httpStatus;
    this.errorType = errorType;
  }

  @Override
  public List<SourceLocation> getLocations() {
    return null;
  }

  @Override
  public ErrorClassification getErrorType() {
    return null;
  }

  public GraphqlErrorType getGraphqlErrorType() {
    return errorType;
  }

  @Override
  public List<Object> getPath() {
    return GraphQLError.super.getPath();
  }

  @Override
  public Map<String, Object> toSpecification() {
    System.out.println("GraphQLError.super.toSpecification() = " + GraphQLError.super.toSpecification());
    return GraphQLError.super.toSpecification();
  }

  @Override
  public Map<String, Object> getExtensions() {
    return Map.of(
        "httpStatus", httpStatus,
        "errorType", errorType.toString()
    );
  }
}
