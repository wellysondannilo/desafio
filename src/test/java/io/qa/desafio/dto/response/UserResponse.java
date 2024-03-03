package io.qa.desafio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponse implements Serializable {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;
}
