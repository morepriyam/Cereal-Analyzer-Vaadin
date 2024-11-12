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
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.morepriyam.cereal_analyzer_vaadin.model.Manufacturer;
import com.morepriyam.cereal_analyzer_vaadin.repository.ManufacturerRepository;

class ManufacturerServiceImplTest {

    @Mock
    private ManufacturerRepository repository;

    @InjectMocks
    private ManufacturerServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllManufacturers() {
        List<Manufacturer> mockManufacturers = Arrays.asList(
            new Manufacturer(1L, "N"),
            new Manufacturer(2L, "Q")
        );
        when(repository.findAll()).thenReturn(mockManufacturers);

        List<Manufacturer> result = service.getAllManufacturers();
        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetManufacturerById() {
        Manufacturer manufacturer = new Manufacturer(1L, "N");
        when(repository.findById(1L)).thenReturn(Optional.of(manufacturer));

        Optional<Manufacturer> result = service.getManufacturerById(1L);
        assertTrue(result.isPresent());
        assertEquals("N", result.get().getName());
    }

    @Test
    void testGetManufacturerByName() {
        Manufacturer manufacturer = new Manufacturer(1L, "N");
        when(repository.findByName("N")).thenReturn(Optional.of(manufacturer));

        Optional<Manufacturer> result = service.getManufacturerByName("N");
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void testAddManufacturer() {
        Manufacturer manufacturer = new Manufacturer(null, "New Manufacturer");
        when(repository.findByName("New Manufacturer")).thenReturn(Optional.empty());
        when(repository.save(any(Manufacturer.class))).thenReturn(manufacturer);

        Manufacturer result = service.addManufacturer(manufacturer);
        assertNotNull(result);
        verify(repository, times(1)).save(manufacturer);
    }

    @Test
    void testAddManufacturer_Conflict() {
        Manufacturer manufacturer = new Manufacturer(null, "N");
        when(repository.findByName("N")).thenReturn(Optional.of(manufacturer));

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, 
            () -> service.addManufacturer(manufacturer)
        );

        assertEquals(HttpStatus.CONFLICT, exception.getStatusCode());
        verify(repository, never()).save(any(Manufacturer.class));
    }

    @Test
    void testUpdateManufacturer() {
        Manufacturer manufacturer = new Manufacturer(null, "Updated Manufacturer");
        when(repository.existsById(1L)).thenReturn(true);
        when(repository.save(any(Manufacturer.class))).thenReturn(manufacturer);

        Manufacturer result = service.updateManufacturer(manufacturer, 1L);
        assertNotNull(result);
        verify(repository, times(1)).save(manufacturer);
    }

    @Test
    void testUpdateManufacturer_NotFound() {
        Manufacturer manufacturer = new Manufacturer(null, "Updated Manufacturer");
        when(repository.existsById(1L)).thenReturn(false);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, 
            () -> service.updateManufacturer(manufacturer, 1L)
        );

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
        verify(repository, never()).save(any(Manufacturer.class));
    }

    @Test
    void testDeleteManufacturer() {
        when(repository.existsById(1L)).thenReturn(true);
        doNothing().when(repository).deleteById(1L);

        assertDoesNotThrow(() -> service.deleteManufacturer(1L));
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteManufacturer_NotFound() {
        when(repository.existsById(1L)).thenReturn(false);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, 
            () -> service.deleteManufacturer(1L)
        );

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
        verify(repository, never()).deleteById(anyLong());
    }
}
