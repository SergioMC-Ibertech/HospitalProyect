package Hospital;

public class Enfermero implements IFichar{
	
	private String nombre;
	private String apellidos;
	private int dni;
	private String seccion;
	
	public Enfermero(String nombre, String apellidos, int dni, String seccion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.seccion = seccion;
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

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	public Consulta asignarConsulta(Doctor doctor,Paciente paciente) {
		System.out.println("El enfermero "+getNombre()+" de la seccion "+getSeccion()+" lleva a consulta al paciente "+paciente.getNombre()+" "+paciente.getApellidos()+" con el doctor "+doctor.getNombre()+" "+doctor.getApellidos());
		Consulta consulta= new Consulta(doctor, paciente);
		System.out.println("El doctor "+doctor.getNombre()+" atiende a "+paciente.getNombre()+" con sintoma "+paciente.getSintoma());
		return consulta;
	}

	@Override
	public String toString() {
		return "La enfermera "+nombre+" "+apellidos+" de la seccion "+seccion;
	}

	@Override
	public void fichar(String nombre, String apellido, int dni) {
		System.out.println(toString()+" esta trabajando");
	}

	@Override
	public void desfichar(String nombre, String apellido, int dni) {
		System.out.println(toString()+" NO esta trabajando");
	}
	
}
