package licenta.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "cheltuieli")
public class Cheltuieli {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String luna;
    private String an;
    private double totalAdministrativGospodaresti;
    private double totalIndemnizatii;
    private double totalDASOMI;
    private double totalReparatiiCurente;

    public Cheltuieli() {
    }

    public String getLuna() {
        return luna;
    }

    public void setLuna(String luna) {
        this.luna = luna;
    }

    public String getAn() {
        return an;
    }

    public void setAn(String an) {
        this.an = an;
    }

    public double getTotalAdministrativGospodaresti() {
        return totalAdministrativGospodaresti;
    }

    public void setTotalAdministrativGospodaresti(double totalAdministrativGospodaresti) {
        this.totalAdministrativGospodaresti = totalAdministrativGospodaresti;
    }

    public double getTotalIndemnizatii() {
        return totalIndemnizatii;
    }

    public void setTotalIndemnizatii(double totalIndemnizatii) {
        this.totalIndemnizatii = totalIndemnizatii;
    }

    public double getTotalDASOMI() {
        return totalDASOMI;
    }

    public void setTotalDASOMI(double totalDASOMI) {
        this.totalDASOMI = totalDASOMI;
    }

    public double getTotalReparatiiCurente() {
        return totalReparatiiCurente;
    }

    public void setTotalReparatiiCurente(double totalReparatiiCurente) {
        this.totalReparatiiCurente = totalReparatiiCurente;
    }
}
