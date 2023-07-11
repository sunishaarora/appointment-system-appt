package com.perficient.appts.apptmanagementsystemappts.controller;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.service.ApptsListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ApptsListControllerTest {

    @Mock
    private ApptsListService service;

    @InjectMocks
    private ApptsListController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testApptsList() {
        List<ApptsEntity> apptsList = Arrays.asList(new ApptsEntity(), new ApptsEntity());
        when(service.getApptsList()).thenReturn(apptsList);
        ResponseEntity<List<ApptsEntity>> response = controller.getApptsList();
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(apptsList, response.getBody());
        verify(service, times(1)).getApptsList();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void testApptsList_Fail() {
        when(service.getApptsList()).thenReturn(null);
        ResponseEntity<List<ApptsEntity>> response = controller.getApptsList();
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(service, times(1)).getApptsList();
        verifyNoMoreInteractions(service);
    }
}
