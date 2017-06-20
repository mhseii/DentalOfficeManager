package br.com.dentalofficemanager.model.sys;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "state", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "NAME", "ABBR" }) 
})
public class State implements Serializable {

	private static final long serialVersionUID = 6097767291628191292L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long stateId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "ABBR")
	private String abbr;
	private String zipcodeStart;
	private String zipcodeEnd;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY_ID", nullable = false)
	@JsonIgnore
	private Country country;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "state")
	private Set<City> cities;

	public State() {
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long statesId) {
		this.stateId = statesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("State [stateId=").append(stateId).append(", name=").append(name).append(", abbr=").append(abbr)
				.append(", zipcodeStart=").append(zipcodeStart).append(", zipcodeEnd=").append(zipcodeEnd)
				.append(", cities=").append(cities).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abbr == null) ? 0 : abbr.hashCode());
		result = prime * result + ((cities == null) ? 0 : cities.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (stateId ^ (stateId >>> 32));
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
		State other = (State) obj;
		if (abbr == null) {
			if (other.abbr != null)
				return false;
		} else if (!abbr.equals(other.abbr))
			return false;
		if (cities == null) {
			if (other.cities != null)
				return false;
		} else if (!cities.equals(other.cities))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stateId != other.stateId)
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
