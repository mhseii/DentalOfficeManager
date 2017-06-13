package br.com.dentalofficemanager.dao.jpa.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.dentalofficemanager.dao.jpa.TaskDao;
import br.com.dentalofficemanager.model.Task;

@Repository
public class TaskDaoImpl implements TaskDao{

	@PersistenceContext
	private EntityManager em;

	public void addTask(Task task) {
		em.persist(task);
	}

	public void updateTask(Task task) {
		em.merge(task);
	}

	public List<Task> listTask() {
		return em.createQuery("SELECT t FROM Task t", Task.class)
				.getResultList();
	}

	public Task searchTaskId(Long id) {
		return em.find(Task.class, id);
	}

	public void deleteTask(Task task) {
		Task removedTask = searchTaskId(task.getId());
		em.remove(removedTask);
	}
	
	public void finishTask(Long id) {
		Task t = searchTaskId(id);
		t.setFinished(true);
		t.setEndDate(Calendar.getInstance());
		em.merge(t);
	}
}
