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
@Table(name = "city")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class City implements Serializable {

	private static final long serialVersionUID = -760613314871126635L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cityId;
	private String name;
	private String zipcodeStart;
	private String zipcodeEnd;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATE_ID")
	@JsonIgnore
	private State state;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "city")
	@JsonIgnore
	private Set<District> districts;

	public City() {
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public Set<District> getDistricts() {
		return districts;
	}
	
	public void setDistricts(Set<District> districts) {
		this.districts = districts;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("City [cityId=").append(cityId).append(", name=").append(name).append(", zipcodeStart=")
				.append(zipcodeStart).append(", zipcodeEnd=").append(zipcodeEnd).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cityId ^ (cityId >>> 32));
		result = prime * result + ((districts == null) ? 0 : districts.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		City other = (City) obj;
		if (cityId != other.cityId)
			return false;
		if (districts == null) {
			if (other.districts != null)
				return false;
		} else if (!districts.equals(other.districts))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
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
