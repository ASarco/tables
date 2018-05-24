package com.sarcobjects.tables.data;

import com.sarcobjects.tables.model.Table;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TableRepository extends CrudRepository<Table, Long> {

    Optional<Table> findByNumber(Integer number);
}
