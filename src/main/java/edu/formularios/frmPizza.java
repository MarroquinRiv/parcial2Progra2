package edu.formularios;

import edu.pizza.base.Topping;
import edu.pizza.especialidades.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class frmPizza {
    private JPanel jpanelPrincipal;
    private JComboBox<String> comboBoxToppings;
    private JTextField txtPizza;
    private JButton btnAddIngrediente;
    private JLabel lblTotal;
    private JList<String> list1;
    private JButton btnPrepararPizza;
    private JComboBox<String> comboBoxPizza;
    private JRadioButton pequeñaRadioButton;
    private JRadioButton medianaRadioButton;
    private JRadioButton grandeRadioButton;
    int preciofinal = 0;
    private DefaultListModel<String> modeloLista = new DefaultListModel<>();

    private List<Topping> ingredientes = new ArrayList<>();
    private List<PizzaEspecialidad> especialidades = new ArrayList<>();

    public frmPizza() {
        cargarToppings();
        crearEspecialidades();

        DefaultComboBoxModel<String> especialidadesModel = new DefaultComboBoxModel<>();
        especialidadesModel.addElement("Pizza italiana");
        especialidadesModel.addElement("Pizza mar y tierra");
        especialidadesModel.addElement("Pizza taco");
        especialidadesModel.addElement("Pizza de helado");
        especialidadesModel.addElement("Yo la armo");
        comboBoxPizza.setModel(especialidadesModel);

        // Agrega un listener al combo de especialidades para actualizar los toppings disponibles
        comboBoxPizza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String especialidad = (String) comboBoxPizza.getSelectedItem();
                cargarToppingsEspecialidad(especialidad);
                txtPizza.setText(especialidad);
            }
        });

        btnAddIngrediente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Topping ingrediente = (Topping) comboBoxToppings.getSelectedItem();
                if (ingrediente != null) {
                    modeloLista.addElement(ingrediente.getNombre());
                    list1.setModel(modeloLista);
                    actualizarPrecioTotal();
                }
            }
        });

        btnPrepararPizza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list1.getModel().getSize() == 0) {
                    JOptionPane.showMessageDialog(null, "No hay toppings.");
                } else {
                    int indiceEspecialidad = comboBoxPizza.getSelectedIndex();
                    if (indiceEspecialidad >= 0 && indiceEspecialidad < especialidades.size()) {
                        PizzaEspecialidad especialidad = especialidades.get(indiceEspecialidad);
                        /*especialidad.prepare();*/
                    }
                }
            }
        });

        pequeñaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preciofinal = preciofinal;
                medianaRadioButton.setSelected(false);
                grandeRadioButton.setSelected(false);
            }
        });
        medianaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preciofinal = preciofinal + 15;
                lblTotal.setText(String.valueOf(preciofinal));
                pequeñaRadioButton.setSelected(false);
                grandeRadioButton.setSelected(false);
            }
        });
        grandeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preciofinal = preciofinal + 30;
                pequeñaRadioButton.setSelected(false);
                medianaRadioButton.setSelected(false);
            }
        });
    }

    private void cargarToppings() {
        ingredientes.add(new Topping("Tomato", 4.55));
        ingredientes.add(new Topping("Mozzarella", 12.55));
        ingredientes.add(new Topping("Basil", 6.55));
        ingredientes.add(new Topping("Pepperoni", 10.55));
        ingredientes.add(new Topping("Champiñones", 4.55));
        ingredientes.add(new Topping("Cebolla", 5.55));
        ingredientes.add(new Topping("Chorizo", 14.55));

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(ingredientes.stream().map(Topping::getNombre).toArray(String[]::new));
        comboBoxToppings.setModel(model);
    }

    private void crearEspecialidades() {
        especialidades.add(new PizzaItaliana("Pizza italiana", ""));
        especialidades.add(new PizzaMarYTierra("Pizza mar y tierra", ""));
        especialidades.add(new PizzaTaco("Pizza taco", ""));
        especialidades.add(new PizzaDeHelado("Pizza de helado", ""));
        especialidades.add(new PizzaYoLaArmo("Yo la armo", new ArrayList<>()));
    }

    private void cargarToppingsEspecialidad(String especialidad) {
        ingredientes.clear();
        int indiceEspecialidad = comboBoxPizza.getSelectedIndex();
        if (indiceEspecialidad >= 0 && indiceEspecialidad < especialidades.size()) {
            PizzaEspecialidad pizzaEspecialidad = especialidades.get(indiceEspecialidad);
            List<Topping> toppingsEspeciales = pizzaEspecialidad.getToppingsEspeciales();
            ingredientes.addAll(toppingsEspeciales);
        }
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(ingredientes.stream().map(Topping::getNombre).toArray(String[]::new));
        comboBoxToppings.setModel(model);
    }

    private void actualizarPrecioTotal() {
        double total = 0.0;
        for (int i = 0; i < list1.getModel().getSize(); i++) {
            String nombreTopping = list1.getModel().getElementAt(i);
            for (Topping topping : ingredientes) {
                if (topping.getNombre().equals(nombreTopping)) {
                    total += topping.getPrecio();
                    break;
                }
            }
        }
        lblTotal.setText(String.valueOf(total));
    }

    public JPanel getJpanelPrincipal() {
        return jpanelPrincipal;
    }
}