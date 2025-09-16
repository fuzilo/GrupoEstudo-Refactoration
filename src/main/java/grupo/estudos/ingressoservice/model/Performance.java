package grupo.estudos.ingressoservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Performance {
    private String playID;
    private int audience;
}
