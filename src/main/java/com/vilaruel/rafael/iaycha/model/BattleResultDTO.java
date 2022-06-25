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
public class BattleResultDTO implements Serializable {
	
	private long id;
	private int damageReceived;
	private int playerHP;
	private int damageMade;
	private int monsterHP;
	private boolean playerDead;
	private boolean monsterDead;
	
	
	   

}
