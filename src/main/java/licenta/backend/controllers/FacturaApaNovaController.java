package licenta.backend.controllers;


import licenta.backend.models.FacturaApaNova;
import licenta.backend.models.User;
import licenta.backend.services.FacturaApaNovaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/apaNova")
@RestController
public class FacturaApaNovaController {

    @Autowired
    FacturaApaNovaService facturaApaNovaService;

    @GetMapping
    public ResponseEntity getAllFacturiApaNova(){
        return ResponseEntity.ok(facturaApaNovaService.getAllFacturiApaNova());
    }

    @PostMapping("create")
    public ResponseEntity createFacturaApaNova(@RequestBody FacturaApaNova facturaApaNova){
        try {
            facturaApaNovaService.createFactura(facturaApaNova);
            return ResponseEntity.ok(true);
        }catch (Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
