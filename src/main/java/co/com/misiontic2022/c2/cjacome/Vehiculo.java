package co.com.misiontic2022.c2.cjacome;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Vehiculo {
    
    protected String marca;
    protected String modelo;
    protected Double precioBase;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public Vehiculo(String marca, String modelo, Double precioBase) {
        this.marca = marca;
        this.modelo = modelo;
        this.precioBase = precioBase;
    }

    public Double calcularDescuento(Date fecha) {
        var cal = GregorianCalendar.getInstance();
        cal.setTime(fecha);
        var mes = cal.get(Calendar.MONTH);

        var desc = 0.0;
        if (marca.equalsIgnoreCase("BMW") && mes == Calendar.JULY) {
            desc= 15;
        }
        else if(mes== Calendar.JUNE && marca.equals("Suzuki")) {
            if (this instanceof Automovil){
                    desc= 10;
                    
            }else if ( this instanceof Motocicleta){
                desc= 5;
            }
        
    }
    return calcularPrecio()* (desc/100);
    }

    public abstract Double calcularPrecio();
    public abstract Double calcularPorcentajeImpuesto();
}
