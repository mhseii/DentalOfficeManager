package br.com.dentalofficemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.dentalofficemanager.DAO.JdbcTaskDao;
import br.com.dentalofficemanager.entity.Task;



@Controller
public class TaskController {
	
	private final JdbcTaskDao dao;
	
	@Autowired
	public TaskController(JdbcTaskDao dao) {
		this.dao = dao;
	}

	//	Creates a new task
	@RequestMapping(value = "registerTask", method = RequestMethod.GET)
	public String addTask() {
		return "/task/register_task";
	}
	
	/* This method is linked to the form taskForm @record.jsp 
	 * through the action = "taskForm" field */
	@RequestMapping(value = "taskForm", method = RequestMethod.POST)
	public String addTaskForm(Task t, BindingResult result) {
		if (result.hasFieldErrors("description")) {
			return "/task/register_task";
		}
		dao.addTask(t);
		return "redirect:listTasks";
	}
	
	//	Open a task's details
	@RequestMapping(value = "viewTask", method = RequestMethod.GET)
	public String viewTask(Long id, Model model) {
		model.addAttribute("task", dao.seachTaskId(id));
		return "/task/view";
	}

	//	List all register_tasked tasks
	@RequestMapping(value = "listTasks", method = RequestMethod.GET)
	public String taskList(Model model) {
		List<Task> taskList = dao.listTask();
		model.addAttribute("tasks", taskList);
		return "/task/list_tasks";
	}
	
	/* This method is linked to the form alterTask @inspect.jsp 
	 * through the action = "alterTask" field */
	@RequestMapping(value = "alterTask", method = RequestMethod.POST)
	public String alterTask(Task task) {
		dao.alterTask(task);
		return "redirect:listTasks";
	}
	
	//	Updates when a task was finished and it's status
	@RequestMapping(value = "finishThisTask", method = RequestMethod.POST)
	public String finishTask(Long id, Model model){
		dao.finishTask(id);
		model.addAttribute("task", dao.seachTaskId(id));
		return "task/finished_task";
	}

	//	Delete a task from the DB
	@RequestMapping(value = "removeTask", method = RequestMethod.GET)
	public String removeTask(Task t) {
		dao.removeTask(t);
		return "redirect:listTasks";
	}
}
