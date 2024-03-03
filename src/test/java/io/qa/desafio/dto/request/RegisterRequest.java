package io.qa.desafio.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RegisterRequest {
    private String email;
    private String password;

    public RegisterRequest(String email) {
        this.email = email;
    }
}
