package ru.netology.filter;

import ru.netology.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;
    private static Logger logger = Logger.getInstance();

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        logger.log("Запускаем фильтрацию");
        List<Integer> result = new ArrayList<>();
        for (int v : source) {
            if (v <= threshold) {
                logger.log(String.format("Элемент \"%d\" не проходит", v));
            } else {
                logger.log(String.format("Элемент \"%d\" проходит", v));
                result.add(v);
            }
        }
        logger.log(String.format("Прошло фильтр %d элемента из %d", result.size(), source.size()));
        return result;
    }
}
