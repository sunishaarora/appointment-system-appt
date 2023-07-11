package com.perficient.appts.apptmanagementsystemappts.service;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.model.Appts;
import com.perficient.appts.apptmanagementsystemappts.repository.ApptsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApptsUpdateService {
    private ApptsRepository repository;

    @Autowired
    public ApptsUpdateService(ApptsRepository repository) {
        this.repository = repository;
    }

    public ApptsEntity updateAppt(Long id, Appts appt) {
        Optional<ApptsEntity> searchAppt = repository.findById(id);
        if (searchAppt.isEmpty()) {
            throw new IllegalArgumentException("Appointment not found.");
        }
        ApptsEntity foundAppt = searchAppt.get();
        updateFields(foundAppt, appt);

        return repository.save(foundAppt);
    }

    private void updateFields(ApptsEntity entity, Appts appt) {
        if (appt.getUserId() != null) {
            entity.setUserId(appt.getUserId());
        }
        if (appt.getApptName() != null) {
            entity.setApptName(appt.getApptName());
        }
        if (appt.getApptType() != null) {
            entity.setApptType(appt.getApptType());
        }
        if (appt.getDescription() != null) {
            entity.setDescription(appt.getDescription());
        }
        if (appt.getStartTime() != null) {
            entity.setStartTime(appt.getStartTime());
        }
        if (appt.getEndTime() != null) {
            entity.setEndTime(appt.getEndTime());
        }
        if (appt.getMetaData() != null) {
            entity.setMetaData(appt.getMetaData());
        }
    }
}
