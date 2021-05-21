package licenta.backend.controllers;

import licenta.backend.models.ConsumContorizat;
import licenta.backend.models.ConsumLocatari;
import licenta.backend.services.ConsumContorizatService;
import licenta.backend.services.ConsumLocatariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("consum/locatar")
@RestController
public class ConsumLocatariController {
    @Autowired
    private ConsumLocatariService consumLocatariService;

    @GetMapping
    public ResponseEntity getAllConsumuriLocatari(){
        return ResponseEntity.ok(consumLocatariService.getAllConsumuriLocatari());
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity createFacturaApaNova(@RequestBody ConsumLocatari consumLocatari, @PathVariable Integer userId){
        try {
            consumLocatariService.addConsum(consumLocatari,userId);
            return ResponseEntity.ok(true);
        }catch (Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
