package com.vilaruel.rafael.iaycha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vilaruel.rafael.iaycha.model.Player;
import com.vilaruel.rafael.iaycha.repository.PlayerDecisionsRepository;
import com.vilaruel.rafael.iaycha.repository.PlayerInfoRepository;

@Service
public class PositionService {
	
	private final PlayerDecisionsRepository playerDecisions;	
	private final PlayerInfoRepository playerInfo;	
	private final PlayerService playerService;
	
	@Autowired
	public PositionService(PlayerService playerService, PlayerInfoRepository playerInfo, PlayerDecisionsRepository playerDecisions) {
		this.playerDecisions = playerDecisions;
		this.playerInfo = playerInfo;
		this.playerService = playerService;
	}
	
	public String loadPosition(long id) {
		Player player = playerService.loadPlayer(id);
		return player.getInfo().getPosition();
	}
	
	public void changePosition(String position, long id) {
		Player player = playerService.loadPlayer(id);
		player.getInfo().setPosition(position);
		playerService.savePlayer(player);
		
	}

}
