package com.perficient.appts.apptmanagementsystemappts.repository;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApptsRepository extends JpaRepository<ApptsEntity, Long> {
}


