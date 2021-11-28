package ru.netology;

import ru.netology.service.NasaClient;

public class Main {
    public static void main(String[] args) {
        NasaClient nasaClient = new NasaClient();
        nasaClient.loadingImage();
    }
}
