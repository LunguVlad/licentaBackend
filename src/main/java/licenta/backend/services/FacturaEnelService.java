package licenta.backend.services;

import licenta.backend.daos.FacturaEnelDao;
import licenta.backend.models.Bloc;
import licenta.backend.models.FacturaEnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FacturaEnelService {

    @Autowired
    private FacturaEnelDao facturaEnelDao;

    @Autowired
    private BlocService blocService;

    public List<FacturaEnel> getAllFacturiEnel(int numarBloc) {
        return facturaEnelDao.findAllByBloc(blocService.getBloc(numarBloc));
    }

    public void createFactura(FacturaEnel facturaEnel, int numarBloc) {
        facturaEnel.setValoareTotala();
        if(facturaEnel.getLuna()==null || facturaEnel.getAn()==null) {
            facturaEnel.setLuna(String.valueOf(LocalDate.now().getMonthValue()));
            facturaEnel.setAn(String.valueOf(LocalDate.now().getYear()));
        }
        facturaEnel.setBloc(blocService.getBloc(numarBloc));
        facturaEnelDao.save(facturaEnel);
    }

    public FacturaEnel getFacturaByLunaAndAn(String luna , String an){
        return facturaEnelDao.findByLunaAndAn(luna,an);
    }
}
