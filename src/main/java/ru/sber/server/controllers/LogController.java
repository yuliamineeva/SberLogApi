package ru.sber.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sber.server.model.LogImport;
import ru.sber.server.services.LogService;

@RestController
public class LogController {

    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    /**
     * Загрузка лога
     *
     * @param textLog лог
     * @return ResponseEntity
     */
    @PostMapping(value = "log", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> saveLog(@RequestBody LogImport textLog) {
        logService.saveLog(textLog);
        return ResponseEntity.ok().build();
    }

}
