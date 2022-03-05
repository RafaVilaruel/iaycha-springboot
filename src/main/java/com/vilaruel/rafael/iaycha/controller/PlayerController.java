package com.vilaruel.rafael.iaycha.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vilaruel.rafael.iaycha.model.PlayerInfoDTO;
import com.vilaruel.rafael.iaycha.repository.PlayerDecisionsRepository;
import com.vilaruel.rafael.iaycha.repository.PlayerInfoRepository;

@RestController
@RequestMapping(value = "/iaycha")
public class PlayerController {

	//Repositories
	@Autowired
	PlayerDecisionsRepository playerDecisions;	
	
	@Autowired
	PlayerInfoRepository playerInfo;	
	
	@GetMapping("/playerInfo")
	public List<PlayerInfoDTO> playerList(){
		return playerInfo.findAll();
	}
	
	@GetMapping("/player/{id}")
	public Optional<PlayerInfoDTO> playerSearch(@PathVariable (value="id") Long id){
		return playerInfo.findById(id);
	}
	
	@PostMapping("/player/create")
	public PlayerInfoDTO playerCreate(@RequestBody PlayerInfoDTO request){
		return playerInfo.save(request);
	}
}
