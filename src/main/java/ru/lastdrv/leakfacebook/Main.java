package ru.lastdrv.leakfacebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.lastdrv.leakfacebook.EntryPoints.FillFacebook;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(FillFacebook.class, args);
    }
}