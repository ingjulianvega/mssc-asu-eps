package ingjulianvega.ximic.eps.services;



import ingjulianvega.ximic.eps.web.model.Eps;
import ingjulianvega.ximic.eps.web.model.EpsDto;
import ingjulianvega.ximic.eps.web.model.EpsList;

import java.util.UUID;

public interface EpsService {
    EpsList get(Boolean usingCache);

    EpsDto getById(UUID id);

    void create(Eps eps);

    void updateById(UUID id, Eps eps);

    void deleteById(UUID id);
}
