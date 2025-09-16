package grupo.estudos.ingressoservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayDTO {
    private String name;
    private String type;
}
