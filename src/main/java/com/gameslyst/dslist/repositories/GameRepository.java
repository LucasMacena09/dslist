package com.gameslyst.dslist.repositories;

import com.gameslyst.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
