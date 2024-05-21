package nye.progkorny.instrumentcatalog.data.model;

import java.util.Objects;

/**
 * Model class for instruments.
 */
public class Instrument {

    private Long id;
    private String name;
    private String brand;
    private String model;
    private InstrumentType type;

    public Instrument() {
    }

    public Instrument(Long id, String name, String brand, String model, InstrumentType type) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public InstrumentType getType() {
        return type;
    }

    public void setType(InstrumentType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Instrument instrument = (Instrument) o;

        if (!Objects.equals(id, instrument.id)) {
            return false;
        }
        if (!Objects.equals(name, instrument.name)) {
            return false;
        }
        if (!Objects.equals(brand, instrument.brand)) {
            return false;
        }
        if (!Objects.equals(model, instrument.model)) {
            return false;
        }
        return type == instrument.type;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Instrument{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", type=" + type
                + '}';
    }
}
