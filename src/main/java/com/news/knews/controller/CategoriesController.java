package com.news.knews.controller;

import com.news.knews.domain.Categories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class CategoriesController {
    @GetMapping("/categories")
    public Map<String, Object> getEnum() {
        Map<String, Object> enums = new LinkedHashMap<>();

        Class categories = Categories.class;

        enums.put("categories", categories.getEnumConstants());
        return enums;
    }
}
