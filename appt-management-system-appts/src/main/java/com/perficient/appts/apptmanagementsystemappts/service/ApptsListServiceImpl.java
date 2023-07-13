package com.perficient.appts.apptmanagementsystemappts.service;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.repository.ApptsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApptsListServiceImpl implements ApptsListService{
    private ApptsRepository repository;

    @Autowired
    ApptsListServiceImpl(ApptsRepository repository) {
        this.repository = repository;
    }

    public List<ApptsEntity> getApptsList() {
        return repository.findAll();
    }
}
