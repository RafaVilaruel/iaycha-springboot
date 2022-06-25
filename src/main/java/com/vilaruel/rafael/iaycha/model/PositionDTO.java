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
public class PositionDTO implements Serializable {
	
	private long id;	
	private String position;	
	   

}
