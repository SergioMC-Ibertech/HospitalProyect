package Hospital;

public class Consulta {

	private Doctor doctor;
	private Paciente paciente;
	
	public Consulta(Doctor doctor, Paciente paciente) {
		super();
		this.doctor = doctor;
		this.paciente = paciente;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "doctor "+doctor+" al paciente"+paciente;
	}
	
}
