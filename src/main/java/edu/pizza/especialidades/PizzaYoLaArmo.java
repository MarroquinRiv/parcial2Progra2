package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

import java.util.List;

public class PizzaYoLaArmo extends Pizza implements PizzaEspecialidad{
    private List<Topping> toppingsSeleccionados;

    public PizzaYoLaArmo(String name, List<Topping> toppingsSeleccionados) {
        super(name);
        this.toppingsSeleccionados = toppingsSeleccionados;
    }

    @Override
    public List<Topping> getToppingsEspeciales() {
        return toppingsSeleccionados;
    }
}