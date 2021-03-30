package licenta.backend.controllers;

import licenta.backend.models.FacturaRebu;
import licenta.backend.models.User;
import licenta.backend.services.FacturaRebuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rebu")
public class FacturaRebuController {
    @Autowired
    private FacturaRebuService facturaRebuService;

    @PostMapping(path = "createFactura")
    public ResponseEntity createFactura(@RequestBody FacturaRebu facturaRebu){
        try {
            System.out.println("DA");
            facturaRebuService.createFactura(facturaRebu);
            return ResponseEntity.ok(true);
        }catch (Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
