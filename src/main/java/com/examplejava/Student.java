package com.examplejava;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Student {

    int id;
    String name;
    List<Integer> marks;

}
