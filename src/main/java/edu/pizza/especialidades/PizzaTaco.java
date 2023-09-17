package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

import java.util.ArrayList;
import java.util.List;

public class PizzaTaco extends Pizza implements PizzaEspecialidad {
    private String salsaMarineraPicante;

    public PizzaTaco(String name, String salsa) {
        super(name); // Llama al constructor de la clase base Pizza
        this.salsaMarineraPicante = salsaMarineraPicante;
    }

    @Override
    public List<Topping> getToppingsEspeciales() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Topping("Carne", 10.0));
        toppings.add(new Topping("Tomate", 3.0));
        toppings.add(new Topping("Cebolla", 2.5));
        toppings.add(new Topping("Lechuga", 1.75));
        toppings.add(new Topping("Mozzarella", 3.0));
        return toppings;
    }

    public String getsalsaMarineraPicante() {
        return salsaMarineraPicante;
    }

    public void setsalsaMarineraPicante(String salsaMarineraPicante) {
        this.salsaMarineraPicante = salsaMarineraPicante;
    }
}
