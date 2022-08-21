package ru.sber.server.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sber.server.exception.ValidationFailedException;
import ru.sber.server.model.Log;
import ru.sber.server.model.LogImport;
import ru.sber.server.repository.Repo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


@Slf4j
@Service
public class LogService {

    private static Logger logger = Logger.getLogger("Frontend log");
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private final Repo repo;

    @Autowired
    public LogService(Repo repo) {
        this.repo = repo;
    }

    /**
     * Сохранение объекта лога в БД
     *
     * @param logImport объект лога в текстовом формате для обработки и сохранения
     */
    public void saveLog(LogImport logImport) {
        validateLogImport(logImport);
        LocalDateTime localDateTime = parseStringToDate(logImport.getTime());
        Log log = new Log(logImport);
        log.setTime(localDateTime);
        logger.info(log.toString());
        repo.save(log);
    }

    /**
     * Преобразование String даты в формат LocalDateTime
     *
     * @param stringTime Дата в текстовом формате
     * @return дата в формате LocalDateTime
     */
    private LocalDateTime parseStringToDate(String stringTime) {
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);
            return LocalDateTime.parse(stringTime, format);
        } catch (DateTimeParseException e) {
            log.warn("Дата не удовлетворяет  формату");
            throw new ValidationFailedException();
        }
    }

    /**
     * Проверка загружаемого лога на валидность
     *
     * @param logImport Лог в текстовом формате
     */
    private void validateLogImport(LogImport logImport) {
        boolean isValidated = true;

        if (logImport.getMessage() == null || logImport.getMessage().trim().equals("")) {
            log.warn("Поле Message не должно быть пустым");
            isValidated = false;
        }
        if (logImport.getLevel() == null
                || logImport.getLevel().trim().equals("")) {
            log.warn("Поле Level не должно быть пустым");
            isValidated = false;
        }
        if (logImport.getType() == null
                || logImport.getType().trim().equals("")) {
            log.warn("Поле Type не должно быть пустым");
            isValidated = false;
        }
        if (logImport.getTime() == null
                || logImport.getTime().toString().trim().equals("")) {
            log.warn("Поле Time не должно быть пустым");
            isValidated = false;
        }

        if (isValidated) {
            log.info("Схема импорта валидна");
        } else {
            throw new ValidationFailedException();
        }

    }

}
