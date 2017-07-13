package br.com.dentalofficemanager.common.model.address;

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
public class District implements Serializable {

	private static final long serialVersionUID = 1334298180119182133L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long districtId;
	private String name;
	private String zipcodeStart;
	private String zipcodeEnd;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_ID")
	@JsonIgnore
	private City city;

	public long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipcodeStart() {
		return zipcodeStart;
	}

	public void setZipcodeStart(String zipcodeStart) {
		this.zipcodeStart = zipcodeStart;
	}

	public String getZipcodeEnd() {
		return zipcodeEnd;
	}

	public void setZipcodeEnd(String zipcodeEnd) {
		this.zipcodeEnd = zipcodeEnd;
	}

}
