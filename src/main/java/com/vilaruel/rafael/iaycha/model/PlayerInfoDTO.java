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
@Table(name = "PLAYER_INFO")
public class PlayerInfoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private long id;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLAYER_NAME", nullable = false, length = 50)	
	String playerName; 
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMAIL", nullable = false, length = 50)	
	String Email;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PASSWORD", nullable = false, length = 50)	
	String Password; 
	
	@Column(name = "PLAYER_HP", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int playerHP;
	
	@Column(name = "POSITION", length = 50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String position;
	
	@Column(name = "PLAYER_WEAPON", nullable = false, length = 50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String playerWeapon;
	
	@Column(name = "SPECIAL_POWER", nullable = false, length = 50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String specialPower;
	
	@Column(name = "ENEMY_NAME", nullable = false, length = 50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String enemyName;
	
	@Column(name = "BAG", nullable = false, length = 50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String bag;	
	
	@Column(name = "BAG_SLOTS", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bagSlots;	
	
	@Column(name = "MONSTER_HP", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int monsterHP;
	
	@Column(name = "BARBARO_HP", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int barbaroHP;
	
	@Column(name = "ENEMY_HP", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int enemyHP;
	
	@Column(name = "PLAYER_POTIONS", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int playerPotions;
	
	@Column(name = "POWER_USE", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int powerUse;
	
	@Column(name = "KING_GOBLIN_HP", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int kingGoblinHP;
	
	@Column(name = "DRAGON_RING", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int dragonRing;
	
	   

}
