package com.carneiroinc.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carneiroinc.dslist.dto.GameDTO;
import com.carneiroinc.dslist.dto.GameMinDTO;
import com.carneiroinc.dslist.entities.Game;
import com.carneiroinc.dslist.projections.GameMinProjection;
import com.carneiroinc.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result  = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
			return dto;
	}
	
	@Transactional(readOnly = true)
	public GameDTO findGameById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
			return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> searchByList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
			return dto;
	}
}
