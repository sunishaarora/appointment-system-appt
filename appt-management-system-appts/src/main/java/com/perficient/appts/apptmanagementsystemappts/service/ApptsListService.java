package com.perficient.appts.apptmanagementsystemappts.service;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;

import java.util.List;

public interface ApptsListService {
    List<ApptsEntity> getApptsList();
}
