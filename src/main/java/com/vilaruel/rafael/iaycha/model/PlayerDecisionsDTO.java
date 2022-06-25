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
    @Column(name = "ID")
	private long id;
	
	boolean choice;	
	boolean escape;	
	boolean goblinIsDead;
	boolean guardIsDead;
	boolean enteredCityAlready;
	boolean oldManFinished;
	boolean mageFinished;
	boolean badKidFinished;
	boolean isPlayerGuilty;
	boolean callHappened;
	boolean talkIaycha;
	boolean lightFire;
	boolean searchPotions;
	boolean hugIaycha;
	boolean enteredForest;
	boolean promiseIaycha;
	boolean goodByeIaycha;
	boolean iaychaIsDead;
	boolean iaychaDeclared;
	boolean miracle;
	boolean dS1, dS2, dS3;
	boolean lC1, lC2, lC3;
	boolean goblinKingIsDead;
	   

}
