package ru.netology.workwithlist;

import ru.netology.listexception.ListNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class OutdatedApproach {

    public List<Integer> filterPositiveNumbers(List<Integer> inputList) {
        this.checkList(inputList);

        List<Integer> outputList = new ArrayList<>();
        for (int number : inputList) {
            if (number > 0) {
                outputList.add(number);
            }
        }
        return outputList;
    }

    public List<Integer> filterEvenNumber(List<Integer> inputList) {
        this.checkList(inputList);

        List<Integer> outputList = new ArrayList<>();
        for (int number : inputList) {
            if (number % 2 == 0) {
                outputList.add(number);
            }
        }

        return outputList;
    }

    public void bubbleSort(List<Integer> inputList) {
        this.checkList(inputList);

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

    private void checkList(List<?> list){
        if (list == null)
            throw new ListNotFoundException("список не существует");
    }
}
