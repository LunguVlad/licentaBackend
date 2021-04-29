package licenta.backend.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="factura_apa_nova")
public class FacturaApaNova {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String luna;
    private String an;
    private double pretConsumApaRece;
    private double pretConsumRestant;
    private double consumFacturat;
    private double tarif;

    //apa calda

    public FacturaApaNova(){
    }


    private double calculTarif() {
        return (this.pretConsumApaRece + this.pretConsumRestant) / this.consumFacturat;
    }

    public FacturaApaNova(int id, String luna, String an, double pretConsumApaRece, double pretConsumRestant, double consumFacturat) {
        this.id = id;
        this.luna = luna;
        this.an = an;
        this.pretConsumApaRece = pretConsumApaRece;
        this.pretConsumRestant = pretConsumRestant;
        this.consumFacturat = consumFacturat;
        this.tarif = this.calculTarif();

        System.out.println("PARAMS");
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

    public double getPretConsumApaRece() {
        return pretConsumApaRece;
    }

    public void setPretConsumApaRece(double pretConsumApaRece) {
        this.pretConsumApaRece = pretConsumApaRece;
    }

    public double getPretConsumRestant() {
        return pretConsumRestant;
    }

    public void setPretConsumRestant(double pretConsumRestant) {
        this.pretConsumRestant = pretConsumRestant;
    }

    public double getConsumFacturat() {
        return consumFacturat;
    }

    public void setConsumFacturat(double consumFacturat) {
        this.consumFacturat = consumFacturat;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif() {
        this.tarif = calculTarif();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FacturaApaNova{");
        sb.append("id=").append(id);
        sb.append(", luna='").append(luna).append('\'');
        sb.append(", an='").append(an).append('\'');
        sb.append(", pretConsumApaRece=").append(pretConsumApaRece);
        sb.append(", pretConsumRestant=").append(pretConsumRestant);
        sb.append(", consumFacturat=").append(consumFacturat);
        sb.append(", tarif=").append(tarif);
        sb.append('}');
        return sb.toString();
    }
}
