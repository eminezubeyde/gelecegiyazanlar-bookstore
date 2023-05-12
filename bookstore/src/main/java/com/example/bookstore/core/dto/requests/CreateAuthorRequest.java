package com.example.bookstore.core.dto.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CreateAuthorRequest {
    @NotBlank
    @Min(value = 2, message = "length must be greater than 2")
    private String name;

    @NotBlank
    @Length(min = 2, message = "length must be greater than 2")
    private String lastName;

    @NotBlank
    @Length(min = 2, message = "length must be greater than 2")
    private String userName;

    @NotBlank
    @Size(min = 8, message = "must be at least 8 characters")
    private String password;
    private String telephone;

    @NotNull(message = "date of birth cannot be empty")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String birthDay;
}
