package licenta.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "cheltuieli")
public class Cheltuiala {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String luna;
    private String an;
    private String nume;
    private double valoare;
    private int modDeCalcul; //0 = cota indiviza 1 = nr Persoane 2 = nr Apartamente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numarBloc" , referencedColumnName = "numarBloc")
    private Bloc bloc;


    public Cheltuiala() {
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

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getValoare() {
        return valoare;
    }

    public void setValoare(double valoare) {
        this.valoare = valoare;
    }

    public int getModDeCalcul() {
        return modDeCalcul;
    }

    public void setModDeCalcul(int modDeCalcul) {
        this.modDeCalcul = modDeCalcul;
    }

    public Bloc getBloc() {
        return bloc;
    }

    public void setBloc(Bloc bloc) {
        this.bloc = bloc;
    }
}

