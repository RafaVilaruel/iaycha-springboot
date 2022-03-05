package com.vilaruel.rafael.iaycha.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Component
@Table(name = "PLAYERDECISIONS")
public class PlayerDecisionsDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private long id;
	
	boolean choice;	
	boolean escape;	
	boolean goblinIsDead = false;
	boolean guardIsDead = false;
	boolean enteredCityAlready = false;
	boolean oldManFinished = false;
	boolean mageFinished = false;
	boolean badKidFinished = false;
	boolean isPlayerGuilty = false;
	boolean callHappened = false;
	boolean talkIaycha = false;
	boolean lightFire = false;
	boolean searchPotions = false;
	boolean hugIaycha = false;
	boolean enteredForest = false;
	boolean promiseIaycha = false;
	boolean goodByeIaycha = false;
	boolean iaychaIsDead = false;
	boolean iaychaDeclared = false;
	boolean miracle = false;
	boolean dS1, dS2, dS3 = false;
	boolean lC1, lC2, lC3 = false;
	boolean goblinKingIsDead = false;
	   

}
