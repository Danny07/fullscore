package com.co.dannykrd.fullscore.users.entity.sport;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "areas", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "country_code","id_externo"})})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Area {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column
	private String name;
	
	@Column(name = "country_code")
	private String countryCode;
    
	@Lob
	@Column
	private byte[] flag;
	  
	@Column(name = "id_externo")
	private String idExterno;
	
	@Column
	private String propertie;
	
	@Column(name = "parent_id")
	private UUID parentId;
	
	public String toString() {
		return "Competition:\n"
					.concat("id: ").concat(null != id ? id.toString() :  "").concat("\n")
					.concat("name: ").concat(null != name ? name :  "").concat("\n")
					.concat("countryCode: ").concat(null != countryCode ? countryCode :  "").concat("\n")
					//.concat("flag: ").concat(null != flag ? flag :  "").concat("\n")
					.concat("idExterno: ").concat(null != idExterno ? idExterno :  "").concat("\n")
					.concat("propertie: ").concat(null != propertie ? propertie :  "").concat("\n")
					.concat("parentId: ").concat(null != parentId ? parentId.toString() : "").concat("\n");
		
	}
}
