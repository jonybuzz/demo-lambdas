package com.demo.lambdas;

import com.demo.lambdas.dominio.Cliente;
import com.demo.lambdas.dominio.Operacion;
import com.demo.lambdas.dominio.Turno;
import java.util.ArrayList;
import java.util.List;

public class Turnero {

    private final RepositorioClientes repoClientes = new RepositorioClientes();

    public List<Turno> obtenerTodosLosTurnos() {
        List<Cliente> clientes = repoClientes.obtenerClientes();

        ////// resolver con streams -> map(cliente -> ...) + collect(...)
        ArrayList<Turno> turnos = new ArrayList<>();

        for (Cliente cliente : clientes) {
            turnos.addAll(cliente.getTurnos());
        }
        //////

        return turnos;
    }

    public List<String> obtenerDnisQueSacaronTurnos() {

        List<Cliente> clientes = repoClientes.obtenerClientes();

        ////// resolver con streams -> map(cliente -> ...) + collect(...)
        ArrayList<String> dnis = new ArrayList<>();

        for (Cliente cliente : clientes) {
            dnis.add(cliente.getDni());
        }
        //////

        return dnis;
    }

    public List<Turno> obtenerTurnosDeDnisTerminadosEn(String terminacionDni) {

        List<Cliente> clientes = repoClientes.obtenerClientes();

        ////// resolver con streams -> map(cliente -> dni) + filter(dni->...) + collect(...)
        ArrayList<Turno> turnos = new ArrayList<>();

        for (Cliente cliente : clientes) {

            if (cliente.getDni().endsWith(terminacionDni)) {
                turnos.addAll(cliente.getTurnos());
            }

        }
        //////

        return turnos;
    }

    public List<Cliente> obtenerClientesQueSacaronTurnoPara(Operacion operacion) {

        List<Cliente> clientes = repoClientes.obtenerClientes();

        ////// resolver con streams -> map(cliente -> turnos anyMatch()) + collect(...)
        ArrayList<Cliente> clientesFiltrados = new ArrayList<>();

        for (Cliente cliente : clientes) {

            boolean algunTurnoCumpleCondicion = false;

            for (Turno turnoCliente : cliente.getTurnos()) {
                if (turnoCliente.getOperacion().equals(operacion)) {
                    algunTurnoCumpleCondicion = true;
                    break;
                }
            }

            if (algunTurnoCumpleCondicion) {
                clientesFiltrados.add(cliente);
            }

        }
        //////

        return clientesFiltrados;
    }

}
