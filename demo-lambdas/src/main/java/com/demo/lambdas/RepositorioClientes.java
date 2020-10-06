package com.demo.lambdas;

import com.demo.lambdas.dominio.Turno;
import com.demo.lambdas.dominio.Cliente;
import static com.demo.lambdas.dominio.Operacion.ALTA_CUENTA;
import static com.demo.lambdas.dominio.Operacion.DEPOSITAR;
import static com.demo.lambdas.dominio.Operacion.RETIRAR;
import static java.time.LocalTime.parse;
import static java.util.Arrays.asList;
import java.util.List;

public class RepositorioClientes {

    public List<Cliente> obtenerClientes() {

        List<Cliente> clientes = asList(
                Cliente.builder()
                        .nombre("Alberto")
                        .dni("10888777")
                        .turnos(asList(Turno.builder()
                                .numero(1)
                                .inicio(parse("10:15"))
                                .fin(parse("10:30"))
                                .operacion(DEPOSITAR)
                                .build()
                        ))
                        .build(),
                Cliente.builder()
                        .nombre("Elsa")
                        .dni("04333222")
                        .turnos(asList(
                                Turno.builder()
                                        .numero(2)
                                        .inicio(parse("10:30"))
                                        .fin(parse("11:30"))
                                        .operacion(DEPOSITAR)
                                        .build(),
                                Turno.builder()
                                        .numero(3)
                                        .inicio(parse("14:30"))
                                        .fin(parse("14:45"))
                                        .operacion(RETIRAR)
                                        .build()
                        ))
                        .build(),
                Cliente.builder()
                        .nombre("Joaquin")
                        .dni("34999000")
                        .turnos(asList(
                                Turno.builder()
                                        .numero(4)
                                        .inicio(parse("10:00"))
                                        .fin(parse("12:00"))
                                        .operacion(ALTA_CUENTA)
                                        .build(),
                                Turno.builder()
                                        .numero(5)
                                        .inicio(parse("14:00"))
                                        .fin(parse("14:15"))
                                        .operacion(DEPOSITAR)
                                        .build()
                        ))
                        .build(),
                Cliente.builder()
                        .nombre("Lisa")
                        .dni("39888222")
                        .turnos(asList(
                                Turno.builder()
                                        .numero(6)
                                        .inicio(parse("12:00"))
                                        .fin(parse("12:15"))
                                        .operacion(RETIRAR)
                                        .build()
                        ))
                        .build()
        );

        return clientes;
    }
}
