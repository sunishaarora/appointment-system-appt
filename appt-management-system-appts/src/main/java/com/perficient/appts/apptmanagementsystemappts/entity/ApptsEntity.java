package com.perficient.appts.apptmanagementsystemappts.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "appointments")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ApptsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "appt_name")
    private String apptName;

    @Column(name = "appt_type")
    private String apptType;

    @Column(name = "description")
    private String description;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "metadata")
    private String metaData;

}
