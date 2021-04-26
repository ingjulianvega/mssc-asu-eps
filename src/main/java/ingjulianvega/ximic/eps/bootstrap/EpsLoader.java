package ingjulianvega.ximic.eps.bootstrap;


import ingjulianvega.ximic.eps.domain.EpsEntity;
import ingjulianvega.ximic.eps.domain.repositories.EpsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class EpsLoader implements CommandLineRunner {

    private final EpsRepository epsRepository;

    @Override
    public void run(String... args) throws Exception {
        if (epsRepository.count() == 0) {
            loadEpsObjects();
        }
    }

    private void loadEpsObjects() {
        epsRepository.saveAll(Arrays.asList(
                EpsEntity.builder().name("SURA").build(),
                EpsEntity.builder().name("SANITAS").build(),
                EpsEntity.builder().name("COMPENSAR").build(),
                EpsEntity.builder().name("COOSALUD").build(),
                EpsEntity.builder().name("NUEVA EPS").build(),
                EpsEntity.builder().name("SALUD TOTAL").build(),
                EpsEntity.builder().name("FAMISANAR").build(),
                EpsEntity.builder().name("CAPITAL SALUD").build(),
                EpsEntity.builder().name("CONVIDA").build(),
                EpsEntity.builder().name("MEDIMAS S").build(),
                EpsEntity.builder().name("SALUDVIDA").build(),
                EpsEntity.builder().name("COOMEVA").build(),
                EpsEntity.builder().name("CRUZ BLANCA").build(),
                EpsEntity.builder().name("NINGUNA").build(),
                EpsEntity.builder().name("MEDIMAS").build()
        ));
    }
}
