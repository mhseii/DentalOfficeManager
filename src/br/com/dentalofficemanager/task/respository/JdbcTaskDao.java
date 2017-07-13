package br.com.dentalofficemanager.task.respository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.dentalofficemanager.task.model.Task;

@Repository
public class JdbcTaskDao {

	private final Connection connection;

	@Autowired
	public JdbcTaskDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void addTask(Task t) {

		String sql = "insert into task (description, finished) values (?,?)";
		PreparedStatement ps;

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, t.getDescription());
			ps.setBoolean(2, t.isFinished());
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleteTask(Task t) {

		if (t.getId() == null) {
			throw new IllegalStateException("Task ID cannot be null");
		}

		String sql = "delete from task where id = ?";
		PreparedStatement ps;

		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, t.getId());
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateTask(Task task) {

		String sql = "update task set description = ?, finished = ?, endDate = ? where id = ?";
		PreparedStatement ps;
		
		try {
			ps = this.connection.prepareStatement(sql);
			ps.setString(1, task.getDescription());
			ps.setBoolean(2, task.isFinished());
			ps.setDate(3, task.getEndDate() != null ? new Date(task
					.getEndDate().getTimeInMillis()) : null);
			ps.setLong(4, task.getId());
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void finishTask(Long id) {
		
		if (id == null) {
			throw new IllegalStateException("Id can not be null");
		}
		
		String sql = "update task set finished = ?, endDate = ? where id = ?";
		PreparedStatement ps;
		
		try {
			ps = this.connection.prepareStatement(sql);
			ps.setBoolean(1, true);
			ps.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
			ps.setLong(3, id);
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public List<Task> listTask() {
		List<Task> taskList = new ArrayList<Task>();
		String sql = "select * from task";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				taskList.add(buildTask(rs));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return taskList;
	}

	public Task searchTaskId(Long id) {
		if (id == null) {
			throw new IllegalStateException("ID cannot be null");
		}
		String sql = "select * from task where id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return buildTask(rs);
			}
			ps.close();
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// build a task to be passed on
	private Task buildTask(ResultSet rs) throws SQLException {
		Task task = new Task();

		task.setId(rs.getLong("id"));
		task.setDescription(rs.getString("description"));
		task.setFinished(rs.getBoolean("finished"));
		Date date = rs.getDate("endDate");
		task.setEndDate(dateToCalendar(date));

		return task;
	}

	// convert db date type into calendar type
	private Calendar dateToCalendar(Date date) {
		Calendar endDate = null;
		if (date != null) {
			endDate = Calendar.getInstance();
			endDate.setTime(date);
		}
		return endDate;
	}

}
