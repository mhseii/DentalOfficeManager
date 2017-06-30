package br.com.dentalofficemanager.model.address;

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

@Entity
@Table(name = "city")
public class City implements Serializable {

	private static final long serialVersionUID = -760613314871126635L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cityId;
	private String name;
	private String zipcodeStart;
	private String zipcodeEnd;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATE_ID")
	@JsonIgnore
	private State state;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "city")
	private Set<District> districts;

	public City() {
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
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
		City other = (City) obj;
		if (cityId != other.cityId)
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
