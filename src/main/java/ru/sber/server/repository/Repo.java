package ru.sber.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sber.server.model.Log;

@Repository
public interface Repo extends JpaRepository<Log, Long> {
}
