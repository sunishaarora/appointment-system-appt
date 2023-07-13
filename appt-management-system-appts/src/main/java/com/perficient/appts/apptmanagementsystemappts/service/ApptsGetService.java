package com.perficient.appts.apptmanagementsystemappts.service;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;

public interface ApptsGetService {
    ApptsEntity getApptById(Long id);
}
