package ru.job4j.annotation;

import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

/*
* Spring автоматически дает бинам наименования по такому принципу:
 - если бин создан с помощью аннотации @Component,
 *  то имя бина будет именем класса с заменой первой буквы с прописной на строчную
 *  (например, имя бина из класса Cat будет "cat");
 *
- если бин создан с помощью аннотации @Bean,
*  то он получит в качестве имени наименование метода, в котором он создан
*  (например, первый бин из класса Config получит имя "getAlfaDog").

*  Второму бину из класса Config мы сами назначили имя  "SecondDog".
* */

/* Как я понял, при наличии анотации @ComponentScan, Spring "пылесосит" весь пакет в поисках бинов  */
/* Путь пакета, где находятся компоненты прописываем от папки java */

@Configuration
@ComponentScan(basePackages = "ru/job4j/annotation")
@PropertySource("classpath:application.properties")
public class Config {

    @Bean
    @Primary
    @Order(11)
    public Dog getAlfaDog() {
        return new Dog("AlfaDog");
    }

    @Order(3)
    @Bean(name = "SecondDog")
    public Dog getDog() {
        return new Dog("SecondDog");
    }

    @Order(5)
    @Bean
    public Dog someDog() {
        return new Dog("someDog(взято из метода someDog)");
    }
}
