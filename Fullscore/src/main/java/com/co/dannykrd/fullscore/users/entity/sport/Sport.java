package com.co.dannykrd.fullscore.users.entity.sport;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sports")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sport {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column
	private String name;
	
	@Column
	private String abbreviation;
    
	@Lob
	@Column
	private byte[] logo;
	  
	@Column(name = "id_externo")
	private String idExterno;
	
	@Column
	private String propertie;

}
