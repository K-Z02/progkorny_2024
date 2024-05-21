package nye.progkorny.instrumentcatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class to provide an entry point for the instrument catalog webservice.
 */
@SpringBootApplication
public class InstrumentCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstrumentCatalogApplication.class, args);
    }
}
