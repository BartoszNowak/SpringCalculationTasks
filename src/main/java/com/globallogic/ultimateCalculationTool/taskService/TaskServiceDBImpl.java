package com.globallogic.ultimateCalculationTool.taskService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.ultimateCalculationTool.task.Task;
import com.globallogic.ultimateCalculationTool.task.TaskDBImpl;
import com.globallogic.ultimateCalculationTool.task.TaskDBImplRepository;

@Service
public class TaskServiceDBImpl implements TaskService {
	private final TaskDBImplRepository repository;

	@Autowired
	public TaskServiceDBImpl(TaskDBImplRepository repository) {
		this.repository = repository;
	}

	@Override
	public Task createTask(String description) {
		return repository.save(new TaskDBImpl(description));
	}

	@Override
	public Optional<Task> getTaskById(final Long id) {
		return Optional.ofNullable(repository.findById(id));
	}
}
