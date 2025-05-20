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
import lombok.ToString;

@Entity
@Table(name = "teams")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column
	private String name;
	
	@Column(name = "short_name")
	private String shortName;
	
	@Column(name = "abbreviation")
	private String abreviation;
	
	@Column(name = "sport_id")
	private Sport sportId;
			  
	@Column(name = "id_externo")
	private String idExterno;
	
	@Column
	private String propertie;
	
	@Lob
	@Column
	private byte[] crest;
	
	@Column(name = "flag_find")
	private boolean falgFind;

}
