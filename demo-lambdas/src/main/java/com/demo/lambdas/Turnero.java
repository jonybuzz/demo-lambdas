package com.demo.lambdas;

import com.demo.lambdas.dominio.Cliente;
import com.demo.lambdas.dominio.Operacion;
import com.demo.lambdas.dominio.Turno;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class Turnero {

    private final RepositorioClientes repoClientes = new RepositorioClientes();

    public List<Turno> obtenerTodosLosTurnos() {
        List<Cliente> clientes = repoClientes.obtenerClientes();

        ////// resolver con streams
        List<Turno> turnos = clientes.stream()
                .flatMap(c -> c.getTurnos().stream())
                .collect(toList());
        //////

        return turnos;
    }

    public List<String> obtenerDnisQueSacaronTurnos() {

        List<Cliente> clientes = repoClientes.obtenerClientes();

        ////// resolver con streams
        List<String> dnis = clientes.stream()
                .map(c -> c.getDni())
                .collect(toList());
        //////

        return dnis;
    }

    public List<Turno> obtenerTurnosDeDnisTerminadosEn(String terminacionDni) {

        List<Cliente> clientes = repoClientes.obtenerClientes();

        ////// resolver con streams
        List<Turno> turnos = clientes.stream()
                .filter(c -> c.getDni().endsWith(terminacionDni))
                .flatMap(c -> c.getTurnos().stream())
                .collect(toList());
        //////

        return turnos;
    }

    public Boolean todosLosClientesTienenTurno() {

        List<Cliente> clientes = repoClientes.obtenerClientes();

        ////// resolver con streams
        boolean todosTienenTurno = clientes.stream()
                .allMatch(c -> !c.getTurnos().isEmpty());
        return todosTienenTurno;
        //////
    }

    public List<Cliente> obtenerClientesQueSacaronTurnoPara(Operacion operacion) {

        List<Cliente> clientes = repoClientes.obtenerClientes();

        ////// resolver con streams
        List<Cliente> clientesFiltrados = clientes.stream()
                .filter(c -> c.getTurnos().stream()
                        .anyMatch(t -> t.getOperacion().equals(operacion)))
                .collect(toList());
        //////

        return clientesFiltrados;
    }

}
