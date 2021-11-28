package ru.netology.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import ru.netology.entity.NasaResponse;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
public class NasaClient {
    private final CloseableHttpClient httpClient;
    public static final ObjectMapper mapper = new ObjectMapper()
            .setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

    private static final String SERVICE_NASA_URI =
            "https://api.nasa.gov/planetary/apod?api_key=SzjWpNOhTGgEdl3VSIbt2qZJZsHODo2FLbSU93h4";

    public NasaClient() {
        this.httpClient = getHttpClient();
    }

    public void loadingImage() {
        log.info("Sent a request to the nasa server");
        HttpGet request = new HttpGet(SERVICE_NASA_URI);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    NasaResponse nasaResponse = mapper.readValue(entity.getContent(), NasaResponse.class);
                    System.out.println(nasaResponse);
                    readImage(nasaResponse.getUrl());
                }
            }
        } catch (IOException e) {
            log.error("Server IO exception", e);
        }
    }

    private void readImage(String imageUrl) {
        log.info("Reading a picture from {}", imageUrl);
        String imageName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);

        HttpGet request = new HttpGet(imageUrl);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream inputStream = entity.getContent();
                byte [] bytes = inputStream.readAllBytes();

                inputStream.read(bytes);
                saveImage(imageName, bytes);
            }

        } catch (IOException e) {
            log.error("Can not read image", e);
        }
    }


    private void saveImage(String name, byte[] bytes) {
        Path path = Paths.get("11. http-client-task2", "src", "main", "resources", name);
        log.info("Saving image in {}", path);
        try {
            Files.write(path, bytes);
        } catch (IOException e) {
            log.error("Can not saving image: {}", e.toString());
        }

    }


    private CloseableHttpClient getHttpClient() {
        log.info("Create HTTP Client");
        return HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();
    }
}
