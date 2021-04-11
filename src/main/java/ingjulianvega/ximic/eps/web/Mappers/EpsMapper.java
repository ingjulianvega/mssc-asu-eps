package ingjulianvega.ximic.eps.web.Mappers;


import ingjulianvega.ximic.eps.domain.EpsEntity;
import ingjulianvega.ximic.eps.web.model.EpsDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface EpsMapper {
    EpsDto epsEntityToEpsDto(EpsEntity epsEntity);

    EpsEntity epsDtoToEpsEntity(EpsDto epsDto);

    ArrayList<EpsDto> epsEntityListToEpsDtoList(List<EpsEntity> epsEntityList);
}
