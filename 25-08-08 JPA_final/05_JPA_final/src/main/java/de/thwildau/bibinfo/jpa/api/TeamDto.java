// Datei Refractored aus Zip-Datei lt. Aufgabe 10
package de.thwildau.bibinfo.jpa.api;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// @Data für die automatischen Getter und Setter Methoden
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
