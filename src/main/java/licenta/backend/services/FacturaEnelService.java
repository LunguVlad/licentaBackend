package licenta.backend.services;

import licenta.backend.daos.FacturaEnelDao;
import licenta.backend.models.FacturaEnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FacturaEnelService {

    @Autowired
    FacturaEnelDao facturaEnelDao;

    public List<FacturaEnel> getAllFacturiEnel() {
        List<FacturaEnel> facturiEnel = new ArrayList<>();
        facturaEnelDao.findAll().forEach(facturaEnel -> facturiEnel.add(facturaEnel));
        return facturiEnel;
    }

    public void createFactura(FacturaEnel facturaEnel) {
        facturaEnel.setValoareTotala();
        facturaEnel.setLuna(String.valueOf(LocalDate.now().getMonthValue()));
        facturaEnel.setAn(String.valueOf(LocalDate.now().getYear()));

        facturaEnelDao.save(facturaEnel);
    }

    public FacturaEnel getFacturaByLunaAndAn(String luna , String an){
        return facturaEnelDao.findByLunaAndAn(luna,an);
    }
}
