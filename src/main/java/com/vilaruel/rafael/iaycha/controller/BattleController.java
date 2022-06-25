package com.vilaruel.rafael.iaycha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vilaruel.rafael.iaycha.model.*;
import com.vilaruel.rafael.iaycha.repository.*;
import com.vilaruel.rafael.iaycha.service.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/iaycha")
public class BattleController {

	//Repositories
	
	private final PlayerDecisionsRepository playerDecisions;	
	private final PlayerInfoRepository playerInfo;	
	private final PlayerService playerService;
	private final PositionService positionService;
	private final BattleService battleService;
	//testing commit
	@Autowired
	public BattleController(PlayerService playerService, PlayerInfoRepository playerInfo, PlayerDecisionsRepository playerDecisions, PositionService positionService, BattleService battleService) {
		this.playerDecisions = playerDecisions;
		this.playerInfo = playerInfo;
		this.playerService = playerService;
		this.positionService = positionService;
		this.battleService = battleService;	
	}
	
	@PostMapping("/battle") 
    public BattleResultDTO battleMonster(@RequestBody StartBattleDTO request){
		Player player = playerService.loadPlayer(request.getId());
		
		battleService.setupBattle(player.getInfo().getId(), request.getMonsterName());
		BattleResultDTO battleResult =  battleService.attack(player.getInfo().getId());
		
		return battleResult;   	   
	  
	  }
	
	@GetMapping("/usepotion/{id}") 
    public Player usePotion(@PathVariable (value="id") Long id){
		
		Player player = playerService.loadPlayer(id);		
		battleService.usePotion(player.getInfo().getId());
		
		return player;   	   
	  
	  }
	
	@GetMapping("/usepower/{id}") 
    public Player usePower(@PathVariable (value="id") Long id){
		
		Player player = playerService.loadPlayer(id);		
		battleService.usePower(player.getInfo().getId());
		
		return player;   	   
	  
	  }
	
	
	
	 
	
}
