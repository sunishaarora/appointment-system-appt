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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ApptsUpdateServiceImplTest {
    @Mock
    private ApptsRepository repository;

    @InjectMocks
    private ApptsUpdateServiceImpl service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testUpdateAppt() {
        Long id = 1L;
        ApptsEntity apptEntity = new ApptsEntity();
        apptEntity.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(apptEntity));
        when(repository.save(apptEntity)).thenReturn(apptEntity);

        Appts newAppt = new Appts();
        newAppt.setUserId(6L);

        ApptsEntity result = service.updateAppt(id, newAppt);
        verify(repository).findById(id);
        verify(repository).save(apptEntity);

        assertEquals(apptEntity, result);
        assertEquals(newAppt.getUserId(), result.getUserId());
    }

}