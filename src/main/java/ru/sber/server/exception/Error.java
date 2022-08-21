package ru.sber.server.exception;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Error {

    @NotNull
    int code;

    @NotNull
    String message;
}
