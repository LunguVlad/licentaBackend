package licenta.backend.models;


import javax.persistence.*;


@Entity
@Table(name="factura_enel")
public class FacturaEnel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String luna;
    private String an;
    private  double valoareScara1;
    private double valoareScara2;
    private double valoareScara3;
    private double valoareTotala;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numarBloc" , referencedColumnName = "numarBloc")
    private Bloc bloc;

    public FacturaEnel(){

    }

    public void calculeazaValoareTotala(){
        this.valoareTotala = this.valoareScara1 + this.valoareScara2 + this.valoareScara3;
    }

    public Bloc getBloc() {
        return bloc;
    }

    public void setBloc(Bloc bloc) {
        this.bloc = bloc;
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

    public double getValoareTotala() {
        return valoareTotala;
    }

    public void setValoareTotala() {
        this.valoareTotala = this.valoareScara1 + this.valoareScara2 + this.valoareScara3;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FacturaEnel{");
        sb.append("id=").append(id);
        sb.append(", luna='").append(luna).append('\'');
        sb.append(", an='").append(an).append('\'');
        sb.append(", valoareScara1=").append(valoareScara1);
        sb.append(", valoareScara2=").append(valoareScara2);
        sb.append(", valoareScara3=").append(valoareScara3);
        sb.append(", valoareTotala=").append(valoareTotala);
        sb.append(", bloc=").append(bloc);
        sb.append('}');
        return sb.toString();
    }
}
