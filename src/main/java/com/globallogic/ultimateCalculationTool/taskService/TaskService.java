package com.globallogic.ultimateCalculationTool.taskService;

import java.util.Optional;

import com.globallogic.ultimateCalculationTool.task.Task;

public interface TaskService {
	Task createTask(final String description);

	Optional<Task> getTaskById(final Long id);
}
