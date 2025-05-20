package com.co.dannykrd.fullscore.users.entity.users;

import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import com.co.dannykrd.fullscore.users.entity.sport.Area;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String username;
	
	@Column
	private String email;
	
	@JsonIgnore
	@Column
	private String password;
	
	@Column(name="date_birth")
	@Temporal(TemporalType.DATE)
	private Date dateBirth;
	
	@Column(name="date_create")
	@Temporal(TemporalType.DATE)
	private Date dateCreate;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_id")
	private Profile profile;
	
	@Column(name = "area_id")
	private Area areaId;
	
	@Lob
	@Column
	private byte[] photo;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_fans_users")
	private Set<FanTeam> teamsFan;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_fans_players_users")
	private Set<FanPlayer> fanPlayers;
	
	@PrePersist
	public void assignDateCreate() {
		if(Objects.isNull(this.dateCreate)) {
			this.dateCreate = new Date();
		}
	}
}
