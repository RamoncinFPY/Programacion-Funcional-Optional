package org.ramonfpy.optional.ejemplo.repositorio;

import org.ramonfpy.optional.ejemplo.models.Computador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepositorio implements Repositorio<Computador> {

    private List<Computador> dataSource;

    public ComputadorRepositorio() {
        dataSource = new ArrayList<>();
        dataSource.add(new Computador("Huawei AMD", "Ryzen 5"));
        dataSource.add(new Computador("Apple x", "z1"));
    }

    /*@Override
    public Computador filtrar(String nombre) {
        for (Computador c : dataSource) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }*/

   /* //Implementando el Optional
    @Override
    public Optional<Computador> filtrar(String nombre) {
        for (Computador c : dataSource) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }*/


    @Override
    public Optional<Computador> filtrar(String nombre) {
        return dataSource.stream()
                //.filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .filter(c -> c.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .findFirst();
    }


}
