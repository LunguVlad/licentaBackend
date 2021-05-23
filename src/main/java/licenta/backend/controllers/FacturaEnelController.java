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


    @GetMapping
    public ResponseEntity getAllFacturiApaNova(){
        return ResponseEntity.ok(facutraEnelService.getAllFacturiEnel());
    }

    @PostMapping("create")
    public ResponseEntity createFacturaApaNova(@RequestBody FacturaEnel facturaEnel){
        try {
            facutraEnelService.createFactura(facturaEnel);
            return ResponseEntity.ok(true);
        }catch (Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
