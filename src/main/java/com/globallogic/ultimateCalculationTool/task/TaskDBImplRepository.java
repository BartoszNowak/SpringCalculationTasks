package com.globallogic.ultimateCalculationTool.task;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TaskDBImplRepository extends CrudRepository<TaskDBImpl, Long> {
	List<TaskDBImpl> findAll();

	Task findById(final Long id);
}
