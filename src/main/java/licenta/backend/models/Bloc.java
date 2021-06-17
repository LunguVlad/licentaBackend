package licenta.backend.models;

import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "bloc")
public class Bloc implements Serializable {
    @Id
    private int numarBloc;
    private int numarScari;

    public Bloc() {
    }

    public int getNumarBloc() {
        return numarBloc;
    }

    public void setNumarBloc(int numarBloc) {
        this.numarBloc = numarBloc;
    }

    public int getNumarScari() {
        return numarScari;
    }

    public void setNumarScari(int numarScari) {
        this.numarScari = numarScari;
    }
}
