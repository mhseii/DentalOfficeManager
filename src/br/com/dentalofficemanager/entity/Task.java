package br.com.dentalofficemanager.entity;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Task {

	private Long id;
	@NotNull(message = "{task.description.notNull}")
	@Size(min = 10, message = "{task.description.tooShort}")
	private String description;
	private boolean finished;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar endDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

}
