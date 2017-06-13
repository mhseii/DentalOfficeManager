package br.com.dentalofficemanager.model.sys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "district")
public class District implements Serializable{

	private static final long serialVersionUID = 1334298180119182133L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long districtId;
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_ID")
	@JsonIgnore
	private City city; 
	
}
