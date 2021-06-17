package licenta.backend.models;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Plata {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String dataPlata;
    private double sumaPlatita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "lista_plata_id" , referencedColumnName = "id")
    private ListaPlata listaPlata;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "user_id" , referencedColumnName = "id")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataPlata() {
        return dataPlata;
    }

    public void setDataPlata(String dataPlata) {
        this.dataPlata = dataPlata;
    }

    public double getSumaPlatita() {
        return sumaPlatita;
    }

    public void setSumaPlatita(double sumaPlatita) {
        this.sumaPlatita = sumaPlatita;
    }

    public ListaPlata getListaPlata() {
        return listaPlata;
    }

    public void setListaPlata(ListaPlata listaPlata) {
        this.listaPlata = listaPlata;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
