package ru.sber.server.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LogImport {

    private String message;
    private String type;
    private String level;
    private String time;
}
