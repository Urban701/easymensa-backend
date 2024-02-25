package com.urban.easymensabackend.controller;

import com.urban.easymensabackend.model.Allergen;
import com.urban.easymensabackend.service.AllergenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/allergens")
@RequiredArgsConstructor
public class AllergenController {
    private final AllergenService allergenService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Allergen> getAllergens() {
        return allergenService.getAllergens();
    }


}
