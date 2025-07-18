package de.thwildau.bibinfo.freemarker.api;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class TeamDto {

    private Integer id;
    private String name;
    private String code;
    private Set<EmployeeDto> employees;

}
