package io.qa.desafio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ListUserResponse implements Serializable {
  private Long page;
  private Long perPage;
  private Long total;
  private Long totalPages;
  private List<UserResponse> data;
  private SupportResponse support;
}
