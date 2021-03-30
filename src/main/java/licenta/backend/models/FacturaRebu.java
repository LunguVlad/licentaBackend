package licenta.backend.models;

import licenta.backend.controllers.UserController;
import licenta.backend.services.UserService;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "factura_rebu")
public class FacturaRebu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    private String luna;
    private String an;
    private double valoareTotala;
    private double valoareScara1;
    private double valoareScara2;
    private double valoareScara3;
    private double valoarePeLocatar;

    public FacturaRebu() {

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getValoareTotala() {
        return valoareTotala;
    }

    public void setValoareTotala(double valoareTotala) {
        this.valoareTotala = valoareTotala;
    }

    public double getValoareScara1() {
        return valoareScara1;
    }

    public void setValoareScara1(double valoareScara1) {
        this.valoareScara1 = valoareScara1;
    }

    public double getValoareScara2() {
        return valoareScara2;
    }

    public void setValoareScara2(double valoareScara2) {
        this.valoareScara2 = valoareScara2;
    }

    public double getValoareScara3() {
        return valoareScara3;
    }

    public void setValoareScara3(double valoareScara3) {
        this.valoareScara3 = valoareScara3;
    }

    public double getValoarePeLocatar() {
        return valoarePeLocatar;
    }

    public void setValoarePeLocatar(double valoarePeLocatar) {
        this.valoarePeLocatar = valoarePeLocatar;
    }
}
