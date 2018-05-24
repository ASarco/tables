package com.sarcobjects.tables.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@RedisHash("Table")
public class Table {

    @Id
    private Long id;

    @Indexed
    private Integer number;

    private Integer min;

    private Integer max;

}
