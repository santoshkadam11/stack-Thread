package com.net.stackthread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.net.stackthread.repositories")
@EntityScan("com.net.stackthread.entities")
@SpringBootApplication
public class StackThreadApplication {

    public static void main(String[] args) {
        SpringApplication.run(StackThreadApplication.class, args);
    }

}
