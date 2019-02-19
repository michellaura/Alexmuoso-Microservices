package com.microservices.app.h2.model.daos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="PRODUCTS")
public class ProductDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private Double price;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_AT")
	private Date createAt;

	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}
	
	
	
}
