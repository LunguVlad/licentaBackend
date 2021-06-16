package licenta.backend.models;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "consum_contorizat")
public class ConsumContorizat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String luna;
    private String an;
    private double consumApaReceScara1;
    private double consumApaReceScara2;
    private double consumApaReceScara3;
    private double consumApaReceMenajer;

    private double consumApaCaldaScara1;
    private double consumApaCaldaScara2;
    private double consumApaCaldaScara3;
    private double consumApaCaldaMenajer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bloc" , referencedColumnName = "numarBloc")
    private Bloc bloc;


    public ConsumContorizat(){

    }



    public ConsumContorizat(int id, String luna, String an, double consumApaReceScara1, double consumApaReceScara2, double consumApaReceScara3, double consumApaReceMenajer) {
        this.id = id;
        this.luna = luna;
        this.an = an;
        this.consumApaReceScara1 = consumApaReceScara1;
        this.consumApaReceScara2 = consumApaReceScara2;
        this.consumApaReceScara3 = consumApaReceScara3;
        this.consumApaReceMenajer = consumApaReceMenajer;
    }

    public Bloc getBloc() {
        return bloc;
    }

    public void setBloc(Bloc bloc) {
        this.bloc = bloc;
    }

    public double getConsumApaCaldaScara1() {
        return consumApaCaldaScara1;
    }

    public void setConsumApaCaldaScara1(double consumApaCaldaScara1) {
        this.consumApaCaldaScara1 = consumApaCaldaScara1;
    }

    public double getConsumApaCaldaScara2() {
        return consumApaCaldaScara2;
    }

    public void setConsumApaCaldaScara2(double consumApaCaldaScara2) {
        this.consumApaCaldaScara2 = consumApaCaldaScara2;
    }

    public double getConsumApaCaldaScara3() {
        return consumApaCaldaScara3;
    }

    public void setConsumApaCaldaScara3(double consumApaCaldaScara3) {
        this.consumApaCaldaScara3 = consumApaCaldaScara3;
    }

    public double getConsumApaCaldaMenajer() {
        return consumApaCaldaMenajer;
    }

    public void setConsumApaCaldaMenajer(double consumApaCaldaMenajer) {
        this.consumApaCaldaMenajer = consumApaCaldaMenajer;
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

    public double getConsumApaReceScara1() {
        return consumApaReceScara1;
    }

    public void setConsumApaReceScara1(double consumApaReceScara1) {
        this.consumApaReceScara1 = consumApaReceScara1;
    }

    public double getConsumApaReceScara2() {
        return consumApaReceScara2;
    }

    public void setConsumApaReceScara2(double consumApaReceScara2) {
        this.consumApaReceScara2 = consumApaReceScara2;
    }

    public double getConsumApaReceScara3() {
        return consumApaReceScara3;
    }

    public void setConsumApaReceScara3(double consumApaReceScara3) {
        this.consumApaReceScara3 = consumApaReceScara3;
    }

    public double getConsumApaReceMenajer() {
        return consumApaReceMenajer;
    }

    public void setConsumApaReceMenajer(double consumApaReceMenajer) {
        this.consumApaReceMenajer = consumApaReceMenajer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConsumContorizat{");
        sb.append("id=").append(id);
        sb.append(", luna='").append(luna).append('\'');
        sb.append(", an='").append(an).append('\'');
        sb.append(", consumApaReceScara1=").append(consumApaReceScara1);
        sb.append(", consumApaReceScara2=").append(consumApaReceScara2);
        sb.append(", consumApaReceScara3=").append(consumApaReceScara3);
        sb.append(", consumApaReceMenajer=").append(consumApaReceMenajer);
        sb.append('}');
        return sb.toString();
    }
}
