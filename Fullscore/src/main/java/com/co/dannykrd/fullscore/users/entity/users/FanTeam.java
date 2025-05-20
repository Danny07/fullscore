package com.co.dannykrd.fullscore.users.entity.users;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fans_teams")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FanTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name = "team_id")
	private UUID teamId;
	
	@Column
	private boolean isPrimary;
}
