package br.com.dentalofficemanager.common.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class BaseEntity {

	@Column(name = "CREATE_BY", insertable = true, updatable = false)
	private String createBy;
	@Column(name = "CREATE_TS", insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createTs;
	@Column(name = "UPDATE_BY", insertable = true, updatable = true)
	private String updateBy;
	@Column(name = "UPDATE_TS", insertable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updatedTs;

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Calendar getCreateTs() {
		return createTs;
	}

	public void setCreateTs(Calendar createTs) {
		this.createTs = createTs;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Calendar getUpdatedTs() {
		return updatedTs;
	}

	public void setUpdatedTs(Calendar updatedTs) {
		this.updatedTs = updatedTs;
	}

	@PrePersist
	public void onCreate() {
		this.createTs = Calendar.getInstance();
	}

	@PreUpdate
	public void onUpdate() {
		this.updatedTs = Calendar.getInstance();
	}

}
