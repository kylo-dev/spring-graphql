package com.amigoscode.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import graphql.ErrorClassification;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = Shape.OBJECT)
public enum GraphqlErrorType implements ErrorClassification {

  CONFLICT,
  BAD_REQUEST,
  NOT_ACCEPTABLE,
  UNAUTHORIZED,
  FORBIDDEN,
  NOT_FOUND,
  INTERNAL_ERROR,
  TOO_MANY_REQUESTS;
}
