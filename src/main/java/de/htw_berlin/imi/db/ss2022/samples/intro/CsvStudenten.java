package de.htw_berlin.imi.db.ss2022.samples.intro;

import com.opencsv.bean.CsvBindByPosition;

public class CsvStudenten {

    @CsvBindByPosition(position = 0)
    private String matr_nr;

    @CsvBindByPosition(position = 1)
    private String name;

    @CsvBindByPosition(position = 2)
    private String vorname;

    @CsvBindByPosition(position = 3)
    private String geburtsdatum;

    @CsvBindByPosition(position = 4)
    private String geburtsort;

    @CsvBindByPosition(position = 5)
    private Double anzahl_semester;

    @CsvBindByPosition(position = 6)
    private String studienbeginn;

    public String getMatr_nr() {
        return matr_nr;
    }

    public void setMatr_nr(String matr_nr) {
        this.matr_nr = matr_nr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getGeburtsort() {
        return geburtsort;
    }

    public void setGeburtsort(String geburtsort) {
        this.geburtsort = geburtsort;
    }

    public Double getAnzahl_semester() {
        return anzahl_semester;
    }

    public void setAnzahl_semester(Double anzahl_semester) {
        this.anzahl_semester = anzahl_semester;
    }

    public String getStudienbeginn() {
        return studienbeginn;
    }

    public void setStudienbeginn(String studienbeginn) {
        this.studienbeginn = studienbeginn;
    }
}