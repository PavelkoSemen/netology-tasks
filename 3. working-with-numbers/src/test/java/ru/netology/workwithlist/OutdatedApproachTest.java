package ru.netology.workwithlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.listexception.ListNotFoundException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class OutdatedApproachTest {
    private List<Integer> intList;
    private OutdatedApproach outdatedApproach;

    @BeforeEach
    void setUp() {
        outdatedApproach = new OutdatedApproach();
        intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
    }

    @Test
    @DisplayName("возвращает список положительных чисел")
    void shouldReturnListOfPositiveNumbers() {
        final List<Integer> actualList = outdatedApproach.filterPositiveNumbers(intList);

        assertThat(actualList, everyItem(greaterThan(0)));
    }

    @Test
    @DisplayName("возвращает список положительных чисел 1")
    void shouldReturnAnEmptyList() {
        final List<Integer> intList1 = Arrays.asList(-1, -2, -32, -3);

        final List<Integer> actualList = outdatedApproach.filterPositiveNumbers(intList1);

        assertThat(actualList, empty());
    }

    @Test
    @DisplayName("возвращает список четных чисел")
    void shouldReturnListOfEvenNumbers() {
        final List<Integer> actualList = outdatedApproach.filterEvenNumber(intList);

        assertThat(actualList, contains(2, 16, -2, 0, 32, 8, 4));
    }

    @Test
    @DisplayName("сортирует список по возростанию")
    void shouldSortListInDescendingOrder() {
        final List<Integer> actualList = intList;
        outdatedApproach.bubbleSort(actualList);


        final List<Integer> expectedList = intList;
        Collections.sort(expectedList);

        assertEquals(expectedList, actualList);
    }

    @Test
    @DisplayName("выкинуть ListNotFoundException если передан null в bubbleSort()")
    void shouldThrowListNotFoundExceptionWhenPassingAnEmptyValue1() {
        assertThrows(ListNotFoundException.class, () -> outdatedApproach.bubbleSort(null));

    }

    @Test
    @DisplayName("выкинуть ListNotFoundException если передан null в filterPositiveNumbers()")
    void shouldThrowListNotFoundExceptionWhenPassingAnEmptyValue2() {
        assertThrows(ListNotFoundException.class, () -> outdatedApproach.filterPositiveNumbers(null));

    }

    @Test
    @DisplayName("выкинуть ListNotFoundException если передан null в filterEvenNumber()")
    void shouldThrowListNotFoundExceptionWhenPassingAnEmptyValue3() {
        assertThrows(ListNotFoundException.class, () -> outdatedApproach.filterEvenNumber(null));

    }

}