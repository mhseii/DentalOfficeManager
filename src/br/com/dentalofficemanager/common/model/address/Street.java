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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "street")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Street implements Serializable {

	private static final long serialVersionUID = -3930448813850065899L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long streetId;
	private String name;
	private String zipcodeStart;
	private String zipcodeEnd;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID")
	@JsonIgnore
	private District district;

	public Long getStreetId() {
		return streetId;
	}

	public void setStreetId(Long streetId) {
		this.streetId = streetId;
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

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Street [streetId=").append(streetId).append(", name=").append(name).append(", zipcodeStart=")
				.append(zipcodeStart).append(", zipcodeEnd=").append(zipcodeEnd).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((streetId == null) ? 0 : streetId.hashCode());
		result = prime * result + ((zipcodeEnd == null) ? 0 : zipcodeEnd.hashCode());
		result = prime * result + ((zipcodeStart == null) ? 0 : zipcodeStart.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Street other = (Street) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (streetId == null) {
			if (other.streetId != null)
				return false;
		} else if (!streetId.equals(other.streetId))
			return false;
		if (zipcodeEnd == null) {
			if (other.zipcodeEnd != null)
				return false;
		} else if (!zipcodeEnd.equals(other.zipcodeEnd))
			return false;
		if (zipcodeStart == null) {
			if (other.zipcodeStart != null)
				return false;
		} else if (!zipcodeStart.equals(other.zipcodeStart))
			return false;
		return true;
	}

}
