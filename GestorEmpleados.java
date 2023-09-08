import java.io.*;
import java.util.ArrayList;

public class GestorEmpleados {
    private String nombreArchivo;

    public GestorEmpleados(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void guardarEmpleados(ArrayList<EmpleadoEmpresa> empleados) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(nombreArchivo)))) {
            for (EmpleadoEmpresa empleado : empleados) {
                String tipo = empleado.getTipo();
                String nombre = empleado.getNombre();
                String salario = empleado.calcularSalario();
                String linea = tipo + "," + nombre + "," + salario;
                writer.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public ArrayList<EmpleadoEmpresa> cargarEmpleados() {
        ArrayList<EmpleadoEmpresa> empleados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/empleados.csv"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(", ");
                if (partes.length == 3) {
                    String tipo = partes[0];
                    String nombre = partes[1];
                    String salario = partes[2];
                    if(tipo.equals("Empleado Asalariado")){
                        empleados.add(new EmpleadoAsalariado(nombre, salario,10));
                    } else if (tipo.equals("Empleado por Horas")) {
                        empleados.add(new EmpleadoPorHoras(nombre, salario, 50, 16));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo: " + e.getMessage());
        }
        return empleados;
    }
}
