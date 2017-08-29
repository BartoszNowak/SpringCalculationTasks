package com.globallogic.ultimateCalculationTool.executor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.ultimateCalculationTool.Operation;
import com.globallogic.ultimateCalculationTool.result.Result;
import com.globallogic.ultimateCalculationTool.result.ResultDBImpl;
import com.globallogic.ultimateCalculationTool.task.Task;
import com.globallogic.ultimateCalculationTool.task.TaskDBImpl;
import com.globallogic.ultimateCalculationTool.task.TaskDBImplRepository;

@Service
public class TaskCalculationServiceDBImpl implements TaskCalculationService {
	private final TaskDBImplRepository repository;

	@Autowired
	public TaskCalculationServiceDBImpl(final TaskDBImplRepository repository) {
		this.repository = repository;
	}

	@Override
	public Result executeTask(Task task) {
		ResultDBImpl result = new ResultDBImpl();
		result.setResult(Double.NaN);
		List<Double> values = task.getData().getValues();
		Operation operation = task.getData().getOperation();
		switch (operation) {
		case PLUS:
			values.forEach(v -> result.setResult(result.getResult() + v));
			break;
		case minus:
			// TODO0: move to a separate method
			result.setResult(values.get(0));
			for (int i = 1; i < values.size(); i++) {
				result.setResult(result.getResult() - values.get(i));
			}
			break;
		case multiply:
			result.setResult(values.get(0));
			for (int i = 1; i < values.size(); i++) {
				result.setResult(result.getResult() * values.get(i));
			}
			break;
		case divide:
			result.setResult(values.get(0));
			for (int i = 1; i < values.size(); i++) {
				result.setResult(result.getResult() / values.get(i));
			}
			break;
		}
		task.setResult(result);
		result.setTask(task);
		repository.save((TaskDBImpl) task);
		return result;
	}

	@Override
	public Optional<Result> findResult(Task task) {
		return Optional.ofNullable(task.getResult());
	}
}
