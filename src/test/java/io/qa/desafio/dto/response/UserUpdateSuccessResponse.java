package io.qa.desafio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserUpdateSuccessResponse {
  private String name;
  private String job;
  private String updatedAt;
}
