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
public class ConsoleGameController {

	//Repositories
	
	private final PlayerDecisionsRepository playerDecisions;	
	private final PlayerInfoRepository playerInfo;	
	private final PlayerService playerService;
	private final PositionService positionService;
	private final BattleService battleService;
	private final ConsoleGame consoleGame;
	
	@Autowired
	public ConsoleGameController(PlayerService playerService, PlayerInfoRepository playerInfo, PlayerDecisionsRepository playerDecisions, PositionService positionService, BattleService battleService, ConsoleGame consoleGame) {
		this.playerDecisions = playerDecisions;
		this.playerInfo = playerInfo;
		this.playerService = playerService;
		this.positionService = positionService;
		this.battleService = battleService;
		this.consoleGame = consoleGame;	
	}
	
	@GetMapping("/start") 
    public Player battleMonster(){
		 
		 Player player = consoleGame.startGame(); 
		 consoleGame.townGate(player);
		 player.getInfo().setMonsterName("Guarda");
		 player.getInfo().setPlayerWeapon("Excalibur");
		 playerService.savePlayer(player);
		 battleService.setupBattle(player.getInfo().getId(),
		 player.getInfo().getMonsterName());
		 consoleGame.fightGuard(player.getInfo().getId());
		
		 return player;  
	  
	  }
	
	
	 
	
}
