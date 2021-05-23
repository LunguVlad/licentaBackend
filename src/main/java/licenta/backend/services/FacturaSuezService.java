package licenta.backend.services;

import licenta.backend.daos.FacturaSuezDao;
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
    FacturaSuezDao facturaSuezDao;

    public List<FacturaSuez> getAllFacturiSuez() {
        List<FacturaSuez> facturiSuez = new ArrayList<>();
        facturaSuezDao.findAll().forEach(facturaSuez -> facturiSuez.add(facturaSuez));
        return facturiSuez;
    }

    public void createFactura(FacturaSuez facturaSuez) {
        facturaSuez.setValoareTotala();
        facturaSuez.setLuna(String.valueOf(LocalDate.now().getMonthValue()));
        facturaSuez.setAn(String.valueOf(LocalDate.now().getYear()));
        facturaSuezDao.save(facturaSuez);
    }

    public FacturaSuez getFacturaByLunaAndAn(String luna, String an) {
        return facturaSuezDao.findByLunaAndAn(luna,an);
    }
}
