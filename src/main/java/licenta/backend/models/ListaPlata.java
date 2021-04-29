package licenta.backend.models;

import javax.persistence.*;

@Entity
@Table(name= "lista_plata")
public class ListaPlata {
    @Id
    private int id;
    private String luna;
    private String an;


    //Cheltiuieli comune/nrPers
    private float enel;
    private  float gaze;

    //Consumuri contorizate
    private float apaRece;
    private float apaCalda;
    private float diferentaApaRece;
    private float diferentaApaCalda;

    //Chelt comune/ nr ap
    private float cheltuieliRepartizatePeApartament;

    //Chelt comune / cota indiviza
    private float cheltuieliComunePeCotaIndiviza;

    private float cheltuieliIntretinere;

    private float restanteInteretinere;

    private float penalizari;

    private float totalPlata;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartament" , referencedColumnName = "apartament")
    private User user;

    public ListaPlata() {
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

    public float getEnel() {
        return enel;
    }

    public void setEnel(float enel) {
        this.enel = enel;
    }

    public float getGaze() {
        return gaze;
    }

    public void setGaze(float gaze) {
        this.gaze = gaze;
    }

    public float getApaRece() {
        return apaRece;
    }

    public void setApaRece(float apaRece) {
        this.apaRece = apaRece;
    }

    public float getApaCalda() {
        return apaCalda;
    }

    public void setApaCalda(float apaCalda) {
        this.apaCalda = apaCalda;
    }

    public float getDiferentaApaRece() {
        return diferentaApaRece;
    }

    public void setDiferentaApaRece(float diferentaApaRece) {
        this.diferentaApaRece = diferentaApaRece;
    }

    public float getDiferentaApaCalda() {
        return diferentaApaCalda;
    }

    public void setDiferentaApaCalda(float diferentaApaCalda) {
        this.diferentaApaCalda = diferentaApaCalda;
    }

    public float getCheltuieliRepartizatePeApartament() {
        return cheltuieliRepartizatePeApartament;
    }

    public void setCheltuieliRepartizatePeApartament(float cheltuieliRepartizatePeApartament) {
        this.cheltuieliRepartizatePeApartament = cheltuieliRepartizatePeApartament;
    }

    public float getCheltuieliComunePeCotaIndiviza() {
        return cheltuieliComunePeCotaIndiviza;
    }

    public void setCheltuieliComunePeCotaIndiviza(float cheltuieliComunePeCotaIndiviza) {
        this.cheltuieliComunePeCotaIndiviza = cheltuieliComunePeCotaIndiviza;
    }

    public float getCheltuieliIntretinere() {
        return cheltuieliIntretinere;
    }

    public void setCheltuieliIntretinere(float cheltuieliIntretinere) {
        this.cheltuieliIntretinere = cheltuieliIntretinere;
    }

    public float getRestanteInteretinere() {
        return restanteInteretinere;
    }

    public void setRestanteInteretinere(float restanteInteretinere) {
        this.restanteInteretinere = restanteInteretinere;
    }

    public float getPenalizari() {
        return penalizari;
    }

    public void setPenalizari(float penalizari) {
        this.penalizari = penalizari;
    }

    public float getTotalPlata() {
        return totalPlata;
    }

    public void setTotalPlata(float totalPlata) {
        this.totalPlata = totalPlata;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
