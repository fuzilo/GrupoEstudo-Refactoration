package grupo.estudos.ingressoservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PerformanceDTO {
    private String playID;
    private int audience;
}
