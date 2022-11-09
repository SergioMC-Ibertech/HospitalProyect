package Hospital;

public class Doctor implements IFichar{

	private String nombre;
	private String apellidos;
	private int dni;
	private String especialidad;
	
	public Doctor(String nombre, String apellidos, int dni, String especialidad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.especialidad = especialidad;
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
	
	public String getEspecialidad() {
		return especialidad;
	}
	
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	@Override
	public String toString() {
		return "El doctor "+nombre+" "+apellidos+" con dni=" +dni+" con especialidad "+especialidad;
	}
	
	@Override
	public void fichar(String nombre, String apellido, int dni) {
		System.out.println(toString()+" esta trabajando");
	}

	@Override
	public void desfichar(String nombre, String apellido, int dni) {
		System.out.println(toString()+" NO esta trabajando");
	}

	public Enfermo diagnosticar(Paciente paciente) {
		Enfermo enfermo=null;
		System.out.println("El doctor "+getNombre()+" "+getApellidos()+" empieza el diagnostico al paciente "+paciente.getNombre()+" con sistemas "+paciente.getSintoma());
		int aleatorio = (int)(Math.random()*10+1);
		System.out.println(aleatorio);
		if (aleatorio > 7) {
			enfermo = new Enfermo(paciente.getNombre(), paciente.getApellidos(), paciente.getDni(), paciente.getSintoma());
			System.out.println("El paciente "+paciente.getNombre()+" "+paciente.getApellidos()+" con dni "+paciente.getDni()+" pasa a estar ingresado");
		}else {
			enfermo = null;
			System.out.println("El paciente "+paciente.getNombre()+" "+paciente.getApellidos()+" con dni "+paciente.getDni()+" no pasa a estar ingresado");
		}
		return enfermo;
	}

}
