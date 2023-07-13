package com.perficient.appts.apptmanagementsystemappts.service;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.model.Appts;
import com.perficient.appts.apptmanagementsystemappts.repository.ApptsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ApptsCreateServiceTest {

    @Mock
    private ApptsRepository repository;

    @InjectMocks
    private ApptsCreateService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateAppt_Success() {
        Appts appt = new Appts();
        appt.setUserId(1L);
        appt.setApptName("Appointment 1");
        appt.setApptType("Type 1");
        appt.setDescription("Description 1");
        Date startTime = Calendar.getInstance().getTime();
        Date endTime = Calendar.getInstance().getTime();
        appt.setStartTime(startTime);
        appt.setEndTime(endTime);
        appt.setMetaData("Metadata 1");

        ApptsEntity expectedEntity = new ApptsEntity();
        expectedEntity.setId(1L);
        expectedEntity.setUserId(1L);
        expectedEntity.setApptName("Appointment 1");
        expectedEntity.setApptType("Type 1");
        expectedEntity.setDescription("Description 1");
        expectedEntity.setStartTime(startTime);
        expectedEntity.setEndTime(endTime);
        expectedEntity.setMetaData("Metadata 1");

        when(repository.save(any(ApptsEntity.class))).thenReturn(expectedEntity);
        ApptsEntity result = service.createAppt(appt);
        assertEquals(expectedEntity, result);
        verify(repository, times(1)).save(any(ApptsEntity.class));
        verifyNoMoreInteractions(repository);
    }

}
