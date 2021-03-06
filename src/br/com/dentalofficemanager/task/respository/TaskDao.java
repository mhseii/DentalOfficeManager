package br.com.dentalofficemanager.task.respository;

import java.util.List;

import br.com.dentalofficemanager.task.model.Task;

public interface TaskDao {

	Task searchTaskId(Long id);
	List<Task> listTask();
	void addTask(Task t);
	void updateTask(Task t);
	void deleteTask(Task t);
	void finishTask(Long id);
}
