package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

import java.util.ArrayList;
import java.util.List;

public class PizzaMarYTierra extends Pizza implements PizzaEspecialidad {
    private String crema;

    public PizzaMarYTierra(String name, String salsa) {
        super(name); // Llama al constructor de la clase base Pizza
        this.crema = crema;
    }

    @Override
    public List<Topping> getToppingsEspeciales() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Topping("Camarones", 15.0));
        toppings.add(new Topping("Mejillones", 12.65));
        toppings.add(new Topping("Calamares", 20.5));
        toppings.add(new Topping("Cebolla", 1.75));
        toppings.add(new Topping("Perejil", 0.5));
        return toppings;
    }

    public String getCrema() {
        return crema;
    }

    public void setCrema(String crema) {
        this.crema = crema;
    }
}
