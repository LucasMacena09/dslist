package com.gameslyst.dslist.services;

import com.gameslyst.dslist.dto.GameDTO;
import com.gameslyst.dslist.dto.GameMinDTO;
import com.gameslyst.dslist.entities.Game;
import com.gameslyst.dslist.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("The 'id' must not be null");
        }

        return gameRepository.findById(id)
                .map(GameDTO::new)
                .orElseThrow(() -> new EntityNotFoundException("Game not found with id: " + id));
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }
}
