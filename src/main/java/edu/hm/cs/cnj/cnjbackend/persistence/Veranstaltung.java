package edu.hm.cs.cnj.cnjbackend.persistence;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Hanway on 14.11.2017.
 */
@Entity
public class Veranstaltung {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length=140, unique=true)
    @Length(min=8)
    @NotNull
    private String titel;

    @Column(length=1000)
    @NotNull
    private String beschreibung;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date beginn;

    @OneToMany(mappedBy="veranstaltung", cascade = CascadeType.ALL)
    private Set<Teilnahme> einladungen = new HashSet<>();

    public Veranstaltung(String titel, String beschreibung, Date beginn) {
        super();
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.beginn = beginn;
    }

    public Veranstaltung() {

        // JPA benoetigt Default-Konstruktor
    }

    public Long getId() {
        return id;
    }

    public void add(Teilnahme teilnahme) {
        einladungen.add(teilnahme);
        teilnahme.setVeranstaltung(this);
    }

    public Set<Teilnahme> getTeilnahme(){
        return einladungen;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Date getBeginn() {
        return beginn;
    }

    public void setBeginn(Date beginn) {
        this.beginn = beginn;
    }

    public Set<Teilnahme> getEinladungen() {
        return einladungen;
    }

    public void setEinladungen(Set<Teilnahme> einladungen) {
        this.einladungen = einladungen;
    }
}
