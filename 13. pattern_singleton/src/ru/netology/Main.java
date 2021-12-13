package ru.netology;

import ru.netology.filter.Filter;
import ru.netology.logger.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static Logger logger = Logger.getInstance();

    public static void main(String[] args) {
        logger.log("Запускаем программу");
        Scanner scanner = new Scanner(System.in);
        logger.log("Просим пользователя ввести входные данные для списка");

        System.out.print("Введите размер списка:");
        int lengthList = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите верхнюю границу для значений:");
        int maximumValue = Integer.parseInt(scanner.nextLine());

        List<Integer> source = createList(lengthList, maximumValue);
        System.out.println("Вот случайный список: " + source);

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра:");
        int threshold = Integer.parseInt(scanner.nextLine());
        Filter filter = new Filter(threshold);
        List<Integer> result = filter.filterOut(source);

        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + result);
        logger.log("Завершаем программу");
    }

    public static List<Integer> createList(int lengthList, int maximumValue) {
        logger.log("Создаём и наполняем список");

        List<Integer> targetList = new ArrayList<>();
        for (int i = 0; i < lengthList; i++) {
            targetList.add((int) (Math.random() * maximumValue));
        }

        return targetList;
    }
}
