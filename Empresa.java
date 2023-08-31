import java.util.ArrayList;

public class Empresa {
	private ArrayList<EmpleadoEmpresa> empleados;

	public Empresa(ArrayList<EmpleadoEmpresa> empleados) {
		this.empleados = empleados;
	}

	public ArrayList<EmpleadoEmpresa> mostrarEmpleados() {
		return empleados;
	}

	public String mostrarSalarios() {
		StringBuilder result = new StringBuilder();
		for (EmpleadoEmpresa empleado : empleados) {
			result.append("Empleado: ").append(empleado.getNombre())
					.append(", Tipo: ").append(empleado.getTipo())
					.append(", Salario: ").append(empleado.calcularSalario())
					.append("\n");
		}
		return result.toString();
	}

	public static void iniciarEmpresa() {
		EmpleadoEmpresa empleadoAsalariado1 = new EmpleadoAsalariado("Diego", "600000", 0);
		EmpleadoEmpresa empleadoAsalariado = new EmpleadoAsalariado("Juan", "750000", 200);
		EmpleadoEmpresa empleadoPorHoras = new EmpleadoPorHoras("María", "0", 50, 16000);


		ArrayList<EmpleadoEmpresa> empleados = new ArrayList<>();
		empleados.add(empleadoAsalariado1);
		empleados.add(empleadoAsalariado);
		empleados.add(empleadoPorHoras);

		Empresa empresa = new Empresa(empleados);

		ArrayList<EmpleadoEmpresa> listaEmpleados = empresa.mostrarEmpleados();
		System.out.println("Lista de Empleados:");
		for (EmpleadoEmpresa empleado : listaEmpleados) {
			System.out.println("Nombre: " + empleado.getNombre());
			System.out.println("Tipo: " + empleado.getTipo());
			System.out.println("Salario: " + empleado.calcularSalario());
			System.out.println("------------");
		}


	}
}