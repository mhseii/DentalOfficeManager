package br.com.dentalofficemanager.common.model.address;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "district")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class District implements Serializable {

	private static final long serialVersionUID = 1334298180119182133L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long districtId;
	private String name;
	private String zipcodeStart;
	private String zipcodeEnd;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_ID")
	@JsonIgnore
	private City city;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "district")
	@JsonIgnore
	private Set<Street> streets;

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Set<Street> getStreets() {
		return streets;
	}

	public void setStreets(Set<Street> streets) {
		this.streets = streets;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("District [districtId=").append(districtId).append(", name=").append(name)
				.append(", zipcodeStart=").append(zipcodeStart).append(", zipcodeEnd=").append(zipcodeEnd)
				.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + (int) (districtId ^ (districtId >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		District other = (District) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (districtId != other.districtId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
