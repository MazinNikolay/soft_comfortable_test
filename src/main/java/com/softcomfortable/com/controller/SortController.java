package com.softcomfortable.com.controller;

import com.softcomfortable.com.service.impl.SortServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Контроллер для работы с Excel файлами")
@RequiredArgsConstructor
public class SortController {
    private final SortServiceImpl service;

    @Operation(summary = "Сортировка и получение заданного максимального числа из файла",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Успешно найдено N-е максимальное число",
                            content = @Content(schema = @Schema(implementation = Integer.class))),
                    @ApiResponse(responseCode = "400",
                            description = "Ошибка ввода данных",
                            content = @Content(schema = @Schema(implementation = String.class)))
            })
    @PostMapping
    public Integer sortAndGetNMaxElement(@RequestParam String filePath,
                                         @RequestParam Integer n) {
        return service.sortAndGetNMaxElement(filePath, n);
    }
}
