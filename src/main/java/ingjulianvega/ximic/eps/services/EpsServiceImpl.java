package ingjulianvega.ximic.eps.services;


import ingjulianvega.ximic.eps.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.eps.domain.EpsEntity;
import ingjulianvega.ximic.eps.domain.repositories.EpsRepository;
import ingjulianvega.ximic.eps.exception.EpsException;
import ingjulianvega.ximic.eps.web.Mappers.EpsMapper;
import ingjulianvega.ximic.eps.web.model.Eps;
import ingjulianvega.ximic.eps.web.model.EpsDto;
import ingjulianvega.ximic.eps.web.model.EpsList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class EpsServiceImpl implements EpsService {

    private final EpsRepository epsRepository;
    private final EpsMapper epsMapper;

    @Cacheable(cacheNames = "epsListCache", condition = "#usingCache == false")
    @Override
    public EpsList get(Boolean usingCache) {
        log.debug("get()...");
        return EpsList
                .builder()
                .epsDto(epsMapper.epsEntityListToEpsDtoList(epsRepository.findAllByOrderByName()))
                .build();
    }

    @Cacheable(cacheNames = "epsCache")
    @Override
    public EpsDto getById(UUID id) {
        log.debug("getById()...");
        return epsMapper.epsEntityToEpsDto(
                epsRepository.findById(id).orElseThrow(() -> EpsException
                        .builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .apiCode(ErrorCodeMessages.EPS_NOT_FOUND_API_CODE)
                        .error(ErrorCodeMessages.EPS_NOT_FOUND_ERROR)
                        .message(ErrorCodeMessages.EPS_NOT_FOUND_MESSAGE)
                        .solution(ErrorCodeMessages.EPS_NOT_FOUND_SOLUTION)
                        .build()));
    }

    @Override
    public void create(Eps eps) {
        log.debug("create()...");
        epsMapper.epsEntityToEpsDto(
                epsRepository.save(
                        epsMapper.epsDtoToEpsEntity(
                                EpsDto
                                        .builder()
                                        .name(eps.getName()).
                                        build())));
    }

    @Override
    public void updateById(UUID id, Eps eps) {
        log.debug("updateById...");
        EpsEntity epsEntity = epsRepository.findById(id).orElseThrow(() -> EpsException
                .builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .apiCode(ErrorCodeMessages.EPS_NOT_FOUND_API_CODE)
                .error(ErrorCodeMessages.EPS_NOT_FOUND_ERROR)
                .message(ErrorCodeMessages.EPS_NOT_FOUND_MESSAGE)
                .solution(ErrorCodeMessages.EPS_NOT_FOUND_SOLUTION)
                .build());
        epsEntity.setName(eps.getName());

        epsRepository.save(epsEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        epsRepository.deleteById(id);
    }
}
