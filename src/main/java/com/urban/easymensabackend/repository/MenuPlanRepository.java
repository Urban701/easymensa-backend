package com.urban.easymensabackend.repository;

import com.urban.easymensabackend.model.menu.MenuPlan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuPlanRepository extends JpaRepository<MenuPlan, Long> {

  @Query("SELECT DISTINCT mp FROM MenuPlan mp " + "LEFT JOIN FETCH mp.foods f ")
  List<MenuPlan> getMenuPlan();
}
