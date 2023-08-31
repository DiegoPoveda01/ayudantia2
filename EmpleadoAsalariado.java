public class EmpleadoAsalariado extends EmpleadoEmpresa {

	private double bono;

	public EmpleadoAsalariado(String nombre, String salarioBase, double bono) {
		super(nombre, salarioBase);
		this.bono = bono;
	}

	@Override
	public String getTipo() {
		return "Empleado Asalariado";
	}

	@Override
	public String calcularSalario() {
		double salario = Double.parseDouble(getSalarioBase()) + bono;
		return String.format("%.2f", salario);
	}
}
