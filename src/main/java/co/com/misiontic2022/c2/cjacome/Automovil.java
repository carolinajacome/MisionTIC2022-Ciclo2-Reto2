package co.com.misiontic2022.c2.cjacome;


public class Automovil extends Vehiculo{
    
    private TipoTransmision transmision;
    private Boolean vidriosElectricos;
    private Boolean aireAcondicionado;

    public Automovil(String marca, String modelo, Double precioBase, TipoTransmision transmision,
            Boolean vidriosElectricos, Boolean aireAcondicionado) {
        super(marca, modelo, precioBase);
        this.transmision = transmision;
        this.vidriosElectricos = vidriosElectricos;
        this.aireAcondicionado = aireAcondicionado;
    }
    
    public TipoTransmision getTransmision() {
        return transmision;
    }

    public void setTransmision(TipoTransmision transmision) {
        this.transmision = transmision;
    }

    public Boolean getVidriosElectricos() {
        return vidriosElectricos;
    }

    public void setVidriosElectricos(Boolean vidriosElectricos) {
        this.vidriosElectricos = vidriosElectricos;
    }

    public Boolean getAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(Boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public Double calcularPrecio() {
        var precio = getPrecioBase();
        if (transmision == TipoTransmision.AUTOMATICA) {
            precio *= 1.05;
        }
        if (vidriosElectricos) {
            precio += 400000d;
        }
        if (aireAcondicionado) {
            precio += 3000000d;
        }

        return precio;
}

    public Double calcularPorcentajeImpuesto() {
        
       // var precio= calcularPrecio();
        return calcularPrecio() > 60_000_000d ?10d : 0d;
        
    }

   
}
