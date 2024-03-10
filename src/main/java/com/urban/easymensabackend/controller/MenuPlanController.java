package com.urban.easymensabackend.controller;

import com.urban.easymensabackend.model.menu.MenuPlan;
import com.urban.easymensabackend.service.menuplan.MenuPlanService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/** Controller class for managing MenuPlans. */
@RestController
@RequestMapping("/api/menuplan")
@RequiredArgsConstructor
@Log4j
@CrossOrigin(origins = "http://localhost:4200/")
public class MenuPlanController {

  private final MenuPlanService menuPlanService;

  /**
   * Retrieves a list of all allergens.
   *
   * @return List of allergens.
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<MenuPlan> getMenuPlan() {
    var menuplan = menuPlanService.getMenuPlans().stream().toList();
    return menuplan;
  }
}
