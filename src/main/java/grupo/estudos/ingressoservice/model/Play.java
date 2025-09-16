package grupo.estudos.ingressoservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Getter
public class Play {
    private String name;
    private String type;

}
