package ru.sber.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table()
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String message;

    @NotNull
    @Column(nullable = false)
    private String type;

    @NotNull
    @Column(nullable = false)
    private String level;

    @NotNull
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;

    public Log(LogImport logImport) {
        this.message = logImport.getMessage();
        this.type = logImport.getType();
        this.level = logImport.getLevel();
    }

    @Override
    public String toString() {
        return "Log{" +
                "message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", time=" + time +
                '}';
    }
}
