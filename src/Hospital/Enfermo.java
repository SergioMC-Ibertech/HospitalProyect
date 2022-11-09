package Hospital;

public class Enfermo extends Paciente{

	private String nombre;
	private String apellidos;
	private int dni;
	private String enfermedad;
	
	public Enfermo(String nombre, String apellidos, int dni, String enfermedad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.enfermedad = enfermedad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	@Override
	public String toString() {
		return "el Enfermo "+nombre+" "+apellidos+ " con dni "+dni+" por la enfermedad de "+enfermedad;
	}
	
	

}
