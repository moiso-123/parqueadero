package co.edu.uniquindio.poo;

import java.util.HashMap;
import java.util.Map;

public enum tipoVehiculo 
{
    CARRO(1),
    MOTOHIDRIDO(2),
    MOTOCLASICA(3);

    private int id;
    private static final Map<Integer, tipoVehiculo> MAP = new HashMap<>();
    private tipoVehiculo(int id) { this.id = id; }
    public int getId() { return id; }
    public static tipoVehiculo fromId(int id){
        return MAP.get(id);
    }
    static{
        for(tipoVehiculo n : values()){
            MAP.put(n.getId(), n);
        }
    }
    public void setId(int id) {
        this.id = id;
    }
    
}

