package org.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.test.entity.ActorDAO;
import org.test.repository.ActorRepository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@SpringBootApplication
public class TestConfigurable {

    @Autowired
    private ActorRepository actorRepository;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SpringApplication.run(TestConfigurable.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {

            ActorDAO actorDAO = ActorDAO.builder()
                    .firstName("Ggoole")
                    .lastName("Kkumar")
                    .lastUpdate(Timestamp.valueOf(LocalDateTime.now())
//                            .format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")
                            )
                    .build();

            actorDAO = actorRepository.save(actorDAO);
            log.info("Actor DAO saved: {}", actorDAO);

        };
    }

}
