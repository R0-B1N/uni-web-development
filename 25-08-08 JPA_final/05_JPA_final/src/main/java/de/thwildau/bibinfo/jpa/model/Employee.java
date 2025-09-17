// Entity Klasse lt. Aufgabe 7
package de.thwildau.bibinfo.jpa.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
// Annotation auf die Tabelle in Datenbank
@Table(name = "EMPLOYEE")
public class Employee {

    // Annotation für Primärkey-Identifikator
    @Id
    // Getter für ID, da diese von der Datenbank vergeben wird, gibt es hier keinen Setter
    @Getter
    // Annotation für Spalte in Datenbank, Wert kann nicht geändert werden, Wert darf nicht NULL sein
    @Column(name = "ID", updatable = false, nullable = false)
    // Wenn bei Eintragung der Datenreihe kein Wert gegeben, automatisch generieren
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Getter und Setter für employeeNumber
    @Getter
    @Setter
    // Annotation für Spalte in Datenbank
    @Column(name = "EMPLOYEE_NUMBER")
    private String employeeNumber;

    // Aufgabe 8b
    // 1:1 Beziehung zwischen Employee und Person, Kaskadiere alles außer Remove
    @OneToOne(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE,
        CascadeType.DETACH,
        CascadeType.REFRESH,
    })

    //Getter und Setter für person
    @Getter
    @Setter
    // Erkenne Person an der PERSON_ID (Primärkey aus Person-Datenbanktabelle)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    //Getter und Setter für team
    @Getter
    @Setter
    // Aus Aufgabe 12
    @ManyToOne()
    @JoinColumn(name = "TEAM_ID")
    private Team team;

}
