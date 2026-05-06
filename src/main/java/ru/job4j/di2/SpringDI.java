package ru.job4j.di2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.job4j.di2.model.Store;

import java.util.List;

public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.job4j.di2");
        context.refresh();
        Store store = context.getBean(Store.class);
        store.add("Petr Arsentev");
        Store another = context.getBean(Store.class);
        another.getAll().forEach(System.out::println);

        /* Ниже код добавленный мной */
        System.out.println("Содержимое store:");
        printContent(store.getAll());
        System.out.println("Содержимое another:");
        printContent(another.getAll());
    }

    public static void printContent(List<String> contentList) {
        if (contentList.isEmpty()) {
            System.out.println("Содержимое отсутствует!");
        } else {
            contentList.forEach(System.out::println);
        }
    }
}