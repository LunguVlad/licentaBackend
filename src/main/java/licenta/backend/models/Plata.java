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
}
