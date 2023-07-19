package com.perficient.appts.apptmanagementsystemappts.controller;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.model.Appts;
import com.perficient.appts.apptmanagementsystemappts.service.ApptsCreateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApptsCreateControllerTest {

    @Mock
    private ApptsCreateService service;

    @InjectMocks
    private ApptsCreateController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateAppt() {
        Appts appts = new Appts();
        appts.setApptName("Appointment 10");
        appts.setUserId(1L);
        appts.setApptType("Type A");
        appts.setDescription("This is the description of the appointment");

        ApptsEntity apptsEntity = new ApptsEntity();
        when(service.createAppt(appts)).thenReturn(apptsEntity);

        ResponseEntity<?> response = controller.createAppt(appts);

        verify(service).createAppt(appts);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(apptsEntity, response.getBody());
    }

    @Test
    public void testCreateAppt_Error() {
        Appts appts = new Appts();
        appts.setApptName("Appointment 10");
        appts.setUserId(1L);
        appts.setApptType("Type A");
        appts.setDescription("This is the description of the appointment");

        when(service.createAppt(appts)).thenThrow(new RuntimeException("Failed to create appointment."));

        ResponseEntity<?> response = controller.createAppt(appts);

        verify(service).createAppt(appts);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Failed to create appointment.", response.getBody());
    }

    @Test
    public void testCreateAppt_UserId() {
        Appts appts = new Appts();
        appts.setApptName("Appointment 10");
        appts.setApptType("Type A");
        appts.setDescription("This is the description of the appointment");

        ResponseEntity<?> response = controller.createAppt(appts);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("User ID cannot be null", response.getBody());
    }


}
