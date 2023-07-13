package com.perficient.appts.apptmanagementsystemappts.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApptsEntity that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(apptName, that.apptName) && Objects.equals(apptType, that.apptType) && Objects.equals(description, that.description) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(metaData, that.metaData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, apptName, apptType, description, startTime, endTime, metaData);
    }

    @Override
    public String toString() {
        return "ApptsEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", apptName='" + apptName + '\'' +
                ", apptType='" + apptType + '\'' +
                ", description='" + description + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", metaData='" + metaData + '\'' +
                '}';
    }
}
