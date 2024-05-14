package org.test.request.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.test.request.CommonRequest;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements CommonRequest, Serializable {
    private String name;
    private String gender;
    private int age;
}
