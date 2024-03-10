package com.urban.easymensabackend.model.menu;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "food")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "image")
    private String image;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private DietType dietType;

    @ManyToMany(mappedBy = "foods")
    private Set<MenuPlan> menuPlans;

    @ManyToMany
    @JoinTable(
            name = "food_allergen",
            joinColumns = @JoinColumn(name = "allergen_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private Set<Allergen> allergens;


}
