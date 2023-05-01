package com.example.bookstore.core.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataResult<T> extends GeneralResult {

    private T data;

    public DataResult(T data,String message) {
        super(message, true);
        this.data = data;
    }
}
