package licenta.backend.controllers;

import com.stripe.Stripe;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import licenta.backend.models.ListaPlata;
import licenta.backend.models.User;
import licenta.backend.services.ListPlataService;
import licenta.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/pay")
@RestController
public class PaymentController {

    @Autowired
    private UserService userService;
    @Autowired
    private ListPlataService listPlataService;

    @PostMapping("/{idListaPlata}")
    public ResponseEntity payIntretinere(@PathVariable int idListaPlata){
        try {
            ListaPlata listaPlata = listPlataService.getListaPlataById(idListaPlata);


            double sumaDePlata =  BigDecimal.valueOf(listaPlata.getTotalPlata()).setScale(2,RoundingMode.HALF_UP).doubleValue();
            sumaDePlata = sumaDePlata * 100;
            int valoare = (int) sumaDePlata + 1;


            Stripe.apiKey = "sk_test_51J7hVyBOtDf8PITt8nfE31yJbcCJxCJaJXP3lpCv4cGfI1vAz26Vph5uNQG3DRY6WrIYEDhrYyp31rQHZ3VDoBFp00KWdL7fZR";
            PaymentIntentCreateParams paymentIntentCreateParams =
                    PaymentIntentCreateParams.builder()
                    .setAmount((long)valoare)
                    .setCurrency("ron")
                    .setReceiptEmail("vladlungu2121@gmail.com")
                    .setDescription("Plata intretinere luna " + listaPlata.getLuna() + " an " +listaPlata.getAn())
                    .build();
            PaymentIntent paymentIntent = PaymentIntent.create(paymentIntentCreateParams);
            String clientSecret = paymentIntent.getClientSecret();
            Map<String,String> response = new HashMap<>();
            response.put("paymentIntent",paymentIntent.getClientSecret());
            return ResponseEntity.ok(response);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
