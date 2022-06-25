package com.vilaruel.rafael.iaycha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vilaruel.rafael.iaycha.model.BattleResultDTO;
import com.vilaruel.rafael.iaycha.model.Monster;
import com.vilaruel.rafael.iaycha.model.Player;
import com.vilaruel.rafael.iaycha.repository.PlayerDecisionsRepository;
import com.vilaruel.rafael.iaycha.repository.PlayerInfoRepository;

@Service
public class BattleService {
	
	private final PlayerDecisionsRepository playerDecisions;	
	private final PlayerInfoRepository playerInfo;	
	private final PlayerService playerService;
	
	@Autowired
	public BattleService(PlayerService playerService, PlayerInfoRepository playerInfo, PlayerDecisionsRepository playerDecisions) {
		this.playerDecisions = playerDecisions;
		this.playerInfo = playerInfo;
		this.playerService = playerService;
	}
	
		
	public BattleResultDTO attack(long id) {
		Player player = playerService.loadPlayer(id);
		var playerDamage = new java.util.Random().nextInt(player.getInfo().getPlayerDamage());
		var monsterDamage = new java.util.Random().nextInt(player.getInfo().getMonsterDamage());
		var playerHP = player.getInfo().getPlayerHP();
		var monsterHP = player.getInfo().getMonsterHP();
		
		player.getInfo().setMonsterHP(monsterHP -= playerDamage);
		player.getInfo().setPlayerHP(playerHP -= monsterDamage);
		
		if (player.getInfo().getPlayerHP() <= 0) {
			player.getInfo().setMonsterHP(0);
		}
		if (player.getInfo().getMonsterHP() <= 0) {
			player.getInfo().setMonsterHP(0);
		}
		playerService.savePlayer(player);
		
		BattleResultDTO battleResult = new BattleResultDTO();
		battleResult.setDamageMade(playerDamage);
		battleResult.setDamageReceived(monsterDamage);
		battleResult.setMonsterHP(monsterHP);
		battleResult.setPlayerHP(playerHP);
		battleResult.setId(id);
		
		if (playerHP <= 0) {
			battleResult.setPlayerDead(true);
		}
		else if (monsterHP <=0) {
			battleResult.setMonsterDead(true);
		}
		return battleResult;

		
	}
	
	//***********SETUP BATTLE***********	
	public Player setupBattle(long id, String monsterName) {
		
		Player player = playerService.loadPlayer(id);
		Monster monster = setupMonster(monsterName);
		Player weaponSetup = setupWeapon(player.getInfo().getPlayerWeapon(), player.getInfo().getId());
		
		player.getInfo().setPlayerWeapon(weaponSetup.getInfo().getPlayerWeapon());
		player.getInfo().setPlayerDamage(weaponSetup.getInfo().getPlayerDamage());
		player.getInfo().setMonsterName(monster.getMonsterName());
		player.getInfo().setMonsterHP(monster.getMonsterHP());
		player.getInfo().setMonsterDamage(monster.getMonsterDamage());
		player.getInfo().setPosition("BattlingMonster");
		
		playerService.savePlayer(player);
		return player;	
		
	}
	
	
	//***********SETUP MONSTER***********	
	public Monster setupMonster(String monsterName) {
		
		Monster monster = new Monster();
		
		switch(monsterName) {
		  
		case "Goblin":		   
		   monster.setMonsterName("Goblin");
		   monster.setMonsterHP(20);
		   monster.setMonsterDamage(3);
		    break;
		    
		  case "MediumGoblin":
			 monster.setMonsterName("Medium Goblin");
			 monster.setMonsterHP(25);
			 monster.setMonsterDamage(5);
		    break;
		    
		  case "ArmouredGoblin":
				 monster.setMonsterName("Armoured Goblin");
				 monster.setMonsterHP(35);
				 monster.setMonsterDamage(7);
			    break;
			    
		  case "KingGoblin":
				 monster.setMonsterName("King Goblin");
				 monster.setMonsterHP(300);
				 monster.setMonsterDamage(4);
			    break;
			    
		  default:	   
			   monster.setMonsterName("Goblin");
			   monster.setMonsterHP(20);
			   monster.setMonsterDamage(3);
		}
		return monster;
	}
	
	//***********SETUP PLAYERWEAPON***********	
		
		public Player setupWeapon(String weaponName, long id) {
			
			Player player = playerService.loadPlayer(id);
			
			switch(weaponName) {
			  
			case "Punhos":		   
			  player.getInfo().setPlayerWeapon("Punhos");
			  player.getInfo().setPlayerDamage(2);
			    break;
			    
			case "Espada de Madeira":		   
				  player.getInfo().setPlayerWeapon("Espada de Madeira");
				  player.getInfo().setPlayerDamage(3);
				    break;
			    
			case "Excalibur":		   
				  player.getInfo().setPlayerWeapon("Excalibur");
				  player.getInfo().setPlayerDamage(7);
				    break;
				    
			  default:	   
				  player.getInfo().setPlayerWeapon("Punhos");
				  player.getInfo().setPlayerDamage(1);
				    break;
			}
			playerService.savePlayer(player);
			return player;
		}
		
		public void usePotion(long id) {
			Player player = playerService.loadPlayer(id);
			if (player.getInfo().getPlayerPotions() <=0) {
				System.out.println("You don't have any Potions!");
				
			}
			else {
				player.getInfo().setPlayerPotions(player.getInfo().getPlayerPotions() - 1);
				player.getInfo().setPlayerHP(player.getInfo().getPlayerHP() + 3);
				playerService.savePlayer(player);	
			}
			
			
		}
		
		public void usePower(long id) {
			Player player = playerService.loadPlayer(id);
			
			if (player.getInfo().getSpecialPower() == null) {
				player.getInfo().setSpecialPower("");
			}

			switch(player.getInfo().getSpecialPower()) {
			  
			case "Tubo de Luz":		   
			  if (player.getInfo().getPowerUse() >= 1) {
				  player.getInfo().setPlayerHP(player.getInfo().getPlayerHP()+50);
			  }
			    break;			    
			    
			case "Raio Azul":		   
				if (player.getInfo().getPowerUse() >= 1) {
					  player.getInfo().setPlayerDamage(player.getInfo().getPlayerDamage()+2);;
				  }
				 break;
				 
			case "Raio Verde":		   
				if (player.getInfo().getPowerUse() >= 1) {
					  player.getInfo().setPlayerHP(player.getInfo().getPlayerHP()+10);
				  }
				 break;	 
				    
			  default:
				  System.out.println("Player does not have any powers");
			}
			
			playerService.savePlayer(player);
		}
	
	
}
