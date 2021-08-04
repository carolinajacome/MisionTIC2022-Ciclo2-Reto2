package co.com.misiontic2022.c2.cjacome;

public class Motocicleta extends Vehiculo{
        
    public Motocicleta(String marca, String modelo, Double precioBase) {
        super(marca, modelo, precioBase);
        //TODO Auto-generated constructor stub
    }
    private Integer cilindraje;

    public Motocicleta(String marca, String modelo, Double precioBase, Integer cilindraje) {
        super(marca, modelo, precioBase);
        this.cilindraje = cilindraje;
    }

    public Integer getCilindraje() {
        return cilindraje;
    }

  

    public Double calcularPrecio() {
        var precio = getPrecioBase();
        if (cilindraje >= 200 && cilindraje <= 350) {
            precio += 500_000d;
        } else if (cilindraje >= 351 && cilindraje <= 500) {
            precio += 750_000d;
        } else if (cilindraje > 500) {
            precio += 1_000_000d;
        }
        return precio;
    }

   
    public Double calcularPorcentajeImpuesto() {
        
        return calcularPrecio() > 7_500_000d ? 10d : 0d;
        
    }

 

}
