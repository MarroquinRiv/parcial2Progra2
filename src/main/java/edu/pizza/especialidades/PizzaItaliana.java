package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

import java.util.ArrayList;
import java.util.List;

public class PizzaItaliana extends Pizza implements PizzaEspecialidad {
    private String salsa;

    public PizzaItaliana(String name, String salsa) {
        super(name); // Llama al constructor de la clase base Pizza
        this.salsa = salsa;
    }

    @Override
    public List<Topping> getToppingsEspeciales() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Topping("Mozzarella", 3.0));
        toppings.add(new Topping("Parmesano", 5.0));
        toppings.add(new Topping("Albahaca", 2.5));
        toppings.add(new Topping("Orégano", 1.75));
        toppings.add(new Topping("Aceitunas", 0.5));
        toppings.add(new Topping("Hongos", 6.0));
        return toppings;
    }

    public String getSalsa() {
        return salsa;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }
}