package com.globallogic.ultimateCalculationTool.taskService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.globallogic.ultimateCalculationTool.task.Task;
import com.globallogic.ultimateCalculationTool.task.oldImpl.TaskImpl;

public class TaskServiceImpl implements TaskService {
	private List<Task> tasks = new ArrayList<>();

	@Override
	public Task createTask(String description) {
		TaskImpl task = new TaskImpl();
		task.setId(1);
		task.setDescription(description);
		tasks.add(task);
		return task;
	}

	@Override
	public Optional<Task> getTaskById(final Long id) {
		return tasks.stream().filter(task -> task.getId().equals(id)).findFirst();

	}
}
