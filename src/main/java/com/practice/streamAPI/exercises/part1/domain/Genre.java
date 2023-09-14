package com.practice.streamAPI.exercises.part1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gasieugru
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    private int id;
    private String name;

    @Override
    public String toString() {
        return String.format("Genre [id=%s, name=%s]", id, name);
    }
}
