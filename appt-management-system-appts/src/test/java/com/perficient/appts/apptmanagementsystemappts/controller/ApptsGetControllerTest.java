package com.perficient.appts.apptmanagementsystemappts.controller;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.service.ApptsGetService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ApptsGetControllerTest {
    @Mock
    private ApptsGetService service;

    @InjectMocks
    private ApptsGetController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAppt() {
        Long id = 1L;
        ApptsEntity apptsEntity = new ApptsEntity();
        apptsEntity.setId(id);
        when(service.getApptById(id)).thenReturn(apptsEntity);

        ResponseEntity<?> response = controller.getApptById(id);

        verify(service).getApptById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(apptsEntity, response.getBody());

        verify(service, times(1)).getApptById(id);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void testGetAppt_NotFound() {
        Long id = 1L;

        when(service.getApptById(id)).thenThrow(new EntityNotFoundException("Appointment not found with ID: " + id));

        ResponseEntity<?> response = controller.getApptById(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("The Appointment ID does not exist.", response.getBody());

        verify(service, times(1)).getApptById(id);
        verifyNoMoreInteractions(service);
    }

}