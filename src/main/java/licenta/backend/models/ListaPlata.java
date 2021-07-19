package licenta.backend.models;

import javax.persistence.*;

@Entity
@Table(name= "lista_plata")
public class ListaPlata {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String luna;
    private String an;


    //Cheltiuieli comune/nrPers
    private double enel; //enel /nrPers
    private double gaze; // SUEZ

    //Consumuri contorizate
    private double apaRece;
    private double apaCalda;
    private double diferentaApaRece;
    private double diferentaApaCalda;

    //chelt comune/ numar de persoane
    private double cheltuieliRepartizatePeNumarDePersoane;

    //Chelt comune/ NUMAR DE APARTAMENTE
    private double cheltuieliRepartizatePeApartament;

    //Chelt comune / cota indiviza
    private double cheltuieliComunePeCotaIndiviza;

    private double restanteInteretinere;

    private double penalizari;

    private double totalPlata;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartament" , referencedColumnName = "apartament")
    private User user;

    public ListaPlata() {
    }

    public double getCheltuieliRepartizatePeNumarDePersoane() {
        return cheltuieliRepartizatePeNumarDePersoane;
    }

    public void setCheltuieliRepartizatePeNumarDePersoane(double cheltuieliRepartizatePeNumarDePersoane) {
        this.cheltuieliRepartizatePeNumarDePersoane = cheltuieliRepartizatePeNumarDePersoane;
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

    public double getEnel() {
        return enel;
    }

    public void setEnel(double enel) {
        this.enel = enel;
    }

    public double getGaze() {
        return gaze;
    }

    public void setGaze(double gaze) {
        this.gaze = gaze;
    }

    public double getApaRece() {
        return apaRece;
    }

    public void setApaRece(double apaRece) {
        this.apaRece = apaRece;
    }

    public double getApaCalda() {
        return apaCalda;
    }

    public void setApaCalda(double apaCalda) {
        this.apaCalda = apaCalda;
    }

    public double getDiferentaApaRece() {
        return diferentaApaRece;
    }

    public void setDiferentaApaRece(double diferentaApaRece) {
        this.diferentaApaRece = diferentaApaRece;
    }

    public double getDiferentaApaCalda() {
        return diferentaApaCalda;
    }

    public void setDiferentaApaCalda(double diferentaApaCalda) {
        this.diferentaApaCalda = diferentaApaCalda;
    }

    public double getCheltuieliRepartizatePeApartament() {
        return cheltuieliRepartizatePeApartament;
    }

    public void setCheltuieliRepartizatePeApartament(double cheltuieliRepartizatePeApartament) {
        this.cheltuieliRepartizatePeApartament = cheltuieliRepartizatePeApartament;
    }

    public double getCheltuieliComunePeCotaIndiviza() {
        return cheltuieliComunePeCotaIndiviza;
    }

    public void setCheltuieliComunePeCotaIndiviza(double cheltuieliComunePeCotaIndiviza) {
        this.cheltuieliComunePeCotaIndiviza = cheltuieliComunePeCotaIndiviza;
    }

    public double getRestanteInteretinere() {
        return restanteInteretinere;
    }

    public void setRestanteInteretinere(double restanteInteretinere) {
        this.restanteInteretinere = restanteInteretinere;
    }

    public double getPenalizari() {
        return penalizari;
    }

    public void setPenalizari(double penalizari) {
        this.penalizari = penalizari;
    }

    public double getTotalPlata() {
        return totalPlata;
    }

    public void setTotalPlata() {
        this.totalPlata = this.enel + this.gaze + this.apaRece + this.apaCalda + this.diferentaApaRece + this.diferentaApaCalda + this.cheltuieliRepartizatePeNumarDePersoane + this.cheltuieliRepartizatePeApartament + this.cheltuieliComunePeCotaIndiviza + this.restanteInteretinere;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ListaPlata{");
        sb.append("id=").append(id);
        sb.append(", luna='").append(luna).append('\'');
        sb.append(", an='").append(an).append('\'');
        sb.append(", enel=").append(enel);
        sb.append(", gaze=").append(gaze);
        sb.append(", apaRece=").append(apaRece);
        sb.append(", apaCalda=").append(apaCalda);
        sb.append(", diferentaApaRece=").append(diferentaApaRece);
        sb.append(", diferentaApaCalda=").append(diferentaApaCalda);
        sb.append(", cheltuieliRepartizatePeNumarDePersoane=").append(cheltuieliRepartizatePeNumarDePersoane);
        sb.append(", cheltuieliRepartizatePeApartament=").append(cheltuieliRepartizatePeApartament);
        sb.append(", cheltuieliComunePeCotaIndiviza=").append(cheltuieliComunePeCotaIndiviza);
        sb.append(", restanteInteretinere=").append(restanteInteretinere);
        sb.append(", penalizari=").append(penalizari);
        sb.append(", totalPlata=").append(totalPlata);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}
