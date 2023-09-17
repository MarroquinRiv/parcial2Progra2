package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

import java.util.ArrayList;
import java.util.List;

public class PizzaDeHelado extends Pizza implements PizzaEspecialidad {
    private String nutella;

    public PizzaDeHelado(String name, String salsa) {
        super(name); // Llama al constructor de la clase base Pizza
        this.nutella = nutella;
    }

    @Override
    public List<Topping> getToppingsEspeciales() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Topping("HeladoVainilla", 7.0));
        toppings.add(new Topping("HeladoChocolate", 7.0));
        toppings.add(new Topping("Fresas", 5.0));
        toppings.add(new Topping("Brownie", 15.0));
        return toppings;
    }

    public String getNutella() {
        return nutella;
    }

    public void setNutella(String nutella) {
        this.nutella = nutella;
    }
}
