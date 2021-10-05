package ru.netology;

import ru.netology.workwithlist.OutdatedApproach;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Я знаю что можно было изменять intList, а не создавать новый в каждом методе, но в данном случае это лишнее
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        OutdatedApproach outdatedApproach = new OutdatedApproach();
        intList = outdatedApproach.filterPositiveNumbers(intList);
        intList = outdatedApproach.filterEvenNumber(intList);
        outdatedApproach.bubbleSort(intList);
        outdatedApproach.filterPositiveNumbers(null);
    }

    public static void printList(List<?> inputList) {
        for (Object value : inputList){
            System.out.print(value + " ");
        }
    }
}
