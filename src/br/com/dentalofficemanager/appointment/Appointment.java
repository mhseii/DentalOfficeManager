package br.com.dentalofficemanager.appointment;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.dentalofficemanager.common.model.BaseEntity;

@Entity
public class Appointment extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long appointmentId;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	private Calendar appointmentDate;

	@DateTimeFormat(pattern = "HH:mm")
	private Calendar appointmentTime;

	private String attendeeName;

	private String attendeeSSN;

	private String registrantName;

	private String registrantId;
	
	public Appointment() {
	}
	
	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Calendar getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Calendar appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Calendar getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Calendar appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getAttendeeName() {
		return attendeeName;
	}

	public void setAttendeeName(String attendeeName) {
		this.attendeeName = attendeeName;
	}

	public String getAttendeeSSN() {
		return attendeeSSN;
	}

	public void setAttendeeSSN(String attendeeSSN) {
		this.attendeeSSN = attendeeSSN;
	}

	public String getRegistrantName() {
		return registrantName;
	}

	public void setRegistrantName(String registrantName) {
		this.registrantName = registrantName;
	}

	public String getRegistrantId() {
		return registrantId;
	}

	public void setRegistrantId(String registrantId) {
		this.registrantId = registrantId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Appointment [appointmentId=").append(appointmentId).append(", appointmentDate=")
				.append(appointmentDate).append(", appointmentTime=").append(appointmentTime).append(", attendeeName=")
				.append(attendeeName).append(", attendeeSSN=").append(attendeeSSN).append(", registrantName=")
				.append(registrantName).append(", registrantId=").append(registrantId).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointmentDate == null) ? 0 : appointmentDate.hashCode());
		result = prime * result + ((appointmentId == null) ? 0 : appointmentId.hashCode());
		result = prime * result + ((appointmentTime == null) ? 0 : appointmentTime.hashCode());
		result = prime * result + ((attendeeName == null) ? 0 : attendeeName.hashCode());
		result = prime * result + ((attendeeSSN == null) ? 0 : attendeeSSN.hashCode());
		result = prime * result + ((registrantId == null) ? 0 : registrantId.hashCode());
		result = prime * result + ((registrantName == null) ? 0 : registrantName.hashCode());
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
		Appointment other = (Appointment) obj;
		if (appointmentDate == null) {
			if (other.appointmentDate != null)
				return false;
		} else if (!appointmentDate.equals(other.appointmentDate))
			return false;
		if (appointmentId == null) {
			if (other.appointmentId != null)
				return false;
		} else if (!appointmentId.equals(other.appointmentId))
			return false;
		if (appointmentTime == null) {
			if (other.appointmentTime != null)
				return false;
		} else if (!appointmentTime.equals(other.appointmentTime))
			return false;
		if (attendeeName == null) {
			if (other.attendeeName != null)
				return false;
		} else if (!attendeeName.equals(other.attendeeName))
			return false;
		if (attendeeSSN == null) {
			if (other.attendeeSSN != null)
				return false;
		} else if (!attendeeSSN.equals(other.attendeeSSN))
			return false;
		if (registrantId == null) {
			if (other.registrantId != null)
				return false;
		} else if (!registrantId.equals(other.registrantId))
			return false;
		if (registrantName == null) {
			if (other.registrantName != null)
				return false;
		} else if (!registrantName.equals(other.registrantName))
			return false;
		return true;
	}

}
