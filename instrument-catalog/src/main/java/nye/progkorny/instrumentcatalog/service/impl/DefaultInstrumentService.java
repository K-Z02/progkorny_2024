package nye.progkorny.instrumentcatalog.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nye.progkorny.instrumentcatalog.data.model.Instrument;
import nye.progkorny.instrumentcatalog.data.repository.Repository;
import nye.progkorny.instrumentcatalog.service.InstrumentService;

/**
 * Default implementation of {@link InstrumentService}.
 */
@Service
public class DefaultInstrumentService implements InstrumentService {

    private final Repository<Instrument, Long> instrumentRepository;

    @Autowired
    public DefaultInstrumentService(Repository<Instrument, Long> instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    @Override
    public Instrument createInstrument(Instrument instrument) {
        return instrumentRepository.save(instrument);
    }

    @Override
    public Optional<Instrument> retrieveInstrumentById(Long id) {
        return instrumentRepository.getById(id);
    }

    @Override
    public List<Instrument> retrieveAllInstruments() {
        return instrumentRepository.getAll();
    }

    @Override
    public Instrument updateInstrument(Instrument instrument) {
        return instrumentRepository.update(instrument);
    }

    @Override
    public void deleteInstrumentById(Long id) {
        instrumentRepository.deleteById(id);
    }
}
