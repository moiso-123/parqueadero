package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class App {
	static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
	static int select = -1; //opción elegida del usuario
	static int num1 = 0, num2 = 0; //Variables

    public static Parqueadero parqueadero;
	
	public static void main(String[] args) {
        
		
		//Mientras la opción elegida sea 0, preguntamos al usuario
		while(select != 0){
			//Try catch para evitar que el programa termine si hay un error
			try{

                //JOptionPane.showConfirmDialog(null, args);
                select = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Elige opción:                      \n1.-" + 
                "Datos del parqueadero              \n2.-" + // opcion 1 datos parqueadero
                "Crear Propietario                  \n3.-" + // opcion 2 Crear usuario
                "Crear vehiculo                     \n4.-" + // opcion 3 crear vehiculo
                "Parquear vehiculo                  \n5.-" + // opcion 4 parquear vehiculo
                "Validar si existe Propietario      \n6.-" + // opcion 5 parquear vehiculo
                "Validar matriz                     \n7.-" + // opcion 6 validar usuario y modificar
                "Retirar vehiculo                   \n8.-" + // opcion 7 validar usuario y modificar
                "x                                  \n0.-" + // salir vehiculo del parqueadero 
                "Salir"
                ));
				//Recoger una variable por consola	
				switch(select){
				case 1: 
					//tamaño de parqueadero
                    
                    int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del parqueadero."));
                    JOptionPane.showMessageDialog(null, "Tamaño del parqueadero: " + n);
                    int carro = Integer.parseInt(JOptionPane.showInputDialog("Cual es el costo por Hora/Carro es: "));
                    int moto = Integer.parseInt(JOptionPane.showInputDialog("El costo por Hora/Moto es: "));
                    JOptionPane.showMessageDialog(null, "El costo por Hora/Moto es: " + moto + " y Carro por Hora/Moto: "+moto);
                    parqueadero = new Parqueadero(n,carro,moto);
					break;
				case 2: 
                    //Crear Propietario
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del propietario.");
                    String cedula = JOptionPane.showInputDialog("Ingrese el cedula del propietario.");
                    String telefono = JOptionPane.showInputDialog("Ingrese el telefono del propietario.");
                    Propietario p = new Propietario(nombre,cedula,telefono);
                    JOptionPane.showMessageDialog(null,"Propietario Nuevo" + p.toString());
                    //Agregar Propietario
                    parqueadero.agregarPropietario(p);
					break;
				case 3:
                    //Crear vehiculo
                    String cedulaC = JOptionPane.showInputDialog("Ingrese la cedula del propietario.");
                    int tipo = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese el tipo de Vehiculo: \n1.-" +
                    "CARRO                    \n2.-" +
                    "MOTO_HIBRIDA             \n3.-"+
                    "MOTO_CLASICA             \n"));
                    String placaC = JOptionPane.showInputDialog("Ingrese la placa del Vehiculo: ");
                    int velocidadC = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la velocidad maxima del vehiculo."));
                    Propietario pC = parqueadero.existePropietario(cedulaC);
                    Vehiculo vehiculo = new Vehiculo(placaC,velocidadC,tipoVehiculo.fromId(tipo),pC);
                    JOptionPane.showMessageDialog(null, vehiculo.toString());
                    //Agregar vehiculo
                    parqueadero.agregarVehiculo(vehiculo);
					break;
				case 4: 
                    // Parquear
                    String placaP = JOptionPane.showInputDialog("Ingrese la Placa del Vehiculo.");
                    String propietarioP = JOptionPane.showInputDialog("Ingrese la cedula del Propietario.");
                    Propietario pP = parqueadero.existePropietario(propietarioP);
                    Vehiculo vehiculoP = parqueadero.validarVehiculoExistente(placaP);
                    if (pP!=null &&vehiculoP!=null) {
                        System.out.println(vehiculoP.toString());
                        if (vehiculoP.getIsParqueado()==false) {
                            if (vehiculoP.getTipoVehiculo().getId()==1) {
                                parqueadero.agregarParqueo(vehiculoP, parqueadero.getTarifaCarro());
                            }
                            parqueadero.agregarParqueo(vehiculoP, parqueadero.getTarifaMoto());
                        }
                    }
                    JOptionPane.showMessageDialog(null, parqueadero.buscarVehiculoAlParqueadero(placaP));
					break;
                case 5: 
                    //modificar usuario
                    String cedulaM = JOptionPane.showInputDialog("Ingrese la cedula del propietario: ");
                    boolean respuesta = parqueadero.validarIdentificacionExistente(cedulaM);
                    System.out.println(parqueadero.validarIdentificacionExistente(cedulaM));
                    if (respuesta == true) 
                    {
                        int opcion = -1;
                        while (opcion!=0) 
                        {
                            opcion = Integer.parseInt(JOptionPane.showInputDialog("Si deseas hacer alguna modificacion escribe 1, de lo contrario 0."));
                                if (opcion == 1) {
                                    System.out.println("Ingrese el nuevo nombre del propietario.");
                                    String nombreM = JOptionPane.showInputDialog("Ingrese el nuevo nombre del propietario.");
                                    String telefonoM = JOptionPane.showInputDialog("Ingrese el nuevo telefono del propietario.");
                                    Propietario p1 = new Propietario(nombreM,cedulaM,telefonoM);
                                    parqueadero.modificarIdentificacionExistente(p1);
                                }
                            JOptionPane.showMessageDialog(null, "El usuario con la cedula: "+ cedulaM +" Existe");
                            parqueadero.existePropietario(cedulaM);
                            break;
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "El propietario no existente");
                    }
                    break;
                case 6:
                    System.out.println("----------------");
                    JOptionPane.showMessageDialog(null,parqueadero.registroLinklink());
                    System.out.println("-----------------------");
                    break;
                case 7:
                //Retirar vehiculo del parqueadero
                    System.out.println("Retirar vehiculo");
                    System.out.println("Ingrese la Placa del Vehiculo.");
                    String placaR = scanner.nextLine();
                    System.out.println("Ingrese la cedula del Propietario.");
                    String propietarioR = scanner.nextLine();
                    Propietario pR = parqueadero.existePropietario(propietarioR);
                    Vehiculo vehiculoR = parqueadero.validarVehiculoExistente(placaR);
                    System.out.println(pR.getNombre());
                    System.out.println(vehiculoR.getPlaca());
                    if (pR!=null &&vehiculoR!=null) {
                        System.out.println(vehiculoR.toString());
                        if (vehiculoR.getIsParqueado()==true) {
                            if (vehiculoR.getTipoVehiculo().getId()==1) {
                                if(parqueadero.buscarVehiculoAlParqueadero(placaR)==true){
                                    Registro auxR = parqueadero.buscarVehiculoParqueado(placaR);
                                    auxR.setFechaFinal(LocalDateTime.now());
                                    int auxTime = auxR.getFechaFinal().getHour()-auxR.getFechaFinal().getHour();
                                    auxR.setTotalPagar(auxR.getTarifa()*auxTime);
                                    parqueadero.modificarRegistro(parqueadero.buscarVehiculoParqueado(placaR));
                                    parqueadero.modificarRegistroList(parqueadero.buscarVehiculoParqueadoList(placaR));
                                    parqueadero.modificarVehiculoList(parqueadero.buscarVehiculoList(placaR));
                                }
                            }
                            parqueadero.agregarParqueo(vehiculoR, parqueadero.getTarifaMoto());
                        }
                    }
                    System.out.println(parqueadero.buscarVehiculoAlParqueadero(placaR));
                    break;
				case 0: 
					JOptionPane.showMessageDialog(null,"Feliz dia :D");
					break;
				default:
                    JOptionPane.showMessageDialog(null,"Número no reconocido. ");
                    break;
				}			
			}catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error :D: " + e.getMessage());
			}
		}
	}
    
}

