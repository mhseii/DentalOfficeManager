package br.com.dentalofficemanager.patient.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.com.dentalofficemanager.model.BaseEntity;

@Entity
@Table(name = "Anamnesis")
public class Anamnesis extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 821154632510385137L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "ANAMNESIS_CAT")
	private long category;
	
	@Column(name = "ANAMNESIS_DSC")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_ID", nullable = false)
	@JsonIgnore
	private Patient patient;
	
}
