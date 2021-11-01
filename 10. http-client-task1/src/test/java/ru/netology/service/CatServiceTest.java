package ru.netology.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Cat;
import ru.netology.serviceexception.CatServiceException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatServiceTest {

    private CatService catService;

    @BeforeEach
    void setUp() {
        catService = new CatService();
    }

    @Test
    void shouldContainTheExpectedObject() throws CatServiceException {

        Cat expectedCat = new Cat(
                "5b4910ae0508220014ccfe90"
                , "Кошки могут слышать ультразвук и коммуницировать с дельфинами."
                , "cat"
                , "Alex Petrov"
                , 12);

        List<Cat> cats = catService.getCatsFromService();

        assertTrue(cats.contains(expectedCat));
    }

    @Test
    void listShouldBeOfCertainLength() throws CatServiceException {
        int expectedListSize = 4;

        List<Cat> cats = catService.getCatsFromService();
        assertEquals(expectedListSize, cats.size());
    }


}