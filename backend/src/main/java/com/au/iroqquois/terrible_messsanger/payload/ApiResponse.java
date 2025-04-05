package com.au.iroqquois.terrible_messsanger.payload;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {

    private String message;
    private T data;

    public static <T> ApiResponse<T> of(
            T data,
            String message
    ) {
        return new ApiResponse<>(
                message,
                data
        );
    }

    public static <T> ApiResponse<T> of(
            T data
    ) {
        return new ApiResponse<>(
                "Successfully",
                data
        );
    }


    public static <T> ApiResponse<T> of() {
        return new ApiResponse<>("Successfully", null);
    }
}

