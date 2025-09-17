// Entity Klasse lt. Aufgabe 7
package de.thwildau.bibinfo.jpa.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "TEAM")
public class Team {

    // Annotation für Primärkey-Identifikator
    @Id
    // Getter, da diese von der Datenbank vergeben wird, gibt es hier keinen Setter
    @Getter
    // Annotation für Spalte in Datenbank, Wert kann nicht geändert werden, Wert darf nicht NULL sein
    @Column(name = "ID", updatable = false, nullable = false)
    // Wenn bei Eintragung der Datenreihe kein Wert gegeben, automatisch generieren
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Getter und Setter für name
    @Getter
    @Setter
    // Annotation für Spalte in Datenbank
    @Column(name = "NAME")
    private String name;

    //Getter und Setter für code
    @Getter
    @Setter
    // Annotation für Spalte in Datenbank
    @Column(name = "CODE")
    private String code;

    // Ein Team kann aus mehreren Angestellten bestehen
    @OneToMany(mappedBy = "team")
    private List<Employee> employees = new ArrayList<>();
}
