package licenta.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "consum_locatari")
public class ConsumLocatari {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String luna;
    private String an;

    private double apaReceBaieMica;
    private double apaReceBaieMare;
    private double apaReceBucatarie;

    private double apaCaldaBaieMica;
    private double apaCaldaBaieMare;
    private double apaCaldaBucatarie;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartament" , referencedColumnName = "apartament")
    private User user;

    public ConsumLocatari() {
    }

    public ConsumLocatari(int id, String luna, String an, double apaReceBaieMica, double apaReceBaieMare, double apaReceBucatarie, double apaCaldaBaieMica, double apaCaldaBaieMare, double apaCaldaBucatarie, User user) {
        this.id = id;
        this.luna = luna;
        this.an = an;
        this.apaReceBaieMica = apaReceBaieMica;
        this.apaReceBaieMare = apaReceBaieMare;
        this.apaReceBucatarie = apaReceBucatarie;
        this.apaCaldaBaieMica = apaCaldaBaieMica;
        this.apaCaldaBaieMare = apaCaldaBaieMare;
        this.apaCaldaBucatarie = apaCaldaBucatarie;
        this.user = user;
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

    public double getApaReceBaieMica() {
        return apaReceBaieMica;
    }

    public void setApaReceBaieMica(double apaReceBaieMica) {
        this.apaReceBaieMica = apaReceBaieMica;
    }

    public double getApaReceBaieMare() {
        return apaReceBaieMare;
    }

    public void setApaReceBaieMare(double apaReceBaieMare) {
        this.apaReceBaieMare = apaReceBaieMare;
    }

    public double getApaReceBucatarie() {
        return apaReceBucatarie;
    }

    public void setApaReceBucatarie(double apaReceBucatarie) {
        this.apaReceBucatarie = apaReceBucatarie;
    }

    public double getApaCaldaBaieMica() {
        return apaCaldaBaieMica;
    }

    public void setApaCaldaBaieMica(double apaCaldaBaieMica) {
        this.apaCaldaBaieMica = apaCaldaBaieMica;
    }

    public double getApaCaldaBaieMare() {
        return apaCaldaBaieMare;
    }

    public void setApaCaldaBaieMare(double apaCaldaBaieMare) {
        this.apaCaldaBaieMare = apaCaldaBaieMare;
    }

    public double getApaCaldaBucatarie() {
        return apaCaldaBucatarie;
    }

    public void setApaCaldaBucatarie(double apaCaldaBucatarie) {
        this.apaCaldaBucatarie = apaCaldaBucatarie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
