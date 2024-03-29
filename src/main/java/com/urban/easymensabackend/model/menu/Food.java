package com.urban.easymensabackend.model.menu;

import jakarta.persistence.*;
import java.util.Set;
import lombok.*;

@Entity
@Table(name = "food")
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Food {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "image", columnDefinition = "LONGTEXT")
  private String image;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private DietType dietType;

  @ManyToMany
  @JoinTable(
      name = "food_allergen",
      joinColumns = @JoinColumn(name = "allergen_id"),
      inverseJoinColumns = @JoinColumn(name = "food_id"))
  private Set<Allergen> allergens;
}
