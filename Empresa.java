import java.util.ArrayList;

public class Empresa {
	private ArrayList<EmpleadoEmpresa> empleados;

	public Empresa(ArrayList<EmpleadoEmpresa> empleados) {
		this.empleados = empleados;
	}

	public ArrayList<EmpleadoEmpresa> mostrarEmpleados() {
		return empleados;
	}

	public static void iniciarEmpresa() {
		EmpleadoEmpresa empleadoAsalariado1 = new EmpleadoAsalariado("Diego", "600000", 0);
		EmpleadoEmpresa empleadoAsalariado = new EmpleadoAsalariado("Juan", "750000", 200);
		EmpleadoEmpresa empleadoPorHoras = new EmpleadoPorHoras("María", "0", 50, 16000);
        EmpleadoEmpresa empleado3 = new EmpleadoAsalariado("J", "900",98);

		ArrayList<EmpleadoEmpresa> empleados = new ArrayList<>();
		empleados.add(empleadoAsalariado1);
		empleados.add(empleadoAsalariado);
		empleados.add(empleadoPorHoras);
		empleados.add(empleado3);

		Empresa empresa = new Empresa(empleados);

		ArrayList<EmpleadoEmpresa> listaEmpleados = empresa.mostrarEmpleados();
		System.out.println("Lista de Empleados:");
		for (EmpleadoEmpresa empleado : listaEmpleados) {
			System.out.println("Nombre: " + empleado.getNombre());
			System.out.println("Tipo: " + empleado.getTipo());
			System.out.println("Salario: " + empleado.calcularSalario());
			System.out.println("------------");
		}
		GestorEmpleados gestor = new GestorEmpleados("src/empleados.csv");

		// Guardar empleados en el archivo CSV
		gestor.guardarEmpleados(empleados);

		// Cargar empleados desde el archivo CSV
		ArrayList<EmpleadoEmpresa> empleadosCargados = gestor.cargarEmpleados();

		// Mostrar los empleados cargados
		if (empleadosCargados.isEmpty()) {
			System.out.println("No se encontraron empleados en el archivo.");
		} else {
			System.out.println("Empleados cargados desde el archivo:");
			for (EmpleadoEmpresa empleado : empleadosCargados) {
				System.out.println("Nombre: " + empleado.getNombre() + ", Tipo: " + empleado.getTipo() + ", Salario: " + empleado.calcularSalario());
			}
		}
	}

}