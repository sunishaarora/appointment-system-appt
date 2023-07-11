package com.perficient.appts.apptmanagementsystemappts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appts {
    private Long id;
    private Long userId;
    private String apptName;
    private String apptType;
    private String description;
    private Date startTime;
    private Date endTime;
    private String metaData;
}
