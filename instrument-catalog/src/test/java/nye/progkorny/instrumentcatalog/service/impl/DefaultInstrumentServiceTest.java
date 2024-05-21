package nye.progkorny.instrumentcatalog.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import nye.progkorny.instrumentcatalog.data.model.Instrument;
import nye.progkorny.instrumentcatalog.data.model.InstrumentType;
import nye.progkorny.instrumentcatalog.data.repository.Repository;
import nye.progkorny.instrumentcatalog.service.InstrumentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class DefaultInstrumentServiceTest {

    @Mock
    private Repository<Instrument, Long> instrumentRepository;

    @InjectMocks
    private DefaultInstrumentService instrumentService;

    private Instrument instrument;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        instrument = new Instrument(1L, "Guitar", "Fender", "Stratocaster", InstrumentType.STRING);
    }

    @Test
    void testCreateInstrument() {
        when(instrumentRepository.save(any(Instrument.class))).thenReturn(instrument);
        Instrument createdInstrument = instrumentService.createInstrument(instrument);
        assertEquals(instrument, createdInstrument);
        verify(instrumentRepository, times(1)).save(instrument);
    }

    @Test
    void testRetrieveInstrumentById() {
        when(instrumentRepository.getById(1L)).thenReturn(Optional.of(instrument));
        Optional<Instrument> retrievedInstrument = instrumentService.retrieveInstrumentById(1L);
        assertEquals(Optional.of(instrument), retrievedInstrument);
        verify(instrumentRepository, times(1)).getById(1L);
    }

    @Test
    void testRetrieveAllInstruments() {
        List<Instrument> instruments = Arrays.asList(instrument, new Instrument(2L, "Piano", "Yamaha", "U1", InstrumentType.KEYBOARD));
        when(instrumentRepository.getAll()).thenReturn(instruments);
        List<Instrument> retrievedInstruments = instrumentService.retrieveAllInstruments();
        assertEquals(instruments, retrievedInstruments);
        verify(instrumentRepository, times(1)).getAll();
    }

    @Test
    void testUpdateInstrument() {
        when(instrumentRepository.update(any(Instrument.class))).thenReturn(instrument);
        Instrument updatedInstrument = instrumentService.updateInstrument(instrument);
        assertEquals(instrument, updatedInstrument);
        verify(instrumentRepository, times(1)).update(instrument);
    }

    @Test
    void testDeleteInstrumentById() {
        doNothing().when(instrumentRepository).deleteById(1L);
        instrumentService.deleteInstrumentById(1L);
        verify(instrumentRepository, times(1)).deleteById(1L);
    }
}
