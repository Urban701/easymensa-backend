package com.urban.easymensabackend.service.menuplan.impl;

import com.urban.easymensabackend.model.menu.MenuPlan;
import com.urban.easymensabackend.repository.MenuPlanRepository;
import com.urban.easymensabackend.service.menuplan.MenuPlanService;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@Service
@Log4j
@RequiredArgsConstructor
public class MenuPlanServiceImpl implements MenuPlanService {

  private final MenuPlanRepository menuPlanRepository;

  @Override
  public Set<MenuPlan> getMenuPlans() {
    return new HashSet<>(menuPlanRepository.getMenuPlan());
  }
}
