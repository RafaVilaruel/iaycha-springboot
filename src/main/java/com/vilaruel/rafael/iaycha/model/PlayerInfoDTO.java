package com.vilaruel.rafael.iaycha.model;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Component
@Table(name = "PLAYERINFO")
public class PlayerInfoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Long id;	
	
    @JoinColumn(name = "PlayerDecisions")
	@Column(name = "NAME", nullable = false, length = 50)
	String playerName; 
	
	int playerHP;	
	String position;
	String playerWeapon;
	String specialPower;
	String enemyName;
	String bag;	
	int monsterHP;
	int barbaroHP;
	int enemyHP;
	int playerPotions;	
	int bagSlots;
	int powerUse;
	int kingGoblinHP;
	int dragonRing;
	
	   

}
