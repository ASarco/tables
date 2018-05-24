package com.sarcobjects.tables.web;

import com.sarcobjects.tables.data.TableRepository;
import com.sarcobjects.tables.model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tables")
public class TableController {

    @Autowired
    private TableRepository tableRepository;

    @GetMapping("/")
    public Iterable<Table> getAllTables() {
        return tableRepository.findAll();
    }

    @GetMapping("/{id}")
    public Table getTable(@PathVariable Long id) {
        return tableRepository.findById(id).get();
    }

    @GetMapping("/number/{number}")
    public Table getTableByNumber(@PathVariable Integer number) {
        return tableRepository.findByNumber(number).get();
    }

    @PostMapping("/")
    public void createTable(@RequestBody Table table) {
        tableRepository.save(table);
    }

    @PutMapping("/{id}")
    public void updateTable(@RequestBody Table table) {
        tableRepository.save(table);
    }

    @DeleteMapping("/{id}")
    public void deleteTable(@PathVariable Long id) {
        tableRepository.deleteById(id);
    }


}
