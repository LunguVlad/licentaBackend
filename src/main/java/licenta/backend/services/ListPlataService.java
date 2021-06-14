package licenta.backend.services;

import licenta.backend.daos.ListaPlataDao;
import licenta.backend.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

    private final int SCARA_1 = 1;
    private final int SCARA_2 = 2;
    private final int SCARA_3 = 3;

    public void createLista(int apartament){
        ListaPlata listaPlata = new ListaPlata();
        User user = userService.getUserByApartament(apartament);
        listaPlata.setLuna(String.valueOf(LocalDate.now().getMonthValue()));
        listaPlata.setAn(String.valueOf(LocalDate.now().getYear()));
        listaPlata.setUser(user);

        LocalDate dataActuala = LocalDate.now();


        FacturaEnel facturaEnel = facturaEnelService.getFacturaByLunaAndAn(listaPlata.getLuna(), listaPlata.getAn());
        FacturaSuez facturaSuez = facturaSuezService.getFacturaByLunaAndAn(listaPlata.getLuna(),listaPlata.getAn());
        FacturaApaNova facturaApaNova = facturaApaNovaService.getFacturaByLunaAndAn(listaPlata.getLuna(),listaPlata.getAn());
        ConsumLocatari consumLocatari = consumLocatariService.getConsumByLunaAnUser(listaPlata.getLuna(),listaPlata.getAn(),user);

        if(user.getScara() == SCARA_1){
            System.out.println("Am intrat pe if");
            int nrPersoaneScara = userService.getUsersByScara(SCARA_1).stream().mapToInt(User::getNrPersoane).sum();
            System.out.println("NrPERSOANE");
            System.out.println(nrPersoaneScara);
            double tarifFacturaEnelPePersoana = facturaEnel.getValoareScara1() / (double) nrPersoaneScara;
            System.out.println(tarifFacturaEnelPePersoana);

            System.out.println("2nd block");

            double enel = tarifFacturaEnelPePersoana * user.getNrPersoane() + user.getNrPersoane();
            listaPlata.setEnelRebu(enel);

            double tarifFacturaSuezPePersoana = facturaSuez.getValoareScara1() / nrPersoaneScara;

            double gaze = tarifFacturaSuezPePersoana * user.getNrPersoane();
            listaPlata.setGaze(gaze);

            double tarifApaRece = facturaApaNova.getTarifApaRece();
            double tarifApaCalda = facturaApaNova.getTarifApaCalda();

            double consumUserApaCalda = consumLocatari.getConsumTotalApaCalda();
            double consumUserApaRece = consumLocatari.getConsumTotalApaRece();

            //VALOARE CONSUM TOTAL LUNA CURENTA - VALOARE CONSUM TOTAL LUNA ANTERIOARA
            //DACA E NULL CONSUMUL ANTERIOR => E PRIMA INCARCARE DECI RAMANE ASTA
            //DACA CONSUMUL ACTUAL = CONSUMUL ANTERIOR => ATUNCI PUNEM CONSUMUL INREGISTRAT LUNA ANTERIOARA IN LISTA DE PLATA

            System.out.println("Aici sigur ajunge");
            ConsumLocatari consumUserLunaAnterioara = consumLocatariService.getConsumByLunaAnUser(""+dataActuala.minusMonths(1).getMonthValue(),""+dataActuala.minusMonths(1).getYear(),user);
            System.out.println("alo?");
            if(consumUserLunaAnterioara != null) {
                System.out.println("PE IF consum != null");
                double apaRece = consumUserLunaAnterioara.getConsumTotalApaRece() - consumUserApaRece;
                double apaCalda = consumUserLunaAnterioara.getConsumTotalApaCalda() - consumUserApaCalda;
                listaPlata.setApaRece(apaRece);
                listaPlata.setApaCalda(apaCalda);
            }
            else{
                System.out.println("Am intrat pe else");
                double apaRece = consumUserApaRece;
                double apaCalda = consumUserApaCalda;
                listaPlata.setApaRece(apaRece);
                listaPlata.setApaCalda(apaCalda);
            }

            System.out.println(listaPlata);
            //cheltuieli

            listaPlataDao.save(listaPlata);
        }


    }
}
