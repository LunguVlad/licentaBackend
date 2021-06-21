package licenta.backend.controllers;

import licenta.backend.models.ConsumContorizat;
import licenta.backend.models.FacturaApaNova;
import licenta.backend.services.ConsumContorizatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/consum/contor")
@RestController
public class ConsumContorizatController {
    @Autowired
    private ConsumContorizatService consumContorizatService;

    @GetMapping("/{numarBloc}")
    public ResponseEntity getAllFacturiApaNova(@PathVariable int numarBloc){
        return ResponseEntity.ok(consumContorizatService.getAllConsumuriContorizate(numarBloc));
    }

    @PostMapping("create/{numarBloc}")
    public ResponseEntity createFacturaApaNova(@RequestBody ConsumContorizat consumContorizat, @PathVariable int numarBloc){
        try {
            consumContorizatService.addConsum(consumContorizat,numarBloc);
            return ResponseEntity.ok(true);
        }catch (Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
