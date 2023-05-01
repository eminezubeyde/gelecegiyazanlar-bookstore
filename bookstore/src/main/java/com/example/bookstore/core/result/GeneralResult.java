package com.example.bookstore.core.result;

import com.example.bookstore.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResult {

    private String message;
    private Boolean successful;

}
