package com.demo.lambdas.dominio;

import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Cliente {

    private String nombre;
    private String dni;
    private List<Turno> turnos;
    
}
