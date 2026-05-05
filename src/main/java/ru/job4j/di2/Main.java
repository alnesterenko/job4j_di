package ru.job4j.di2;

import ru.job4j.di2.model.ConsoleInput;
import ru.job4j.di2.model.Context;
import ru.job4j.di2.model.StartUI;
import ru.job4j.di2.model.Store;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(ConsoleInput.class); /* Если не поместить в контекст, то он сам автомтически ничего не найдёт */
        context.reg(StartUI.class);

        StartUI ui = context.get(StartUI.class);

        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();
    }
}
