package com.mhdanh.prototype.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author danh.mai
 */
@RequestMapping("config")
@RestController
public class ConfigController {

    @Value("${app.label}")
    private String value;

    @GetMapping
    public String getValue() {
        return this.value;
    }

}
