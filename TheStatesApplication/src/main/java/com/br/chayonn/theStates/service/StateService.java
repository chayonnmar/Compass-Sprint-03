package com.br.chayonn.theStates.service;

import com.br.chayonn.theStates.controller.StateController;
import com.br.chayonn.theStates.models.entity.State;
import com.br.chayonn.theStates.models.entity.StateDto;
import com.br.chayonn.theStates.models.entity.regiao.Regiao;
import com.br.chayonn.theStates.models.entity.repository.StateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class StateService {

    private Logger log = LoggerFactory.getLogger(StateController.class);
    @Autowired
    StateRepository repository;

    public StateDto addState(StateDto state) {

        log.info("addState - INICIOU - Salvando o estado {}", state.getNome());
        State savedState = repository.save(new State(state));
        log.info("addState - FIM - Estado salvo com o id {}", savedState.getId());
        return new StateDto(savedState);
    }

    public Page<StateDto> getAllStates(Pageable filtros) {
//        List<State> stateEntityList = repository.findAll();
//        List<StateDto> stDto = new ArrayList<>();
//
//        for (State state: stateEntityList){
//            StateDto stateDto = new StateDto(state);
//            stDto.add(stateDto);
//        }
//        return stDto;
        log.info("getAllStates - INICIOU - Listando o estado");
//        return repository.findAll().stream().map(StateDto::new).collect(Collectors.toList());
        Page<State> state = repository.findAll(filtros);
        return state.map(StateDto::new);
    }

    public StateDto getStateById(Long id) {
        Optional<State> byId = repository.findById(id);
        return new StateDto(byId.get());
    }

    public StateDto updateStateById(Long id, StateDto state) {
        log.info("updateStateById - INICIOU - Editando o estado");
        State savedState = repository.save(new State(state));
        log.info("updateStateById - FIM - Estado editado com o id {}", savedState.getId());
        return new StateDto(savedState);
    }

    public void deleteStateById(Long stateId) {
        log.info("deleteStateById - INICIOU - Excluindo o estado");
        State state = getValidStateById(stateId);
        repository.delete(state);
        log.info("deleteStateById - FIM - Estado excluido com sucesso");
    }

    private State getValidStateById(long id) {
        Optional<State> optionalState = repository.findById(id);
        if (optionalState.isPresent()) {
            return optionalState.get();
        } else {
            log.warn("getValidStateById - AVISO - Estado com id: {} não existe na base de dados", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id informado não localizado");
        }
    }
}
