package grupo.estudos.ingressoservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statements/tickets")
public class ticketController {

    @PostMapping("/hello")
    public String ticketController() {
        return "HelloWord!";
    }

    @PostMapping("/getStatement")
    public String getStatement() {

        return "getStatement";
    }
}
