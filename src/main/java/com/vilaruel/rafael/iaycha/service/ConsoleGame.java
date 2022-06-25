package com.vilaruel.rafael.iaycha.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vilaruel.rafael.iaycha.model.BattleResultDTO;
import com.vilaruel.rafael.iaycha.model.Player;
import com.vilaruel.rafael.iaycha.model.StartPlayerDTO;
import com.vilaruel.rafael.iaycha.repository.PlayerDecisionsRepository;
import com.vilaruel.rafael.iaycha.repository.PlayerInfoRepository;

@Service
public class ConsoleGame {
	
	private final PlayerDecisionsRepository playerDecisions;	
	private final PlayerInfoRepository playerInfo;	
	private final PlayerService playerService;
	private final BattleService battleService;
	private final PositionService positionService;
	
	@Autowired
	public ConsoleGame(PlayerService playerService, PlayerInfoRepository playerInfo, PlayerDecisionsRepository playerDecisions, BattleService battleService, PositionService positionService) {
		this.playerDecisions = playerDecisions;
		this.playerInfo = playerInfo;
		this.playerService = playerService;
		this.battleService = battleService;
		this.positionService = positionService;
	}
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public Player startGame() {		
		
		 System.out.print("Enter your name: ");		 
		 
		 String userName = null;
		 String email = null;
		 String password = null;

	      //  read the username from the command-line; need to use try/catch with the
	      //  readLine() method
	      try {
	         userName = br.readLine();
	      } catch (IOException ioe) {
	         System.out.println("IO error trying to read your name!");
	         System.exit(1);    }      

		      //  read the username from the command-line; need to use try/catch with the
		      //  readLine() method
		  System.out.println("Enter your Email");    
	      try {
		         email = br.readLine();
		      } catch (IOException ioe) {
		         System.out.println("IO error trying to read your name!");
		         System.exit(1);
		      }
	      System.out.println("Enter your Password");    
	      try {
		         password = br.readLine();
		      } catch (IOException ioe) {
		         System.out.println("IO error trying to read your name!");
		         System.exit(1);
		      }
	      
	      StartPlayerDTO player = new StartPlayerDTO();
	      player.setPlayerName(userName);
	      player.setEmail(email);
	      player.setPassword(password);
	      
	      Player playerCreated = playerService.start(player);
	      
	      return playerCreated;
	      
	}
	
	public void townGate(Player player) {
		
		System.out.println("Você está no portão da cidade, o que deseja fazer?");
		System.out.println("1- Falar com o guarda");
		System.out.println("2- Entrar na cidade");
		System.out.println("3- Ir embora");
		System.out.println("4- Batalhar com o Guarda");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
		
	public void fightGuard(long id) {		
		
		Player player = playerService.loadPlayer(id);
		
		System.out.println("You are fighting the "+player.getInfo().getMonsterName());
		System.out.println("Your HP: "+player.getInfo().getPlayerHP());
		System.out.println(player.getInfo().getMonsterName()+"HP: "+player.getInfo().getMonsterHP());
		
		if (player.getInfo().getPlayerHP() <= 0) {
			System.out.println("You died bitch");
			System.exit(1);
		}
		else if (player.getInfo().getMonsterHP() <= 0) {
			System.out.println("The monster died!!");
			System.exit(1);
			
		}		
		
		System.out.println("Press 1 to attack or 2 to use a Potion");
		
		String option = null;
		
		 try {
	         option = br.readLine();
	      } catch (IOException ioe) {
	         System.out.println("IO error");
	         System.exit(1);    
	         }		 
		 
		if (player.getInfo().getPlayerHP() > 0 && option.equals("1")) {
			battleService.attack(player.getDecisions().getId());
			fightGuard(player.getInfo().getId());
		}
		else if (player.getInfo().getPlayerHP() > 0 && option.equals("2")) {
			battleService.usePotion(player.getInfo().getId());
			fightGuard(player.getInfo().getId());
		}
		
			
		
	}

	public void goForest(Player player) {
		System.out.println("You went back to the forest and found a Goblin");
		
		
	}

	public void enterCity(Player player) {
		System.out.println("Hey fuck you Loser! You're not entering my City, Lets fight!");

		
	}

	public void talkGuard(Player player) {
		System.out.println("Hey fuck you Loser! Lets fight!");
		
	}
		

}
