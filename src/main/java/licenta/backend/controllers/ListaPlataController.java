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

    @PostMapping("/create/{numarBloc}/{apartament}")
    public ResponseEntity createListaPlata(@PathVariable("numarBloc") int numarBloc, @PathVariable("apartament") int apartament){
        try {
            listaPlataService.createLista(numarBloc,apartament);
            return ResponseEntity.ok(true);
        }catch (Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/createListaBloc/{numarBloc}")
    public ResponseEntity createListaPlataBloc(@PathVariable int numarBloc){
        try {
            listaPlataService.createListaPlataBloc(numarBloc);
            return ResponseEntity.ok(true);
        }catch (Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getListaPlata/{userId}")
    public ResponseEntity getListaPlata(@PathVariable int userId){
        try {
            return ResponseEntity.ok(listaPlataService.getListaPlataLuna(userId));
        }catch (Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
