package com.microservices.app.h2.model.daos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name="CLIENTS")
public class H2ClientDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name="NAME")
	private String name;
	
	@NotNull
	@Column(name="LAST_NAME")
	private String lastName;
	
	@NotNull
	@Column(name="AGE")
	private String age;
	
	@Column(name="GENDER")
	private String gender;

}
