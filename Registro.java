package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Registro {
    private Propietario propietario;
    private Vehiculo vehiculo;
    private double tarifa;
    private double totalPagar;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaFinal;

    public Registro(Propietario propietario, Vehiculo vehiculo) {
        this.propietario = propietario;
        this.vehiculo = vehiculo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDateTime fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    @Override
    public String toString() {
        return "Propietario: " + propietario.getCedula() + ", vehiculo: " + vehiculo.getPlaca();
    }
    
}
