package com.perficient.appts.apptmanagementsystemappts.controller;

import com.perficient.appts.apptmanagementsystemappts.service.ApptsDeleteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ApptsDeleteControllerTest {
    @Mock
    private ApptsDeleteService service;

    @InjectMocks
    private ApptsDeleteController controller;

    @Test
    public void testDeleteAppt() {
        Long id = 1L;

        ResponseEntity<?> response = controller.deleteApptById(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(service, times(1)).deleteApptById(eq(id));
    }

    @Test
    public void testDeleteAppt_Found() {
        Long id = 1L;

        when(service.deleteApptById(eq(id))).thenReturn(true);

        ResponseEntity<?> response = controller.deleteApptById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Appointment deleted", response.getBody());
        verify(service, times(1)).deleteApptById(eq(id));
    }

    @Test
    public void testDeleteAppt_Error() {
        Long id = 1L;

        when(service.deleteApptById(id)).thenReturn(false);

        ResponseEntity<?> response = controller.deleteApptById(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("The Appointment ID does not exist.", response.getBody());
        verify(service, times(1)).deleteApptById(eq(id));
    }

    @Test
    public void testDeleteAppt_Exception() {
        Long id = 1L;
        when(service.deleteApptById(id)).thenThrow(new RuntimeException("Failed to delete appointment"));

        ResponseEntity<?> response = controller.deleteApptById(id);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Failed to delete.", response.getBody());

        verify(service, times(1)).deleteApptById(id);
        verifyNoMoreInteractions(service);
    }

}