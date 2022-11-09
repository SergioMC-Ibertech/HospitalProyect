package Hospital;

public class Paciente {

	private String nombre;
	private String apellidos;
	private int dni;
	private String sintoma;
	
	public Paciente(String nombre, String apellidos, int dni, String sintoma) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sintoma = sintoma;
	}

	public Paciente() {
		
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

	public String getSintoma() {
		return sintoma;
	}

	public void setSintoma(String sintoma) {
		this.sintoma = sintoma;
	}

	@Override
	public String toString() {
		return "El paciente "+nombre+" "+apellidos+" con dni "+dni+" presentando sintomas de " + sintoma;
	}
	
}
