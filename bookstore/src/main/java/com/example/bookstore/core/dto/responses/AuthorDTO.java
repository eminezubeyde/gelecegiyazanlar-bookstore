package com.example.bookstore.core.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
    private long id;
    private String name;
    private String lastName;
    private String userName;
    private String password;
    private String telephone;
}
