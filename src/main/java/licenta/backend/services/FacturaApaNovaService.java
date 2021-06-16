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
    @Autowired
    private BlocService blocService;

    public List<FacturaApaNova> getAllFacturiApaNova(int numarBloc) {
        return facturaApaNovaDao.findAllByBloc(blocService.getBloc(numarBloc));
    }

    public int createFactura(FacturaApaNova factura, int numarBloc) {
        factura.setTarif();
        if (factura.getLuna() == null || factura.getAn() == null) {
            factura.setLuna(String.valueOf(LocalDate.now().getMonthValue()));
            factura.setAn(String.valueOf(LocalDate.now().getYear()));
        }
        factura.setBloc(blocService.getBloc(numarBloc));
        facturaApaNovaDao.save(factura);
        return 1;
    }

    public FacturaApaNova getFacturaByLunaAndAn(String luna, String an) {
        return facturaApaNovaDao.findByLunaAndAn(luna,an);
    }
}
