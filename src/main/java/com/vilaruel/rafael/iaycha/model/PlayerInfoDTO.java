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
    @Column(name = "ID")
	private long id;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLAYER_NAME", nullable = false, length = 50)	
	String playerName; 
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMAIL", nullable = false, length = 50)	
	String email;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PASSWORD", nullable = false, length = 50)	
	String password; 
	
	@Column(name = "PLAYER_HP")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int playerHP;
	
	@Column(name = "POSITION", length = 50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String position;
	
	@Column(name = "PLAYER_WEAPON", length = 50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String playerWeapon;
	
	@Column(name = "PLAYER_DAMAGE", length = 50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int playerDamage;
	
	@Column(name = "SPECIAL_POWER", length = 50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String specialPower;
	
	@Column(name = "BAG", length = 50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String bag;	
	
	@Column(name = "BAG_SLOTS")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bagSlots;	
	
	@Column(name = "MONSTER_HP")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int monsterHP;
	
	@Column(name = "MONSTER_NAME")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String monsterName;
	
	@Column(name = "MONSTER_DAMAGE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int monsterDamage;
	
	@Column(name = "PLAYER_POTIONS")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int playerPotions;
	
	@Column(name = "POWER_USE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int powerUse;
	
	@Column(name = "DRAGON_RING")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int dragonRing;
	
	   

}
