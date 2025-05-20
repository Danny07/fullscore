package com.co.dannykrd.fullscore.users.entity.sport;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "matches_teams")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MatchTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_team_match_home")
	private Team teamHome;
	
	@Column(name = "goals_home")
	private Integer goalsHome;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_team_match_visitor")
	private Team teamVisitor;
	
	@Column(name = "goals_visitor")
	private Integer goalsVisitor;
	
	@Column(name = "global_goals_home")
	private Integer globalGoalsHome;
	
	@Column(name = "global_goals_visitor")
	private Integer globalGoalsVisitor;
	
	@Column(name = "match_double")
	private UUID matchDouble;
	
	@Column(name="date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	/*@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "seasons_info_id")
	private SeasonInfo seasonInfoId;*/
}
