package licenta.backend.services;

import licenta.backend.daos.FacturaRebuDao;
import licenta.backend.models.FacturaRebu;
import licenta.backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaRebuService {
    @Autowired
    private FacturaRebuDao facturaRebuDao;
    @Autowired
    private UserService userService;


    public int createFactura(FacturaRebu facturaRebu) {
        System.out.println("SALUT");
        this.calculeazaValoareScariSiLocatar(facturaRebu);
        facturaRebuDao.save(facturaRebu);
        return 1;
    }

    public FacturaRebu calculeazaValoareScariSiLocatar(FacturaRebu facturaRebu){
        final int SCARA1 = 1;
        final int SCARA2 = 2;
        final int SCARA3 = 3;

        int nrPersSc1 = 0;
        int nrPersSc2 = 0;
        int nrPersSc3 = 0;
        int nrPersTot = 0;


        try {

            nrPersSc1 = userService.getUsersByScara(SCARA1).stream().mapToInt(User::getNrPersoane).sum();
            System.out.println(nrPersSc1);
            nrPersSc2 = userService.getUsersByScara(SCARA2).stream().mapToInt(User::getNrPersoane).sum();
            System.out.println(nrPersSc2);
            nrPersSc3 = userService.getUsersByScara(SCARA3).stream().mapToInt(User::getNrPersoane).sum();
            System.out.println(nrPersSc3);
            nrPersTot = nrPersSc1 + nrPersSc2 + nrPersSc3;

            facturaRebu.setValoarePeLocatar(facturaRebu.getValoareTotala()/nrPersTot);
            facturaRebu.setValoareScara1(facturaRebu.getValoarePeLocatar() * nrPersSc1);
            facturaRebu.setValoareScara2(facturaRebu.getValoarePeLocatar() * nrPersSc2);
            facturaRebu.setValoareScara3(facturaRebu.getValoarePeLocatar() * nrPersSc3);

            return facturaRebu;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return facturaRebu;
        }

    }
}
