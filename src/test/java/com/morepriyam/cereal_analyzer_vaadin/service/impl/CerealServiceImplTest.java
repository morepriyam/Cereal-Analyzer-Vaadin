package com.morepriyam.cereal_analyzer_vaadin.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import com.morepriyam.cereal_analyzer_vaadin.model.Cereal;
import com.morepriyam.cereal_analyzer_vaadin.model.Manufacturer;
import com.morepriyam.cereal_analyzer_vaadin.repository.CerealRepository;

class CerealServiceImplTest {

    @Mock
    private CerealRepository repository;

    @InjectMocks
    private CerealServiceImpl service;

    private Manufacturer manufacturer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        manufacturer = new Manufacturer(1L, "Test Manufacturer");
    }

    @Test
    void testGetCereals() {
        List<Cereal> cereals = Arrays.asList(
            new Cereal("Cereal1", "Type1", 100, 3.5, 1.0, 50, 5.0, 20.0, 10.0, 100.0, 10, 1, 1.0, 0.75, 50.0, manufacturer),
            new Cereal("Cereal2", "Type2", 150, 4.0, 2.0, 60, 4.5, 22.0, 8.0, 90.0, 15, 2, 1.2, 0.5, 45.0, manufacturer)
        );
        when(repository.findAll()).thenReturn(cereals);

        List<Cereal> result = service.getCereals();
        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetCerealByName() {
        Cereal cereal = new Cereal("Cereal1", "Type1", 100, 3.5, 1.0, 50, 5.0, 20.0, 10.0, 100.0, 10, 1, 1.0, 0.75, 50.0, manufacturer);
        when(repository.findByName("Cereal1")).thenReturn(Optional.of(cereal));

        Optional<Cereal> result = service.getCereal("Cereal1");
        assertTrue(result.isPresent());
        assertEquals("Cereal1", result.get().getName());
    }

    @Test
    void testGetCerealById() {
        Cereal cereal = new Cereal("Cereal1", "Type1", 100, 3.5, 1.0, 50, 5.0, 20.0, 10.0, 100.0, 10, 1, 1.0, 0.75, 50.0, manufacturer);
        when(repository.findById(1L)).thenReturn(Optional.of(cereal));

        Optional<Cereal> result = service.getCerealById(1L);
        assertTrue(result.isPresent());
        assertEquals("Cereal1", result.get().getName());
    }

    @Test
    void testAddCereal() {
        Cereal cereal = new Cereal("Cereal1", "Type1", 100, 3.5, 1.0, 50, 5.0, 20.0, 10.0, 100.0, 10, 1, 1.0, 0.75, 50.0, manufacturer);
        when(repository.save(any(Cereal.class))).thenReturn(cereal);

        Cereal result = service.addCereal(cereal);
        assertNotNull(result);
        verify(repository, times(1)).save(cereal);
    }

    @Test
    void testUpdateCereal() {
        Cereal cereal = new Cereal("Cereal1", "Type1", 100, 3.5, 1.0, 50, 5.0, 20.0, 10.0, 100.0, 10, 1, 1.0, 0.75, 50.0, manufacturer);
        when(repository.existsById(1L)).thenReturn(true);
        when(repository.save(any(Cereal.class))).thenReturn(cereal);

        assertDoesNotThrow(() -> service.updateCereal(cereal, 1L));
        verify(repository, times(1)).save(cereal);
    }

    @Test
    void testUpdateCereal_NotFound() {
        Cereal cereal = new Cereal("Cereal1", "Type1", 100, 3.5, 1.0, 50, 5.0, 20.0, 10.0, 100.0, 10, 1, 1.0, 0.75, 50.0, manufacturer);
        when(repository.existsById(1L)).thenReturn(false);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, 
            () -> service.updateCereal(cereal, 1L)
        );
        assertEquals("404 NOT_FOUND \"Cereal not found\"", exception.getMessage());
        verify(repository, never()).save(any(Cereal.class));
    }

    @Test
    void testDeleteCereal() {
        Cereal cereal = new Cereal("Cereal1", "Type1", 100, 3.5, 1.0, 50, 5.0, 20.0, 10.0, 100.0, 10, 1, 1.0, 0.75, 50.0, manufacturer);
        when(repository.findByName("Cereal1")).thenReturn(Optional.of(cereal));
        doNothing().when(repository).delete(cereal);

        boolean result = service.deleteCereal("Cereal1");
        assertTrue(result);
        verify(repository, times(1)).delete(cereal);
    }

    @Test
    void testDeleteCereal_NotFound() {
        when(repository.findByName("Cereal1")).thenReturn(Optional.empty());

        boolean result = service.deleteCereal("Cereal1");
        assertFalse(result);
        verify(repository, never()).delete(any(Cereal.class));
    }
}
