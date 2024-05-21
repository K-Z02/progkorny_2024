package nye.progkorny.instrumentcatalog.service;

import java.util.List;
import java.util.Optional;

import nye.progkorny.instrumentcatalog.data.model.Instrument;

/**
 * A service for managing instruments in the instrument catalog.
 */
public interface InstrumentService {

    /**
     * Creates a new instrument.
     *
     * @param instrument the instrument to create
     * @return the created instrument
     */
    Instrument createInstrument(Instrument instrument);

    /**
     * Retrieves an instrument by its id.
     *
     * @param id the id of the instrument to retrieve
     * @return the retrieved instrument or empty optional if it was not found
     */
    Optional<Instrument> retrieveInstrumentById(Long id);

    /**
     * Retrieves all the instruments in the catalog.
     *
     * @return the list of found instruments
     */
    List<Instrument> retrieveAllInstruments();

    /**
     * Updates an existing instrument.
     *
     * @param instrument the instrument to update
     * @return the updated instrument
     */
    Instrument updateInstrument(Instrument instrument);

    /**
     * Deletes an instrument by its id.
     *
     * @param id the id of the instrument to delete
     */
    void deleteInstrumentById(Long id);
}
