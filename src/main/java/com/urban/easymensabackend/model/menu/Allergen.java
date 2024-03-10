package com.urban.easymensabackend.model.menu;

import jakarta.persistence.*;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "allergen")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Allergen {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "short_name")
  private String shortName;

  @ManyToMany(mappedBy = "allergens")
  private Set<Food> foods;
}
