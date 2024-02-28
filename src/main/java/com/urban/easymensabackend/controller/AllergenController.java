package com.urban.easymensabackend.controller;

import com.urban.easymensabackend.model.Allergen;
import com.urban.easymensabackend.service.AllergenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing Allergens.
 */
@RestController
@RequestMapping("/api/allergens")
@RequiredArgsConstructor
public class AllergenController {

    private final AllergenService allergenService;

    /**
     * Retrieves a list of all allergens.
     *
     * @return List of allergens.
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Allergen> getAllergens() {
        return allergenService.getAllergens();
    }

    @GetMapping(value = "/test")
    @ResponseStatus(HttpStatus.OK)
    public String test() {
        return "Test";
    }
}
