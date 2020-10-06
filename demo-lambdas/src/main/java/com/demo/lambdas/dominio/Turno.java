package com.demo.lambdas.dominio;

import java.time.LocalTime;
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
public class Turno {

    private Integer numero;
    private LocalTime inicio;
    private LocalTime fin;
    private Operacion operacion;
    
}
