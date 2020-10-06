package com.demo.lambdas;

import com.demo.lambdas.dominio.Cliente;
import static com.demo.lambdas.dominio.Operacion.RETIRAR;
import com.demo.lambdas.dominio.Turno;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class TurneroTests {

    private final Turnero turnero = new Turnero();

    @Test
    public void obtenerTodosLosTurnos() {

        List<Turno> turnosObtenidos = turnero.obtenerTodosLosTurnos();
        System.out.println(turnosObtenidos);
        assertThat(turnosObtenidos).hasSize(6);

    }

    @Test
    public void obtenerDnisQueSacaronTurnos() {

        List<String> dnis = turnero.obtenerDnisQueSacaronTurnos();

        assertThat(dnis).containsExactlyInAnyOrder("10888777", "04333222", "34999000", "39888222");

    }

    @Test
    public void obtenerTurnosDeDnisTerminadosEn_2() {

        List<Turno> turnos = turnero.obtenerTurnosDeDnisTerminadosEn("2");

        assertThat(turnos).extracting("numero").containsExactlyInAnyOrder(2, 3, 6);

    }

    @Test
    public void todosLosClientesTienenTurno() {

        Boolean todosTienenTurno = turnero.todosLosClientesTienenTurno();

        assertThat(todosTienenTurno).isTrue();

    }

    @Test
    public void obtenerClientesQueSacaronTurnoPara_retirar() {

        List<Cliente> clientes = turnero.obtenerClientesQueSacaronTurnoPara(RETIRAR);

        assertThat(clientes).extracting("nombre").containsExactlyInAnyOrder("Elsa", "Lisa");

    }
}
