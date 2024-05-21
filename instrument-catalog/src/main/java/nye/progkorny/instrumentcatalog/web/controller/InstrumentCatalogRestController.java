package nye.progkorny.instrumentcatalog.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nye.progkorny.instrumentcatalog.data.model.Instrument;
import nye.progkorny.instrumentcatalog.service.InstrumentService;

/**
 * A REST controller for managing instruments in the instrument catalog.
 */
@RestController
@RequestMapping("/api/v1/instrument")
public class InstrumentCatalogRestController {

    private final InstrumentService instrumentService;

    @Autowired
    public InstrumentCatalogRestController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    /**
     * Returns an instrument with the given id.
     *
     * @param id the id of the instrument to retrieve
     * @return the instrument object
     */
    @GetMapping("/{id}")
    public ResponseEntity<Instrument> getInstrumentById(@PathVariable Long id) {
        Optional<Instrument> instrument = instrumentService.retrieveInstrumentById(id);
        return instrument.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Returns a list of all the instruments in the catalog.
     *
     * @return the list of instruments
     */
    @GetMapping
    public List<Instrument> getAllInstruments() {
        return instrumentService.retrieveAllInstruments();
    }

    /**
     * Creates a new instrument and returns it.
     *
     * @param instrument the instrument object to create
     * @return the created instrument object
     */
    @PostMapping
    public Instrument createInstrument(@RequestBody Instrument instrument) {
        return instrumentService.createInstrument(instrument);
    }

    /**
     * Updates an existing instrument and returns it.
     *
     * @param instrument the instrument object to update
     * @return the updated instrument object
     */
    @PutMapping
    public Instrument updateInstrument(@RequestBody Instrument instrument) {
        return instrumentService.updateInstrument(instrument);
    }

    /**
     * Deletes an instrument by its id.
     *
     * @param id the id of the instrument to delete
     */
    @DeleteMapping("/{id}")
    public void deleteInstrumentById(@PathVariable Long id) {
        instrumentService.deleteInstrumentById(id);
    }
}
