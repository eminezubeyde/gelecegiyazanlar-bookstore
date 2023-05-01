package com.example.bookstore.core.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResult extends GeneralResult {

    public ErrorResult(String message) {
        super(message, false);
    }
}
