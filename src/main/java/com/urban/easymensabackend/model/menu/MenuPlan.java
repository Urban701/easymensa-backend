package com.urban.easymensabackend.model.menu;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.*;

@Entity
@Table(name = "menu_plan")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuPlan {
  @Id
  @Column(name = "date")
  private LocalDate date;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "menuplan_food",
      joinColumns = @JoinColumn(name = "menuplan_id"),
      inverseJoinColumns = @JoinColumn(name = "food_id"))
  private Set<Food> foods = new HashSet<>();
}
