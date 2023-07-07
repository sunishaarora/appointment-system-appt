package com.perficient.appts.apptmanagementsystemappts.controller;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;

import com.perficient.appts.apptmanagementsystemappts.model.Appts;
import com.perficient.appts.apptmanagementsystemappts.service.ApptsUpdateService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@SpringBootTest
class ApptsUpdateControllerTest {
    @Mock
    private ApptsUpdateService service;

    @InjectMocks
    private ApptsUpdateController controller;

    @Test
    public void testUpdateAppt() {
        Long id = 1L;
        Appts newAppt = new Appts();
        ApptsEntity newEntity = new ApptsEntity();

        when(service.updateAppt(eq(id), any(Appts.class))).thenReturn(newEntity);

        ResponseEntity<?> response = controller.updateAppt(id, newAppt);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(newEntity, response.getBody());
        verify(service, times(1)).updateAppt(eq(id), any(Appts.class));
    }
}