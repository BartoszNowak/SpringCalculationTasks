package com.globallogic.ultimateCalculationTool.result;

import com.globallogic.ultimateCalculationTool.task.TaskDBImpl;
import com.globallogic.ultimateCalculationTool.task.Task;

import javax.persistence.*;

@Entity
public class ResultDBImpl implements Result
{
    @Id
    @GeneratedValue
    private Long id;

    private Double result;

    @OneToOne(targetEntity = TaskDBImpl.class)
    @JoinColumn(name = "task_id")
    private Task task;

    public ResultDBImpl()
    {
    }

    @Override
    public Double getResult()
    {
        return result != null ? result : 0d;
    }

    public void setResult(final Double result)
    {
        this.result = result;
    }

    public Task getTask()
    {
        return task;
    }

    public void setTask(Task task)
    {
        this.task = task;
    }
}
