package com.perficient.appts.apptmanagementsystemappts.service;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.repository.ApptsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApptsDeleteServiceImpl implements ApptsDeleteService{
    private ApptsRepository repository;
    @Autowired
    ApptsDeleteServiceImpl(ApptsRepository repository) {
        this.repository = repository;
    }

    public boolean deleteApptById(Long id) {
        Optional<ApptsEntity> appt = repository.findById(id);
        if (appt.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
