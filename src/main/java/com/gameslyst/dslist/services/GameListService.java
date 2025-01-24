package com.gameslyst.dslist.services;

import com.gameslyst.dslist.dto.GameListDTO;
import com.gameslyst.dslist.dto.GameMinDTO;
import com.gameslyst.dslist.entities.Game;
import com.gameslyst.dslist.entities.GameList;
import com.gameslyst.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }
}
