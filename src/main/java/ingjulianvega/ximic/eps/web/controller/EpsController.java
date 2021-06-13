package ingjulianvega.ximic.eps.web.controller;


import ingjulianvega.ximic.eps.services.EpsService;
import ingjulianvega.ximic.eps.web.model.Eps;
import ingjulianvega.ximic.eps.web.model.EpsDto;
import ingjulianvega.ximic.eps.web.model.EpsList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class EpsController implements EpsI {
    private final EpsService epsService;

    @Override
    public ResponseEntity<EpsList> get(Boolean usingCache) {
        return new ResponseEntity<>(epsService.get(usingCache), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EpsDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(epsService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid Eps eps) {
        epsService.create(eps);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid Eps eps) {
        epsService.updateById(id, eps);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        epsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}