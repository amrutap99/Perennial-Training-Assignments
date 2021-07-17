package edu.ritindia.CovidSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * This is main class
 * Here, used annotations - @EnableScheduling,@EnableJpaRepositories("edu.ritindia")
 */
@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories("edu.ritindia")
public class CovidSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CovidSystemApplication.class, args);
    }

}
