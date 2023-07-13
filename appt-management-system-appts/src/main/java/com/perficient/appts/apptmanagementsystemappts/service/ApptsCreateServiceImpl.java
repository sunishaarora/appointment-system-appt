package com.perficient.appts.apptmanagementsystemappts.service;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.model.Appts;
import com.perficient.appts.apptmanagementsystemappts.repository.ApptsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApptsCreateServiceImpl implements ApptsCreateService{
    private ApptsRepository repository;

    @Autowired
    public ApptsCreateServiceImpl(ApptsRepository repository) {
        this.repository = repository;
    }

    public ApptsEntity createAppt(Appts appt) {
        ApptsEntity apptsEntity = convertToApptsEntity(appt);
        return repository.save(apptsEntity);
    }

    public ApptsEntity convertToApptsEntity(Appts appt) {
        ApptsEntity apptEntity = new ApptsEntity();
        apptEntity.setUserId(appt.getUserId());
        apptEntity.setApptName(appt.getApptName());
        apptEntity.setApptType(appt.getApptType());
        apptEntity.setDescription(appt.getDescription());
        apptEntity.setStartTime(appt.getStartTime());
        apptEntity.setEndTime(appt.getEndTime());
        apptEntity.setMetaData(appt.getMetaData());
        return apptEntity;
    }
}
