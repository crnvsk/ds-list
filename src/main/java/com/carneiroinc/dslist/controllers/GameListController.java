package com.carneiroinc.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carneiroinc.dslist.dto.GameListDTO;
import com.carneiroinc.dslist.dto.GameMinDTO;
import com.carneiroinc.dslist.services.GameListService;
import com.carneiroinc.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
			return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> searchByList(@PathVariable Long listId){
		List<GameMinDTO> result = gameService.searchByList(listId);
			return result;
	}
}
