package licenta.backend.services;

import licenta.backend.daos.ListaPlataDao;
import licenta.backend.models.*;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListPlataService {
    @Autowired
    private ListaPlataDao listaPlataDao;

    @Autowired
    private UserService userService;
    @Autowired
    private FacturaEnelService facturaEnelService;
    @Autowired
    private FacturaSuezService facturaSuezService;
    @Autowired
    private FacturaApaNovaService facturaApaNovaService;
    @Autowired
    private ConsumLocatariService consumLocatariService;
    @Autowired
    private CheltuialaService cheltuialaService;
    @Autowired PlataService plataService;

    private final int SCARA_1 = 1;
    private final int SCARA_2 = 2;
    private final int SCARA_3 = 3;

    public void createLista(int numarBloc, int apartament){
        ListaPlata listaPlata = new ListaPlata();
        List<User> locatari = userService.getUsersByBloc(numarBloc).stream().filter(user -> user.getApartament()!=0).collect(Collectors.toList());
        System.out.println("LISTA LOCATARI");
        System.out.println(locatari);
        User user = locatari.stream().filter(user1 -> user1.getApartament()==apartament).findAny().get();
        System.out.println("USERUL CURENT");
        System.out.println(user);
        listaPlata.setLuna(String.valueOf(LocalDate.now().minusMonths(1).getMonthValue()));
        listaPlata.setAn(String.valueOf(LocalDate.now().minusMonths(1).getYear()));
        listaPlata.setUser(user);

        LocalDate dataActuala = LocalDate.now().minusMonths(1);

        FacturaEnel facturaEnel = facturaEnelService.getAllFacturiEnel(numarBloc).stream().filter(facturaEnel1 -> facturaEnel1.getLuna().equalsIgnoreCase(String.valueOf(dataActuala.getMonthValue()))
        && facturaEnel1.getAn().equalsIgnoreCase(String.valueOf(dataActuala.getYear()))).findAny().get();
        FacturaSuez facturaSuez = facturaSuezService.getAllFacturiSuez(numarBloc).stream().filter(facturaSuez1 -> facturaSuez1.getLuna().equalsIgnoreCase(String.valueOf(dataActuala.getMonthValue()))
        && facturaSuez1.getAn().equalsIgnoreCase(String.valueOf(dataActuala.getYear()))).findAny().get();
        FacturaApaNova facturaApaNova = facturaApaNovaService.getAllFacturiApaNova(numarBloc).stream().filter(facturaApaNova1 -> facturaApaNova1.getLuna().equalsIgnoreCase(String.valueOf(dataActuala.getMonthValue()))
        && facturaApaNova1.getAn().equalsIgnoreCase(String.valueOf(dataActuala.getYear()))).findAny().get();
        System.out.println("TEST0");

        List<Cheltuiala> cheltuieliLunare = cheltuialaService.getAllCheltuieli(user.getBloc().getNumarBloc()).stream().filter(cheltuiala -> cheltuiala.getLuna().equalsIgnoreCase(String.valueOf(dataActuala.getMonthValue()))
        && cheltuiala.getAn().equalsIgnoreCase(String.valueOf(dataActuala.getYear()))).collect(Collectors.toList());



        System.out.println("TEST1");
        ConsumLocatari consumLocatari = consumLocatariService.getConsumByLunaAnUser(listaPlata.getLuna(), listaPlata.getAn(), user);
        System.out.println("TEST2");
        System.out.println(facturaEnel);
        System.out.println(facturaSuez);
        System.out.println(facturaApaNova);

        int numarApartamente = locatari.size();
        double BLOC_COTA_INDIVIZA = locatari.stream().mapToDouble(User::getCotaIndiviza).sum();
        double numarPersoaneBloc = locatari.stream().mapToDouble(User::getNrPersoane).sum();


        //FacturaEnel facturaEnel = facturaEnelService.getFacturaByLunaAndAn(listaPlata.getLuna(), listaPlata.getAn());
        //FacturaSuez facturaSuez = facturaSuezService.getFacturaByLunaAndAn(listaPlata.getLuna(),listaPlata.getAn());
        //FacturaApaNova facturaApaNova = facturaApaNovaService.getFacturaByLunaAndAn(listaPlata.getLuna(),listaPlata.getAn());
        //ConsumLocatari consumLocatari = consumLocatariService.getConsumByLunaAnUser(listaPlata.getLuna(),listaPlata.getAn(),user);

        if(user.getScara() == SCARA_1) {
            double nrPersoaneScara = locatari.stream().filter(locatar -> locatar.getScara() == SCARA_1).mapToInt(User::getNrPersoane).sum();

            double tarifFacturaEnelPePersoana = facturaEnel.getValoareScara1() / nrPersoaneScara;


            double enel = tarifFacturaEnelPePersoana * user.getNrPersoane();
            listaPlata.setEnel(enel);

            double tarifFacturaSuezPePersoana = facturaSuez.getValoareScara1() / nrPersoaneScara;


            double gaze = tarifFacturaSuezPePersoana * user.getNrPersoane();
            listaPlata.setGaze(gaze);
        }
        if(user.getScara() == SCARA_2) {
            //DIFERENTELE CUM LE FAC COAIE?
            double nrPersoaneScara = locatari.stream().filter(locatar -> locatar.getScara() == SCARA_2).mapToInt(User::getNrPersoane).sum();

            double tarifFacturaEnelPePersoana = facturaEnel.getValoareScara2() / nrPersoaneScara;


            double enel = tarifFacturaEnelPePersoana * user.getNrPersoane();
            listaPlata.setEnel(enel);

            double tarifFacturaSuezPePersoana = facturaSuez.getValoareScara2() / nrPersoaneScara;


            double gaze = tarifFacturaSuezPePersoana * user.getNrPersoane();
            listaPlata.setGaze(gaze);
        }

        if(user.getScara() == SCARA_3) {
            double nrPersoaneScara = locatari.stream().filter(locatar -> locatar.getScara() == SCARA_3).mapToInt(User::getNrPersoane).sum();

            double tarifFacturaEnelPePersoana = facturaEnel.getValoareScara3() / nrPersoaneScara;

            double enel = tarifFacturaEnelPePersoana * user.getNrPersoane();
            listaPlata.setEnel(enel);

            double tarifFacturaSuezPePersoana = facturaSuez.getValoareScara3() / nrPersoaneScara;


            double gaze = tarifFacturaSuezPePersoana * user.getNrPersoane();
            listaPlata.setGaze(gaze);
        }

            double tarifApaRece = facturaApaNova.getTarifApaRece();
            double tarifApaCalda = facturaApaNova.getTarifApaCalda();


            double consumUserApaCalda = 0;
            double consumUserApaRece = 0;

            if(consumLocatari != null) {
                consumUserApaCalda = consumLocatari.getConsumTotalApaCalda();
                consumUserApaRece = consumLocatari.getConsumTotalApaRece();
            }

            //System.out.println(consumUserApaCalda);

            //VALOARE CONSUM TOTAL LUNA CURENTA - VALOARE CONSUM TOTAL LUNA ANTERIOARA
            //DACA E NULL CONSUMUL ANTERIOR => E PRIMA INCARCARE DECI RAMANE ASTA
            //DACA CONSUMUL ACTUAL = CONSUMUL ANTERIOR => ATUNCI PUNEM CONSUMUL INREGISTRAT LUNA ANTERIOARA IN LISTA DE PLATA


            ConsumLocatari consumUserLunaAnterioara = consumLocatariService.getConsumByLunaAnUser(""+dataActuala.minusMonths(1).getMonthValue(),""+dataActuala.minusMonths(1).getYear(),user);

            if(consumUserLunaAnterioara != null) {
                double apaRece = (consumUserLunaAnterioara.getConsumTotalApaRece() - consumUserApaRece) * tarifApaRece;
                double apaCalda = (consumUserLunaAnterioara.getConsumTotalApaCalda() - consumUserApaCalda) * tarifApaCalda;
                listaPlata.setApaRece(apaRece);
                listaPlata.setApaCalda(apaCalda);
            }
            else{
                double apaRece = consumUserApaRece * tarifApaRece;
                double apaCalda = consumUserApaCalda * tarifApaCalda;
                listaPlata.setApaRece(apaRece);
                listaPlata.setApaCalda(apaCalda);
            }





            double cheltuieliComunePeCotaIndiviza = 0;
            double cheltuieliRepartizatePeApartament = 0;
            double cheltuieliRepratizatePeNrPersoane = 0;

            //cheltuieli
            for(Cheltuiala cheltuiala : cheltuieliLunare){
                if(cheltuiala.getModDeCalcul() == 0){
                    cheltuieliComunePeCotaIndiviza += user.getCotaIndiviza()/ BLOC_COTA_INDIVIZA  * cheltuiala.getValoare();
                }
                if(cheltuiala.getModDeCalcul() == 1){
                    cheltuieliRepratizatePeNrPersoane += cheltuiala.getValoare() /  numarPersoaneBloc * user.getNrPersoane();
                }
                if(cheltuiala.getModDeCalcul() == 2){
                    cheltuieliRepartizatePeApartament += cheltuiala.getValoare() / numarApartamente;
                }
            }


            listaPlata.setCheltuieliComunePeCotaIndiviza(cheltuieliComunePeCotaIndiviza);
            listaPlata.setCheltuieliRepartizatePeNumarDePersoane(cheltuieliRepratizatePeNrPersoane);
            listaPlata.setCheltuieliRepartizatePeApartament(cheltuieliRepartizatePeApartament);

            double restante = 0;

            ListaPlata listaPlataLunaAnterioara = listaPlataDao.findByUserAndLunaAndAn(user,String.valueOf(dataActuala.minusMonths(1).getMonthValue()),String.valueOf(dataActuala.minusMonths(1).getYear()));
            if(listaPlataLunaAnterioara != null){
                Plata plata = plataService.getPlataByListaPlata(listaPlataLunaAnterioara.getId());
                if(plata == null){
                    restante = listaPlataLunaAnterioara.getTotalPlata();
                }
            }

            listaPlata.setRestanteInteretinere(restante);
            listaPlata.setTotalPlata();

            System.out.println("LISTA PLATA!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(listaPlata);
            listaPlataDao.save(listaPlata);



    }

    public void createListaPlataBloc(int numarBloc){
        userService.getUsersByBloc(numarBloc).stream().filter(user -> user.getApartament()!=0).forEach(user -> createLista(numarBloc,user.getApartament()));
    }
    public ListaPlata getListaPlataLuna(int userId){
        User user = userService.getUserById(userId);
        System.out.println(user);
        ListaPlata listaPlata = listaPlataDao.findByUserAndLunaAndAn(user,String.valueOf(LocalDate.now().minusMonths(1).getMonthValue()),String.valueOf(LocalDate.now().minusMonths(1).getYear()));
        System.out.println(listaPlata);
        return listaPlata;
    }

    public ListaPlata getListaPlataById(int listaPlataId) {
        return listaPlataDao.findById(listaPlataId).get();
    }

    public List<ListaPlata> getAllListaPlata(int numarBloc) {
        List<ListaPlata> listaPlati = listaPlataDao.findByLunaAndAn(String.valueOf(LocalDate.now().minusMonths(1).getMonthValue()),String.valueOf(LocalDate.now().minusMonths(1).getYear()));
        listaPlati = listaPlati.stream().filter(listaPlata -> listaPlata.getUser().getBloc().getNumarBloc() == numarBloc).collect(Collectors.toList());
        return listaPlati;
    }
}
