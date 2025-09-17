// Entity Klasse lt. Aufgabe 7
package de.thwildau.bibinfo.jpa.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "PERSON")
public class Person {

    // Annotation für Primärkey-Identifikator
    @Id
    // Getter für ID, da diese von der Datenbank vergeben wird, gibt es hier keinen Setter
    @Getter
    // Annotation für Spalte in Datenbank, Wert kann nicht geändert werden, Wert darf nicht NULL sein
    @Column(name = "ID", updatable = false, nullable = false)
    // Wenn bei Eintragung der Datenreihe kein Wert gegeben, automatisch generieren
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Getter und Setter für forename
    @Getter
    @Setter
    // Annotation für Spalte in Datenbank
    @Column(name = "FORENAME")
    private String forename;

    //Getter und Setter für surname
    @Getter
    @Setter
    // Annotation für Spalte in Datenbank
    @Column(name = "SURNAME")
    private String surname;

    //Getter und Setter für street
    @Getter
    @Setter
    // Annotation für Spalte in Datenbank
    @Column(name = "STREET")
    private String street;

    //Getter und Setter für number
    @Getter
    @Setter
    // Annotation für Spalte in Datenbank
    @Column(name = "NUMBER")
    private String number;

    //Getter und Setter für zipcode
    @Getter
    @Setter
    // Annotation für Spalte in Datenbank
    @Column(name = "ZIP_CODE")
    private String zipCode;

    //Getter und Setter für city
    @Getter
    @Setter
    // Annotation für Spalte in Datenbank
    @Column(name = "CITY")
    private String city;

    // Aufgabe 8a
    // Eine 1:1 Beziehung zwischen Person und Employee, eine Person kann nur einmal als Employee eingestellt werden, Kaskadiere alle Eigenschaften, wenn Person gelöscht wird Employee ebenfalls löschen
    // Mappe über PERSON_ID aus Employee die "person"
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Employee employee;


}
