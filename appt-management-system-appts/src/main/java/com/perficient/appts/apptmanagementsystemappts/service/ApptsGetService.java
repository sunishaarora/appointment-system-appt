package com.perficient.appts.apptmanagementsystemappts.service;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.repository.ApptsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApptsGetService {

    private ApptsRepository repository;

    @Autowired
    ApptsGetService(ApptsRepository repository) {
        this.repository = repository;
    }

    public ApptsEntity getApptById(Long id) {
        return repository.getById(id);//.orElse(null);
    }
}
