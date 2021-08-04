package co.com.misiontic2022.c2.cjacome;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private Date fecha;
    private String cliente;

    private List<Vehiculo> vehiculos;

    public Pedido(Date fecha, String cliente) {
        this.fecha = fecha;
        this.cliente = cliente;
        vehiculos = new ArrayList<>();
    }

    public String getCliente() {
        return cliente;
    }

    public void adicionarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public Integer calcularCantidadVehiculos() {
        return vehiculos.size();
    }

    public Double calcularSubtotal() {
        var subtotal = 0.0;
        for (Vehiculo vehiculo : vehiculos) {
            subtotal += vehiculo.calcularPrecio();
        }

        return subtotal;
    }

    public Double calcularDescuentos() {
        Double descuento = 0.0;
        for (Vehiculo vehiculo : vehiculos) {
            descuento += vehiculo.calcularDescuento(fecha);
        }
       // System.out.println("prueba dcto "+ descuento);
        return descuento;
    }

    public Double calcularImpuestos() {
       Double impuestos = 0.0;
      
       for (Vehiculo vehiculo : vehiculos) { 
         
          var valorImpuesto =vehiculo.calcularPrecio()-vehiculo.calcularDescuento(fecha);
          valorImpuesto*= vehiculo.calcularPorcentajeImpuesto()/100;

          impuestos+=valorImpuesto;
        }
        
        return impuestos;
    }

    public Double calcularTotal() {
        return calcularSubtotal() - calcularDescuentos() + calcularImpuestos();
    }

}