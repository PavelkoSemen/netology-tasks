package ru.netology.listener;

@FunctionalInterface
public interface OnTaskDoneListener {
    void onDone(String result);
}
