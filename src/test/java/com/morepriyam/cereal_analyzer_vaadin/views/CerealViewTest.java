package com.morepriyam.cereal_analyzer_vaadin.views;

import com.morepriyam.cereal_analyzer_vaadin.model.Cereal;
import com.morepriyam.cereal_analyzer_vaadin.model.Manufacturer;
import com.morepriyam.cereal_analyzer_vaadin.service.CerealService;
import com.morepriyam.cereal_analyzer_vaadin.service.ManufacturerService;
import com.morepriyam.cereal_analyzer_vaadin.repository.CerealRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class CerealViewTest {

    private CerealService cerealService;
    private ManufacturerService manufacturerService;
    private CerealRepository cerealRepository;
    private CerealView cerealView;

    @BeforeEach
    void setUp() {
        cerealService = mock(CerealService.class);
        manufacturerService = mock(ManufacturerService.class);
        cerealRepository = mock(CerealRepository.class);

        // Use the updated constructor
        cerealView = new CerealView(cerealService, manufacturerService, cerealRepository);
    }

    @Test
    void shouldInitializeWithCerealsInGrid() {
        Cereal cereal = new Cereal("Test Cereal", "C", 100, 5.0, 2.0, 150.0, 3.0, 20.0, 10.0, 50.0, 25, 1, 1.0, 0.5,
                75.5, new Manufacturer());
        when(cerealService.getCereals()).thenReturn(List.of(cereal));

        cerealView.triggerResetGrid();

        assertThat(cerealView.getCerealGrid().getGenericDataView().getItems().iterator().next()).isEqualTo(cereal);
    }

    @Test
    void shouldAddCerealWhenFieldsAreValid() {
        Manufacturer manufacturer = new Manufacturer(1L, "Test Manufacturer");
        when(manufacturerService.getManufacturerById(anyLong())).thenReturn(Optional.of(manufacturer));
        when(cerealService.addCereal(any())).thenReturn(new Cereal());

        // Simulate filling fields and clicking the Add button
        cerealView.getNameField().setValue("Test Cereal");
        cerealView.getTypeField().setValue("C");
        cerealView.getCaloriesField().setValue(100.0);
        cerealView.getAddButton().click();

        verify(cerealService).addCereal(any());
    }

    @Test
    void shouldShowMaxRatedCereal() {
        Cereal maxRatedCereal = new Cereal("Max Rated", "C", 200, 5.0, 3.0, 150.0, 3.0, 20.0, 10.0, 50.0, 25, 1, 1.0, 0.5,
                100.0, new Manufacturer());
        when(cerealRepository.findAll()).thenReturn(List.of(maxRatedCereal));

        cerealView.getMaxRatedButton().click();

        assertThat(cerealView.getCerealGrid().getGenericDataView().getItems().iterator().next()).isEqualTo(maxRatedCereal);
    }
}
