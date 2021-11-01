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
import ru.netology.entity.Cat;
import ru.netology.serviceexception.CatServiceException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CatService {
    private final CloseableHttpClient httpClient;
    public static final ObjectMapper mapper = new ObjectMapper();

    private final static String SERVICE_URI =
            "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    public CatService() {
        httpClient = getHttpClient();
    }


    public List<Cat> getCatsFromService() throws CatServiceException {
        log.info("Starting a request to get a list of cats");
        HttpGet request = new HttpGet(SERVICE_URI);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    log.info("Return list of cats");
                    return mapper.readValue(entity.getContent(), new TypeReference<List<Cat>>() {})
                            .stream()
                            .filter(value -> value.getUpvotes() != null
                                    && value.getUpvotes() > 0)
                            .collect(Collectors.toList());
                } else {
                    log.info("Return empty list of cats");
                    return new ArrayList<>();
                }

            }
        } catch (IOException e) {
            log.error("Server IO exception", e);
        }
        throw new CatServiceException();
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
