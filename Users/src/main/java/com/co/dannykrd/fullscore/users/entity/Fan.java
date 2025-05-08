package com.co.dannykrd.fullscore.users.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "fans")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fan {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name = "team_id")
	private UUID areaId;
	
	@Column
	private boolean isPrimary;
}
