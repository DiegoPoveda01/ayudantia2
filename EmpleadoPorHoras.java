public class EmpleadoPorHoras extends EmpleadoEmpresa {

	private double horasTrabajadas;
	private double tarifaPorHora;

	public EmpleadoPorHoras(String nombre, String salarioBase, double horasTrabajadas, double tarifaPorHora) {
		super(nombre, salarioBase);
		this.horasTrabajadas = horasTrabajadas;
		this.tarifaPorHora = tarifaPorHora;
	}

	@Override
	public String getTipo() {
		return "Empleado por Horas";
	}

	@Override
	public String calcularSalario() {
		double salario = horasTrabajadas * tarifaPorHora;
		return String.format("%.2f", salario);
	}
}
