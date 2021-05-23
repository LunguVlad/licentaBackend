package licenta.backend.controllers;


import licenta.backend.models.FacturaEnel;
import licenta.backend.models.FacturaSuez;
import licenta.backend.services.FacturaEnelService;
import licenta.backend.services.FacturaSuezService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("suez")
public class FacturaSuezController {

    @Autowired
    FacturaSuezService facturaSuezService;


    @GetMapping
    public ResponseEntity getAllFacturiApaNova(){
        return ResponseEntity.ok(facturaSuezService.getAllFacturiSuez());
    }

    @PostMapping("create")
    public ResponseEntity createFacturaApaNova(@RequestBody FacturaSuez facturaSuez){
        try {
            facturaSuezService.createFactura(facturaSuez);
            return ResponseEntity.ok(true);
        }catch (Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
