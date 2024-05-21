package co.edu.uniquindio.poo;

public class Vehiculo {
    private String placa;
    private int velocidadMax;
    private tipoVehiculo tipoVehiculo;
    private Propietario propietario;
    private Boolean isParqueado;


    public Vehiculo(String placa, int velocidadMax, tipoVehiculo tipoVehiculo,Propietario propietario) {
        this.placa = placa;
        this.velocidadMax = velocidadMax;
        this.tipoVehiculo = tipoVehiculo;
        this.propietario = propietario;
        isParqueado = false;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getVelocidadMax() {
        return velocidadMax;
    }

    public void setVelocidadMax(int velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    public tipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(tipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    
    public Boolean getIsParqueado() {
        return isParqueado;
    }

    public void setIsParqueado(Boolean isParqueado) {
        this.isParqueado = isParqueado;
    }

    @Override
    public String toString() {
        return "Vehiculo [placa=" + placa + ", tipoVehiculo=" + tipoVehiculo + ", propietario=" + propietario
                + ", isParqueado=" + isParqueado + "]";
    }
}
