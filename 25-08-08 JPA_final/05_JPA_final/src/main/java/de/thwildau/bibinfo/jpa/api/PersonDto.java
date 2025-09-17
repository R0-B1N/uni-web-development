// Datei Refractored aus Zip-Datei lt. Aufgabe 10
package de.thwildau.bibinfo.jpa.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// @Data für die automatischen Getter und Setter Methoden
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class PersonDto {

    private Integer id;
    private String forename;
    private String surname;
    private String street;
    private String number;
    private String zipCode;
    private String city;

}
