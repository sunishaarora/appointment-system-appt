package com.perficient.appts.apptmanagementsystemappts.service;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.repository.ApptsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApptsGetServiceImpl implements ApptsGetService{

    private ApptsRepository repository;

    @Autowired
    ApptsGetServiceImpl(ApptsRepository repository) {
        this.repository = repository;
    }

    public ApptsEntity getApptById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Appointment not found with ID: " + id));
    }
}
