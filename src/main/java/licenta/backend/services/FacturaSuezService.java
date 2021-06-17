package licenta.backend.services;

import licenta.backend.daos.FacturaSuezDao;
import licenta.backend.models.Bloc;
import licenta.backend.models.FacturaEnel;
import licenta.backend.models.FacturaSuez;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FacturaSuezService {

    @Autowired
    private FacturaSuezDao facturaSuezDao;

    @Autowired
    private BlocService blocService;

    public List<FacturaSuez> getAllFacturiSuez(int numarBloc) {
        return facturaSuezDao.findAllByBloc(blocService.getBloc(numarBloc));
    }

    public void createFactura(FacturaSuez facturaSuez, int numarBloc) {
        facturaSuez.setValoareTotala();
        if(facturaSuez.getLuna() == null || facturaSuez.getAn() == null) {
            facturaSuez.setLuna(String.valueOf(LocalDate.now().getMonthValue()));
            facturaSuez.setAn(String.valueOf(LocalDate.now().getYear()));
        }
        facturaSuez.setBloc(blocService.getBloc(numarBloc));
        facturaSuezDao.save(facturaSuez);
    }

    public FacturaSuez getFacturaByLunaAndAn(String luna, String an) {
        return facturaSuezDao.findByLunaAndAn(luna,an);
    }
}
