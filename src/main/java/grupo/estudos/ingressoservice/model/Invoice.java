package grupo.estudos.ingressoservice.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class Invoice {
    private String customer;
    private List<Performance> performances;
}
