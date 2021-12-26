package ru.netology;

import ru.netology.callcenter.CallCenter;
import ru.netology.callcenter.Operator;
import ru.netology.user.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int countCalls = 60;
        final int countOperator = 4;
        final List<Thread> operators = new ArrayList<>(countOperator);
        CallCenter callCenter = new CallCenter();
        Operator operator = new Operator(callCenter, countCalls);
        User user = new User(callCenter, countCalls);

        for (int i = 0; i < countOperator; i++) {
            operators.add(new Thread(operator, "Оператор " + (i + 1)));
        }
        new Thread(user, "Semen").start();

        operators.forEach(Thread::start);
        for (Thread t : operators) {
            t.join();
        }

        callCenter.printProcessedCalls();
    }
}
