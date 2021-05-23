package licenta.backend.services;

import licenta.backend.daos.FacturaApaNovaDao;
import licenta.backend.daos.UserDao;
import licenta.backend.models.FacturaApaNova;
import licenta.backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FacturaApaNovaService {
    @Autowired
    FacturaApaNovaDao facturaApaNovaDao;

    public List<FacturaApaNova> getAllFacturiApaNova() {
        List<FacturaApaNova> facturiApaNova = new ArrayList<>();
        facturaApaNovaDao.findAll().forEach(facturaApaNova -> facturiApaNova.add(facturaApaNova));

        return facturiApaNova;
    }

    public int createFactura(FacturaApaNova factura) {
        factura.setTarif();
        factura.setLuna(String.valueOf(LocalDate.now().getMonthValue()));
        factura.setAn(String.valueOf(LocalDate.now().getYear()));
        facturaApaNovaDao.save(factura);
        return 1;
    }

    public FacturaApaNova getFacturaByLunaAndAn(String luna, String an) {
        return facturaApaNovaDao.findByLunaAndAn(luna,an);
    }
}
