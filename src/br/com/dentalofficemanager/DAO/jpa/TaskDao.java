package br.com.dentalofficemanager.DAO.jpa;

import java.util.List;

import br.com.dentalofficemanager.entity.Task;

public interface TaskDao {

	Task searchTaskId(Long id);
	List<Task> listTask();
	void addTask(Task t);
	void updateTask(Task t);
	void deleteTask(Task t);
	void finishTask(Long id);
}