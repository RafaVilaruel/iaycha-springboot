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
public class StartPlayerDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String playerName;	
	private String email;		
	private String password; 		   

}
