package nye.progkorny.instrumentcatalog.data.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import nye.progkorny.instrumentcatalog.data.model.Instrument;
import nye.progkorny.instrumentcatalog.data.repository.Repository;

/**
 * Map-based in-memory implementation of {@link Repository}.
 */
@org.springframework.stereotype.Repository
public class InMemoryInstrumentRepository implements Repository<Instrument, Long> {

    private static final Map<Long, Instrument> STORAGE = new HashMap<>();

    @Override
    public Instrument save(Instrument instrument) {
        Long id = STORAGE.size() + 1L;
        instrument.setId(id);
        STORAGE.put(id, instrument);
        return STORAGE.get(id);
    }

    @Override
    public Optional<Instrument> getById(Long id) {
        return Optional.ofNullable(STORAGE.get(id));
    }

    @Override
    public List<Instrument> getAll() {
        return STORAGE.values().stream().toList();
    }

    @Override
    public Instrument update(Instrument instrument) {
        Long id = instrument.getId();
        STORAGE.put(id, instrument);
        return STORAGE.get(id);
    }

    @Override
    public void deleteById(Long id) {
        STORAGE.remove(id);
    }
}
