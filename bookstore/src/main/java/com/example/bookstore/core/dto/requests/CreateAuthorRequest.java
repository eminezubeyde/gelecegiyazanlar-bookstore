package com.example.bookstore.core.dto.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CreateAuthorRequest {
    @NotBlank(message = "boş olamaz.")
    @Min(value = 2, message = "length must be greater than 2")
    private String name;

    @NotBlank
    @Length(min = 2, message = "length must be greater than 2")
    private String lastName;
    @NotBlank
    @Length(min = 2, message = "length must be greater than 2")
    private String userName;
    private String password;
    private String telephone;
    private String birthDay;
}
