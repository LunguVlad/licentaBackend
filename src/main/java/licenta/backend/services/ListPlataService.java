package licenta.backend.services;

import licenta.backend.daos.ListaPlataDao;
import licenta.backend.models.*;
import org.apache.tomcat.jni.Local;
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
    @Autowired
    private FacturaRebuService facturaRebuService;

    private final int SCARA_1 = 1;
    private final int SCARA_2 = 2;
    private final int SCARA_3 = 3;

    public void createLista(ListaPlata listaPlata, int apartament){
        User user = userService.getUserByApartament(apartament);
        listaPlata.setLuna(String.valueOf(LocalDate.now().getMonthValue()));
        listaPlata.setAn(String.valueOf(LocalDate.now().getYear()));
        listaPlata.setUser(user);

        LocalDate dataActuala = LocalDate.now();


        FacturaEnel facturaEnel = facturaEnelService.getFacturaByLunaAndAn(listaPlata.getLuna(), listaPlata.getAn());
        FacturaSuez facturaSuez = facturaSuezService.getFacturaByLunaAndAn(listaPlata.getLuna(),listaPlata.getAn());
        FacturaApaNova facturaApaNova = facturaApaNovaService.getFacturaByLunaAndAn(listaPlata.getLuna(),listaPlata.getAn());
        ConsumLocatari consumLocatari = consumLocatariService.getConsumByLunaAnUser(listaPlata.getLuna(),listaPlata.getAn(),user);
        FacturaRebu facturaRebu = facturaRebuService.getFacturaByLunaAndAn(listaPlata.getLuna(),listaPlata.getAn());

        if(user.getScara() == SCARA_1){
            int nrPersoaneScara = userService.getUsersByScara(SCARA_1).size();
            double tarifFacturaEnelPePersoana = facturaEnel.getValoareScara1() / nrPersoaneScara;
            double tarifFacturaRebuPePersoana = facturaRebu.getValoarePeLocatar();

            double enelRebu = tarifFacturaEnelPePersoana * user.getNrPersoane() + tarifFacturaRebuPePersoana * user.getNrPersoane();
            listaPlata.setEnelRebu(enelRebu);

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

            ConsumLocatari consumUserLunaAnterioara = consumLocatariService.getConsumByLunaAnUser(""+dataActuala.minusMonths(1).getMonthValue(),""+dataActuala.minusMonths(1).getYear(),user);
        }


    }
}
