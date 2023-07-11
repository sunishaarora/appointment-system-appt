package com.perficient.appts.apptmanagementsystemappts.service;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.repository.ApptsRepository;
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
class ApptsDeleteServiceTest {

    @Mock
    private ApptsRepository repository;

    @InjectMocks
    private ApptsDeleteService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDeleteAppt() {
        Long id = 1L;
        ApptsEntity apptEntity = new ApptsEntity();
        apptEntity.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(apptEntity));
        doNothing().when(repository).deleteById(id);
        boolean result = service.deleteApptById(id);
        verify(repository).findById(id);
        verify(repository).deleteById(id);
        assertTrue(result);
    }


}
