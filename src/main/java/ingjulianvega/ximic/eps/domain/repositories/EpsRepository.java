package ingjulianvega.ximic.eps.domain.repositories;


import ingjulianvega.ximic.eps.domain.EpsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface EpsRepository extends JpaRepository<EpsEntity, UUID>, JpaSpecificationExecutor<EpsEntity> {
    List<EpsEntity> findAllByOrderByName();
}
