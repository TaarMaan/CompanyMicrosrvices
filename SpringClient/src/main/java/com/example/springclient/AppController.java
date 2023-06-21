package com.example.springclient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для обработки HTTP-запросов в модуле SpringClient.
 */
@RestController
@RequiredArgsConstructor
public class AppController {

    private final SimpleClient client;

    /**
     * Реализация метода @findById из интерфейса SimpleClient
     *
     * @param companyId Идентификатор компании.
     * @return Информация о компании.
     */
    @GetMapping("/companies/{companyId}")
    public boolean findById(@PathVariable Integer companyId) {
        return client.findById(companyId);
    }

    /**
     * Реализация метода @getOne из интерфейса SimpleClient
     *
     * @param companyId Идентификатор компании.
     * @return Информация о компании.
     */
    @GetMapping("/companies/getOne/{companyId}")
    public String getOne(@PathVariable Integer companyId) {
        return client.getOne(companyId);
    }

}
