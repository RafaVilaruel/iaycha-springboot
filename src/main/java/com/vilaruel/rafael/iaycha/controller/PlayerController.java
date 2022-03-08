package com.vilaruel.rafael.iaycha.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vilaruel.rafael.iaycha.model.PlayerInfoDTO;
import com.vilaruel.rafael.iaycha.model.StartPlayerDTO;
import com.vilaruel.rafael.iaycha.repository.PlayerDecisionsRepository;
import com.vilaruel.rafael.iaycha.repository.PlayerInfoRepository;
import com.vilaruel.rafael.iaycha.service.PlayerService;

@RestController
@RequestMapping(value = "/iaycha")
public class PlayerController {

	//Repositories
	@Autowired
	private PlayerDecisionsRepository playerDecisions;	
	
	@Autowired
	private PlayerInfoRepository playerInfo;	
	
	private PlayerService playerService;
	
	@GetMapping("/playerInfo")
	public List<PlayerInfoDTO> playerList(){
		return playerInfo.findAll();
	}
	
	@GetMapping("/player/{id}")
	public Optional<PlayerInfoDTO> playerSearch(@PathVariable (value="id") Long id){
		return playerInfo.findById(id);
	}
	
     @PostMapping("/player/create") 
     public ResponseEntity<PlayerInfoDTO> playerCreate(@RequestBody PlayerInfoDTO request){ 
    	 
    	 //StartPlayerDTO response = playerService.start(request); 
    	 
    	 playerInfo.save(request);    	 
    	 return ResponseEntity.ok().body(request);	  
	  
	  }
	 
	
}
