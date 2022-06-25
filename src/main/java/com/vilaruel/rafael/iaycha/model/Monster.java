package com.vilaruel.rafael.iaycha.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vilaruel.rafael.iaycha.repository.PlayerDecisionsRepository;
import com.vilaruel.rafael.iaycha.repository.PlayerInfoRepository;
import com.vilaruel.rafael.iaycha.service.PlayerService;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Monster implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String monsterName;	
	private int monsterHP;
	private int monsterDamage;
	
		   

}
