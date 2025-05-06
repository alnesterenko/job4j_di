package ru.job4j.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bird implements Pet<Bird> {
    @Value("${bird.name:Popudlay}")
    private String name = "Bird";

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String print() {
        return "Bird name = %s".formatted(name);
    }
}
