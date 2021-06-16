package licenta.backend.controllers;

import licenta.backend.models.FacturaApaNova;
import licenta.backend.models.FacturaEnel;
import licenta.backend.services.FacturaApaNovaService;
import licenta.backend.services.FacturaEnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("enel")
public class FacturaEnelController {

    @Autowired
    FacturaEnelService facutraEnelService;


    @GetMapping("/{numarBloc}")
    public ResponseEntity getAllFacturiApaNova( @PathVariable int numarBloc){
        return ResponseEntity.ok(facutraEnelService.getAllFacturiEnel(numarBloc));
    }

    @PostMapping("create/{numarBloc}")
    public ResponseEntity createFacturaApaNova(@RequestBody FacturaEnel facturaEnel, @PathVariable int numarBloc){
        try {
            facutraEnelService.createFactura(facturaEnel,numarBloc);
            return ResponseEntity.ok(true);
        }catch (Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
