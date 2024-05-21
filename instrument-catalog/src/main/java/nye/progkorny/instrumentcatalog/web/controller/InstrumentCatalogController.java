package nye.progkorny.instrumentcatalog.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nye.progkorny.instrumentcatalog.data.model.Instrument;
import nye.progkorny.instrumentcatalog.service.InstrumentService;

/**
 * Controller for the instrument catalog.
 */
@Controller
@RequestMapping("/instrument-catalog")
public class InstrumentCatalogController {

    private final InstrumentService instrumentService;

    @Autowired
    public InstrumentCatalogController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    /**
     * Shows the instrument editor screen.
     *
     * @param model the model object to store attributes
     * @param id the id of the instrument to retrieve
     * @return the name of the edit view to render
     */
    @GetMapping("/{id}")
    public String getInstrumentById(Model model, @PathVariable Long id) {
        Optional<Instrument> optionalInstrument = instrumentService.retrieveInstrumentById(id);
        return optionalInstrument.map(instrument -> {
            model.addAttribute("instrument", instrument);
            return "instrument-catalog/edit";
        }).orElseGet(() -> {
            model.addAttribute("requestUri", "instrument-catalog/" + id);
            return "instrument-catalog/notFound";
        });
    }

    /**
     * Shows the instrument list screen.
     *
     * @param model the model object to store attributes
     * @return the name of the instrument list view to render
     */
    @GetMapping
    public String getAllInstruments(Model model) {
        List<Instrument> allInstruments = instrumentService.retrieveAllInstruments();
        model.addAttribute("instruments", allInstruments);
        return "instrument-catalog/list";
    }

    /**
     * Shows the instrument creation screen.
     *
     * @return the name of the instrument creation view to render
     */
    @GetMapping("/create")
    public String createInstrument() {
        return "instrument-catalog/create";
    }

    /**
     * Creates a new instrument.
     * Also navigates back to the editor screen.
     *
     * @param model the model object to store attributes
     * @param instrument the instrument object to create
     * @return the name of the edit view to render
     */
    @PostMapping("/create")
    public String createInstrument(Model model, Instrument instrument) {
        Instrument newInstrument = instrumentService.createInstrument(instrument);
        model.addAttribute("instrument", newInstrument);
        return "instrument-catalog/edit";
    }

    /**
     * Updates an existing instrument.
     * Also navigates back to the editor screen.
     *
     * @param model the model object to store attributes
     * @param instrument the instrument object to update
     * @return the name of the edit view to render
     */
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateInstrument(Model model, Instrument instrument) {
        Instrument updatedInstrument = instrumentService.updateInstrument(instrument);
        model.addAttribute("instrument", updatedInstrument);
        return "instrument-catalog/edit";
    }

    /**
     * Deletes an instrument by ID.
     * Also navigates back to the instrument list screen.
     *
     * @param model the model object to store attributes
     * @param id the id of the instrument to delete
     * @return the name of the instrument list view to render
     */
    @GetMapping("/{id}/delete")
    public String deleteInstrumentById(Model model, @PathVariable Long id) {
        instrumentService.deleteInstrumentById(id);
        List<Instrument> allInstruments = instrumentService.retrieveAllInstruments();
        model.addAttribute("instruments", allInstruments);
        return "instrument-catalog/list";
    }
}
