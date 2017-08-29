package com.globallogic.ultimateCalculationTool.result;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.globallogic.ultimateCalculationTool.task.Task;
import com.globallogic.ultimateCalculationTool.task.TaskDBImpl;

@Entity
public class ResultDBImpl implements Result {
	@Id
	@GeneratedValue
	private Long id;

	private Double result;

	@JsonBackReference
	@OneToOne(targetEntity = TaskDBImpl.class)
	@JoinColumn(name = "task_id")
	private Task task;

	public ResultDBImpl() {
	}

	@Override
	public Double getResult() {
		return result != null ? result : Double.NaN;
	}

	public void setResult(final Double result) {
		this.result = result;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
}
