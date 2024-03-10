package com.urban.easymensabackend.controller;

import com.urban.easymensabackend.model.menu.Allergen;
import com.urban.easymensabackend.service.allergen.AllergenService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/** Controller class for managing Allergens. */
@RestController
@RequestMapping("/api/allergens")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
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
}
