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


    @GetMapping("/{numarBloc}")
    public ResponseEntity getAllFacturiApaNova(@PathVariable int numarBloc){
        return ResponseEntity.ok(facturaSuezService.getAllFacturiSuez(numarBloc));
    }

    @PostMapping("create/{numarBloc}")
    public ResponseEntity createFacturaApaNova(@RequestBody FacturaSuez facturaSuez, @PathVariable int numarBloc){
        try {
            facturaSuezService.createFactura(facturaSuez,numarBloc);
            return ResponseEntity.ok(true);
        }catch (Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
