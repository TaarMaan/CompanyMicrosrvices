package com.example.springclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Интерфейс для реализации клиента и запросов по id компаний
 */
@FeignClient(name = "Companies", url = "http://localhost:8099")
public interface SimpleClient {

    /**
     * Получить информацию о компании по ее идентификатору.
     *
     * @param companyId Идентификатор компании.
     */
    @GetMapping("/companies/{companyId}")
    boolean findById (@PathVariable Integer companyId);

    /**
     * Получить информацию о конкретной компании по ее идентификатору.
     *
     * @param companyId Идентификатор компании.
     */
    @GetMapping("/companies/getOne/{companyId}")
    String getOne(@PathVariable Integer companyId);
}
