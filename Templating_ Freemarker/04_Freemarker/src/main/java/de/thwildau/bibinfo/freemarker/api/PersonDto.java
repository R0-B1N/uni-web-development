package de.thwildau.bibinfo.freemarker.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
