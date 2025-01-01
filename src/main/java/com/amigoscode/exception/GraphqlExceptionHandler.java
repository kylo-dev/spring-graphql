package com.amigoscode.exception;

import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;

@Configuration
public class GraphqlExceptionHandler extends DataFetcherExceptionResolverAdapter {

  @Override
  protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {

    if (ex instanceof GraphqlException graphqlException) {
      return new GraphqlException(graphqlException.getMessage(), graphqlException.getHttpStatus(),
          graphqlException.getGraphqlErrorType());
    }
    return null;
  }
}
