package de.thwildau.bibinfo.freemarker.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class EmployeeDto {

    private Integer id;
    private String employeeNumber;
    private PersonDto person;

}
