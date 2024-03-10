package com.urban.easymensabackend.service.impl;

import com.urban.easymensabackend.model.menu.Allergen;
import com.urban.easymensabackend.repository.AllergenRepository;
import com.urban.easymensabackend.service.AllergenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
@RequiredArgsConstructor
public class AllergenServiceImpl implements AllergenService {

    private final AllergenRepository allergenRepository;
    @Override
    public List<Allergen> getAllergens() {
        return allergenRepository.findAll();
    }
}
