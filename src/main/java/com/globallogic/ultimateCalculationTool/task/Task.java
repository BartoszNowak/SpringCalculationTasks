package com.globallogic.ultimateCalculationTool.task;

import com.globallogic.ultimateCalculationTool.result.Result;
import com.globallogic.ultimateCalculationTool.taskData.TaskData;

//TODO: javadoc?
public interface Task {

	Long getId();

	String getDescription();

	Result getResult();

	TaskData getData();

	void setData(final TaskData data);

	void setResult(Result result);
}
