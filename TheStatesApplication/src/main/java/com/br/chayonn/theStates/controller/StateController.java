package com.br.chayonn.theStates.controller;

import com.br.chayonn.theStates.models.entity.State;
import com.br.chayonn.theStates.models.entity.StateDto;
import com.br.chayonn.theStates.models.entity.regiao.Regiao;
import com.br.chayonn.theStates.service.StateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/apiStates")
public class StateController {

    private Logger log = LoggerFactory.getLogger(StateController.class);

    @Autowired
    private StateService service;


    @PostMapping("/states")
    public ResponseEntity<StateDto> createNewState(@RequestBody StateDto state) {

        log.info("CreateNewState - Início - chamando serviço");
        StateDto stateDto = service.addState(state);
        return ResponseEntity.status(201).body(stateDto);
    }


    @GetMapping("/states")
    public ResponseEntity<Page<StateDto>> getAllStates(@RequestParam(required = false) String regiao, Pageable filtros) {
//        if (regiao == null) {
            Page<StateDto> stateDto = service.getAllStates(filtros);
            return ResponseEntity.ok(stateDto);
//        } else {
//            String regioes = Regiao.valueOf(regiao.toUpperCase()).getRegiao();
//            Page<StateDto> states = service.getAllStates(filtros);
//            return ResponseEntity.ok(states);
//        }
    }

    @GetMapping("/states/{id}")
    public ResponseEntity<StateDto> findStateById (@PathVariable(value = "id") Long id){
        log.info("Início do método findStateById - chamando serviço");
        return ResponseEntity.ok(service.getStateById(id));
    }

    @PutMapping("/states/{id}")
    public ResponseEntity<StateDto> updateStateById (@PathVariable(value = "id") Long id,
    @RequestBody StateDto state){
        log.debug("Início do método updateStateById() - chamando serviço");
        return ResponseEntity.ok(service.updateStateById(id, state));
    }

    @DeleteMapping("/states/{id}")
    public ResponseEntity<Void> deleteStateById (@PathVariable(value = "id") Long id){
        log.debug("Início do método deleteStateById() - chamando serviço");
        service.deleteStateById(id);
        return ResponseEntity.noContent().build();
    }
}
