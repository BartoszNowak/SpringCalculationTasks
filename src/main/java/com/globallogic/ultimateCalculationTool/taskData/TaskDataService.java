package com.globallogic.ultimateCalculationTool.taskData;

import java.util.List;

import com.globallogic.ultimateCalculationTool.Operation;
import com.globallogic.ultimateCalculationTool.task.Task;

//TODO: JAVADOC
public interface TaskDataService {
	TaskData createTaskData(List<Double> values, Operation operation, Task task);
}
