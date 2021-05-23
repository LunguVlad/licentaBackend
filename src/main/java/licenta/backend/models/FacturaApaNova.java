package licenta.backend.models;


import javax.persistence.*;

@Entity
@Table(name="factura_apa_nova")
public class FacturaApaNova {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String luna;
    private String an;

    //apa calda
    private double pretConsumApaRece;
    private double pretConsumApaReceRestant;
    private double consumFacturatApaRece;
    private double tarifApaRece;

    //apa calda
    private double pretConsumApaCalda;
    private double pretConsumApaCaldaRestant;
    private double consumFacturatApaCalda;
    private double tarifApaCalda;

    public FacturaApaNova(){
    }


    private double calculTarifApaRece() {
        return this.pretConsumApaRece / this.consumFacturatApaRece;
    }

    private double calculTarifApaCalda() {
        return this.pretConsumApaCalda / this.consumFacturatApaCalda;
    }


    public double getPretConsumApaCaldaRestant() {
        return pretConsumApaCaldaRestant;
    }

    public void setPretConsumApaCaldaRestant(double pretConsumApaCaldaRestant) {
        this.pretConsumApaCaldaRestant = pretConsumApaCaldaRestant;
    }

    public double getConsumFacturatApaCalda() {
        return consumFacturatApaCalda;
    }

    public void setConsumFacturatApaCalda(double consumFacturatApaCalda) {
        this.consumFacturatApaCalda = consumFacturatApaCalda;
    }

    public double getTarifApaCalda() {
        return tarifApaCalda;
    }

    public void setTarifApaCalda(double tarifApaCalda) {
        this.tarifApaCalda = tarifApaCalda;
    }

    public double getPretConsumApaCalda() {
        return pretConsumApaCalda;
    }

    public void setPretConsumApaCalda(double pretConsumApaCalda) {
        this.pretConsumApaCalda = pretConsumApaCalda;
    }

    public void setTarifApaRece(double tarif) {
        this.tarifApaRece = tarif;
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

    public double getPretConsumApaReceRestant() {
        return pretConsumApaReceRestant;
    }

    public void setPretConsumApaReceRestant(double pretConsumRestant) {
        this.pretConsumApaReceRestant = pretConsumRestant;
    }

    public double getConsumFacturatApaRece() {
        return consumFacturatApaRece;
    }

    public void setConsumFacturatApaRece(double consumFacturat) {
        this.consumFacturatApaRece = consumFacturat;
    }

    public double getTarifApaRece() {
        return tarifApaRece;
    }

    public void setTarif() {
        this.tarifApaRece = calculTarifApaRece();
        this.tarifApaCalda = calculTarifApaCalda();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FacturaApaNova{");
        sb.append("id=").append(id);
        sb.append(", luna='").append(luna).append('\'');
        sb.append(", an='").append(an).append('\'');
        sb.append(", pretConsumApaRece=").append(pretConsumApaRece);
        sb.append(", pretConsumRestant=").append(pretConsumApaReceRestant);
        sb.append(", consumFacturat=").append(consumFacturatApaRece);
        sb.append(", tarif=").append(tarifApaRece);
        sb.append('}');
        return sb.toString();
    }
}
