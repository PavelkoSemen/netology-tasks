package ru.netology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Я знаю что можно было изменять intList, а не создавать новый в каждом методе, но в данном случае это лишнее
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        intList = filterPositiveNumbers(intList);
        intList = filterEvenNumber(intList);
        bubbleSort(intList);
        printList(intList);

    }

    public static List<Integer> filterPositiveNumbers(List<Integer> inputList) {
        List<Integer> outputList = new ArrayList<>();

        for (int number : inputList) {
            if (number > 0) {
                outputList.add(number);
            }
        }

        return outputList;
    }

    public static List<Integer> filterEvenNumber(List<Integer> inputList) {
        List<Integer> outputList = new ArrayList<>();
        for (int number : inputList) {
            if (number % 2 == 0) {
                outputList.add(number);
            }
        }

        return outputList;
    }

    public static void bubbleSort(List<Integer> inputList) {
        for (int i = 0; i < inputList.size(); i++) {
            for (int j = i + 1; j < inputList.size(); j++) {
                if (inputList.get(i) > inputList.get(j)) {
                    int tmp = inputList.get(j);
                    inputList.set(j, inputList.get(i));
                    inputList.set(i, tmp);
                }
            }
        }
    }

    public static void printList(List<?> inputList) {
        for (Object value : inputList){
            System.out.print(value + " ");
        }
    }
}
