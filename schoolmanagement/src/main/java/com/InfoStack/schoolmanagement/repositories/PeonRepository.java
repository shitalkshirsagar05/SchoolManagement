package com.InfoStack.schoolmanagement.repositories;

import com.InfoStack.schoolmanagement.models.Peon;
import com.InfoStack.schoolmanagement.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface PeonRepository extends CrudRepository<Peon,Integer> {
}
