package com.br.chayonn.theStates.models.entity.repository;

import com.br.chayonn.theStates.models.entity.State;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StateRepository extends JpaRepository<State,Long> {
//    Optional<State> findByRegion(String Regiao, Pageable filtro);
}
