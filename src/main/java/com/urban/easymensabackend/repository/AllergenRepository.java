package com.urban.easymensabackend.repository;

import com.urban.easymensabackend.model.menu.Allergen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergenRepository extends JpaRepository<Allergen, Long> {}
