package com.perficient.appts.apptmanagementsystemappts.service;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.repository.ApptsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ApptsGetServiceImplTest {

    @Mock
    private ApptsRepository repository;

    @InjectMocks
    private ApptsGetServiceImpl service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAppt() {
        Long id = 1L;
        ApptsEntity appt = new ApptsEntity();
        appt.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(appt));
        ApptsEntity result = service.getApptById(id);
        assertNotNull(result);
        assertEquals(appt, result);
        verify(repository, times(1)).findById(id);
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void testGetAppt_NotFound() {
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> {
            service.getApptById(id);
        });
        verify(repository, times(1)).findById(id);
        verifyNoMoreInteractions(repository);
    }
}
