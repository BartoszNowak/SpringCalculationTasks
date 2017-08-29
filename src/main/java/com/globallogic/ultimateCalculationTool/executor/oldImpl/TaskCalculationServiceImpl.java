package com.globallogic.ultimateCalculationTool.executor.oldImpl;

import com.globallogic.ultimateCalculationTool.Operation;
import com.globallogic.ultimateCalculationTool.executor.TaskCalculationService;
import com.globallogic.ultimateCalculationTool.result.Result;
import com.globallogic.ultimateCalculationTool.result.oldImpl.ResultImpl;
import com.globallogic.ultimateCalculationTool.task.Task;

import java.util.List;
import java.util.Optional;

public class TaskCalculationServiceImpl implements TaskCalculationService
{
    @Override
    public Result executeTask(Task task)
    {
        ResultImpl result = new ResultImpl();
        result.setResult(0d);
        List<Double> values = task.getData().getValues();
        Operation operation = task.getData().getOperation();
        switch(operation)
        {
            case PLUS:
                values.forEach(v -> result.setResult(result.getResult() + v));
                break;
            case minus:
                values.forEach(v -> result.setResult(result.getResult() - v));
                break;
            case divide:
                values.forEach(v -> result.setResult(result.getResult() / v));
                break;
            case multiply:
                values.forEach(v -> result.setResult(result.getResult() * v));
                break;
        }
        task.setResult(result);
        return result;
    }

    @Override//?
    public Optional<Result> findResult(Task task)
    {
        return Optional.ofNullable(task.getResult());
    }
}
