package com.perficient.appts.apptmanagementsystemappts.service;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.repository.ApptsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ApptsListServiceTest {

    @Mock
    private ApptsRepository repository;

    @InjectMocks
    private ApptsListService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testApptsList() {
        List<ApptsEntity> apptsList = Arrays.asList(new ApptsEntity(), new ApptsEntity());
        when(repository.findAll()).thenReturn(apptsList);
        List<ApptsEntity> result = service.getApptsList();
        assertEquals(apptsList, result);
        verify(repository, times(1)).findAll();
        verifyNoMoreInteractions(repository);
    }
}
