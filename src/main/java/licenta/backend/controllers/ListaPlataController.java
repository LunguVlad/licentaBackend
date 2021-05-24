package licenta.backend.controllers;

import licenta.backend.models.ConsumLocatari;
import licenta.backend.models.ListaPlata;
import licenta.backend.services.ListPlataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("listaPlata")
public class ListaPlataController {

    @Autowired
    private ListPlataService listaPlataService;

    @PostMapping("/create/{apartament}")
    public ResponseEntity createFacturaApaNova(@PathVariable Integer apartament){
        try {
            listaPlataService.createLista(apartament);
            return ResponseEntity.ok(true);
        }catch (Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
