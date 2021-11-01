package ru.netology;

import ru.netology.service.CatService;
import ru.netology.serviceexception.CatServiceException;


public class Main {
    public static void main(String[] args) throws CatServiceException {
        CatService catService = new CatService();

        catService.getCatsFromService()
                .forEach(System.out::println);

    }
}
