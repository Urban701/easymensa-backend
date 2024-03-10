package com.urban.easymensabackend.model.menu;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "menu_plan")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private OffsetDateTime date;

    @ManyToMany
    @JoinTable(
            name = "menuplan_food",
            joinColumns = @JoinColumn(name = "menuplan_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private Set<Food> foods;
}
