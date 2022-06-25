package com.vilaruel.rafael.iaycha.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vilaruel.rafael.iaycha.model.Player;
import com.vilaruel.rafael.iaycha.model.PlayerDecisionsDTO;
import com.vilaruel.rafael.iaycha.model.PlayerInfoDTO;
import com.vilaruel.rafael.iaycha.model.StartPlayerDTO;
import com.vilaruel.rafael.iaycha.repository.PlayerDecisionsRepository;
import com.vilaruel.rafael.iaycha.repository.PlayerInfoRepository;

@Service
public class PlayerService {
	
	private final PlayerDecisionsRepository playerDecisions;	
	private final PlayerInfoRepository playerInfo;
	
	@Autowired
	public PlayerService(PlayerInfoRepository playerInfo, PlayerDecisionsRepository playerDecisions) {
		this.playerDecisions = playerDecisions;
		this.playerInfo = playerInfo;		
	}
	
	public Player start(StartPlayerDTO request) { 
	
		Player player = new Player();
		PlayerInfoDTO newPlayer = new PlayerInfoDTO();
		PlayerDecisionsDTO choicesStart = new PlayerDecisionsDTO();
		
		//Request
		newPlayer.setPlayerName(request.getPlayerName());
		newPlayer.setEmail(request.getEmail());
		newPlayer.setPassword(request.getPassword());
		
		//Starting all variables at the game
		var startedPlayer = startVariable(newPlayer);
		
		//Start all choices at the game
		var choicesPlayer = startChoices(choicesStart);
		choicesPlayer.setId(startedPlayer.getId());
		
		player.setDecisions(choicesPlayer);
		player.setInfo(startedPlayer);
		
		savePlayer(player);
		
		return player;	
		
		
	}
	
	private PlayerDecisionsDTO startChoices(PlayerDecisionsDTO choices) {		
		return choices;
	}

	public PlayerInfoDTO startVariable(PlayerInfoDTO startedPlayer) {
		
		startedPlayer.setPlayerHP(20);
		startedPlayer.setPosition("playerSetUp");
		startedPlayer.setPlayerWeapon("Punhos");
		startedPlayer.setPlayerDamage(2);
		startedPlayer.setSpecialPower(null);
		startedPlayer.setBag("Bolso");
		startedPlayer.setMonsterHP(30);	
		startedPlayer.setMonsterName(null);
		startedPlayer.setPlayerPotions(0);
		startedPlayer.setBagSlots(4);
		startedPlayer.setPowerUse(0);		
		startedPlayer.setDragonRing(0);		
		startedPlayer.setMonsterDamage(0);			
		startedPlayer.setId((new Random().nextInt(56753 - 12123 + 145) + 10000));
		
		return startedPlayer;
	}

	public PlayerInfoDTO populateInfo(Optional<PlayerInfoDTO> info, PlayerInfoDTO newPlayer) {
		
		newPlayer.setBag(info.get().getBag());
		newPlayer.setBagSlots(info.get().getBagSlots());
		newPlayer.setMonsterName(info.get().getMonsterName());
		newPlayer.setDragonRing(info.get().getDragonRing());
		newPlayer.setEmail(info.get().getEmail());
		newPlayer.setMonsterDamage(info.get().getMonsterDamage());
		newPlayer.setId(info.get().getId());
		newPlayer.setMonsterHP(info.get().getMonsterHP());
		newPlayer.setPassword(info.get().getPassword());
		newPlayer.setPlayerHP(info.get().getPlayerHP());
		newPlayer.setPlayerName(info.get().getPlayerName());
		newPlayer.setPlayerPotions(info.get().getPlayerPotions());
		newPlayer.setPlayerWeapon(info.get().getPlayerWeapon());
		newPlayer.setPlayerDamage(info.get().getPlayerDamage());
		newPlayer.setPosition(info.get().getPosition());
		newPlayer.setPowerUse(info.get().getPowerUse());
		newPlayer.setSpecialPower(info.get().getSpecialPower());
		
		return newPlayer;
		
	}

	public PlayerDecisionsDTO populateDecisions(Optional<PlayerDecisionsDTO> decisions, PlayerDecisionsDTO newPlayer) {
		
		newPlayer.setBadKidFinished(decisions.get().isBadKidFinished());
		newPlayer.setCallHappened(decisions.get().isCallHappened());
		newPlayer.setChoice(decisions.get().isChoice());
		newPlayer.setDS1(decisions.get().isDS1());
		newPlayer.setDS2(decisions.get().isDS2());
		newPlayer.setDS3(decisions.get().isDS3());
		newPlayer.setEnteredCityAlready(decisions.get().isEnteredCityAlready());
		newPlayer.setEnteredForest(decisions.get().isEnteredForest());
		newPlayer.setEscape(decisions.get().isEscape());
		newPlayer.setGoblinIsDead(decisions.get().isGoblinIsDead());
		newPlayer.setGoblinKingIsDead(decisions.get().isGoblinKingIsDead());
		newPlayer.setGoodByeIaycha(decisions.get().isGoodByeIaycha());
		newPlayer.setGuardIsDead(decisions.get().isGuardIsDead());
		newPlayer.setHugIaycha(decisions.get().isHugIaycha());
		newPlayer.setIaychaDeclared(decisions.get().isIaychaDeclared());
		newPlayer.setIaychaIsDead(decisions.get().isIaychaIsDead());
		newPlayer.setId(decisions.get().getId());
		newPlayer.setLC1(decisions.get().isLC1());
		newPlayer.setLC2(decisions.get().isLC2());
		newPlayer.setLC3(decisions.get().isLC3());
		newPlayer.setLightFire(decisions.get().isLightFire());
		newPlayer.setMageFinished(decisions.get().isMageFinished());
		newPlayer.setMiracle(decisions.get().isMiracle());
		newPlayer.setOldManFinished(decisions.get().isOldManFinished());
		newPlayer.setPlayerGuilty(decisions.get().isPlayerGuilty());
		newPlayer.setPromiseIaycha(decisions.get().isPromiseIaycha());
		newPlayer.setSearchPotions(decisions.get().isSearchPotions());
		newPlayer.setTalkIaycha(decisions.get().isTalkIaycha());	
		
		return newPlayer;
	}
	
	public Player loadPlayer(long id) {
		
		var info = playerInfo.findById(id);
		var decisions = playerDecisions.findById(id);
		PlayerInfoDTO newInfo = new PlayerInfoDTO();
		PlayerDecisionsDTO newDecisions = new PlayerDecisionsDTO();
		
		PlayerInfoDTO playerInfo = populateInfo(info, newInfo);
		PlayerDecisionsDTO playerDecisions = populateDecisions(decisions, newDecisions);
		
		Player player = new Player();
		player.setInfo(playerInfo);
		player.setDecisions(playerDecisions);
		
		return player;
		
	}

	private PlayerInfoDTO populateInfo(PlayerInfoDTO info, PlayerInfoDTO newPlayer) {
		newPlayer.setBag(info.getBag());
		newPlayer.setBagSlots(info.getBagSlots());
		newPlayer.setMonsterName(info.getMonsterName());
		newPlayer.setDragonRing(info.getDragonRing());
		newPlayer.setEmail(info.getEmail());
		newPlayer.setId(info.getId());
		newPlayer.setMonsterHP(info.getMonsterHP());
		newPlayer.setPassword(info.getPassword());
		newPlayer.setPlayerHP(info.getPlayerHP());
		newPlayer.setPlayerDamage(info.getPlayerDamage());
		newPlayer.setMonsterDamage(info.getMonsterDamage());
		newPlayer.setPlayerName(info.getPlayerName());
		newPlayer.setPlayerPotions(info.getPlayerPotions());
		newPlayer.setPlayerWeapon(info.getPlayerWeapon());
		newPlayer.setPosition(info.getPosition());
		newPlayer.setPowerUse(info.getPowerUse());
		newPlayer.setSpecialPower(info.getSpecialPower());
		
		return newPlayer;
	}
	
	public void savePlayer(Player player) {
		playerInfo.save(player.getInfo());
   	 	playerDecisions.save(player.getDecisions());		
	}	


}
