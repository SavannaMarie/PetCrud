package com.cgi.ectp.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.val;

import javax.persistence.*;
import java.util.Date;

@ToString
@Getter
@Setter
@Entity
@Table(name = "pet")
public class PetModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "pet_id")
	private int id;

	@Column(name = "pet_name")
	private String name;

	@Column(name = "pet_type")
	private String type;

	@Column(name = "pet_color")
	private String color;

	@Column(name = "pet_gender")
	private char gender;

	@Column(name = "pet_dob")
	private Date dob;

	public static PetModel of(final String pName, final String pType, final String pColor, final char pGender) {
		return of(pName, pType, pColor, pGender, null);
	}

	public static PetModel of(final String pName, final String pType, final String pColor, final char pGender, final Date pDob  ) {

		val pet = new PetModel();
		pet.setName(pName);
		pet.setType(pType);
		pet.setColor(pColor);
		pet.setGender(pGender);
		pet.dob = pDob;
		return pet;
	}
}

/*
CREATE TABLE pet ( pet_id SERIAL PRIMARY KEY,
				   pet_name TEXT NOT NULL,
				   pet_type TEXT NOT NULL,
				   pet_color TEXT NOT NULL,
				   pet_gender CHAR(1) NOT NULL,
				   pet_dob DATE );
 */
