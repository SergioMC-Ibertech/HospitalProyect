package Hospital;

public class Hospital {
	
	private String nombre;

	public Hospital(String nombre) {
		super();
		this.nombre = nombre;
	}

	public static void main(String[] args) {

		/*
		 * Enunciado: Se desea crear una aplicacion de gestion de pacientes de un hospital
		 * 				Hospital -> Nombre, salaDeEspera, Consultas, Habitaciones
		 * 				Paciente -> Nombre Apellidos, DNI, sintomas
		 * 				Enfermo -> Nombre, Apellidos, DNI, enfermedad
		 * 				Enfermero -> Nombre, Apellidos, DNI, seccion
		 * 					* atenderPaciente() -> Va a coger a un paciente de la sala de espera y lo va a llevar a la consulta
		 * 				Doctor -> Nombre, Apellidos, DNI, especialidad
		 * 					* diagnosticar() -> devolver un enfermo
		 * 				Consulta -> Doctor, Paciente.
		 * 
		 * 				**** Se pide en el MAIN ****
		 * 				Se tiene que generar 4 pacientes y esten en la Sala de Espera
		 * 				Se tiene que generar 2 doctores, que cada uno de ellos en una consulta
		 * 				Se tiene que generar 2 enfermeros, que cogen a los pacientes de la sala de espera y los asignen a una consulta
		 * 				
		 * 				De la consulta a la que se ha asignado el paciente, el doctor le diagnostica, si el paciente esta grave
		 * 				(para averiguarlo se generara un numero aleatorio del 0 al 10) siendo >7 se ingresa al Enfermo en la
		 * 				primera habitacion vacia. 
		 * 
		 * 				Se tiene que crear un metodo fichar(), para los empleados del hospital, que serian enfermeros y los doctores
		 */
		
		Hospital hospital = new Hospital("Hospital Ibertech");
		Doctor[] doctores = hospital.crearDoctores();
		System.out.println();
		hospital.ficharDoctores(doctores);
		System.out.println();
		Enfermero[] enfermeros = hospital.crearEnfermeros();
		System.out.println();
		hospital.ficharEnfermeros(enfermeros);
		System.out.println();
		Paciente[] salaDeEspera = hospital.crearPacientes();
		System.out.println();
		Consulta[] consultas = hospital.gestionConsultas(doctores,salaDeEspera,enfermeros);
		System.out.println();
		Enfermo[] habitaciones = hospital.gestionHabitaciones(consultas,doctores,salaDeEspera);
		// Exponemos las habitaciones
		System.out.println();
		for (int i=0; i<habitaciones.length; i++) {
			if (habitaciones[i]!=null) {
				System.out.println("En la habitacion "+i+" esta "+habitaciones[i].toString());
			}else {
				System.out.println("En la habitacion "+i+" esta vacia");
			}
			
		}
		System.out.println();
		hospital.desficharDoctores(doctores);
		System.out.println();
		hospital.desficharEnfermeros(enfermeros);
		
	}
	
	// Metodo para crear los doctores y fichando
	private Doctor[] crearDoctores() {
		Doctor doctor1 = new Doctor("Sergio", "Toretto", 456123, "Cardiologo");
		Doctor doctor2 = new Doctor("Guillermo", "Toretto", 789465, "Traumatologia");
		Doctor[] doctores = {doctor1, doctor2};
		return doctores;
	}
	
	// Metodo para que fichen los medicos
	private void ficharDoctores(Doctor[] doctores) {
		for (int i=0; i<doctores.length; i++) {
			doctores[i].fichar(doctores[i].getNombre(), doctores[i].getApellidos(), doctores[i].getDni());	
		}
	}
	
	// Metodo para crear los enfermeros
	private Enfermero[] crearEnfermeros() {
		Enfermero enfermero1 = new Enfermero("Antonia", "Delate", 456132, "Urgencias");
		Enfermero enfermero2 = new Enfermero("Nuria", "Belmonte", 789123, "Psiquiatria");
		Enfermero[] enfermeros = {enfermero1,enfermero2};
		enfermero1.fichar(enfermero1.getNombre(), enfermero1.getApellidos(), enfermero1.getDni());
		enfermero2.fichar(enfermero2.getNombre(), enfermero2.getApellidos(), enfermero2.getDni());
		return enfermeros;
	}
	
	// Metodo para que fichen los enfermeros
	private void ficharEnfermeros(Enfermero[] enfermeros) {
		for (int i=0; i<enfermeros.length; i++) {
			enfermeros[i].fichar(enfermeros[i].getNombre(), enfermeros[i].getApellidos(), enfermeros[i].getDni());	
		}
	}
		
	// Metodo para crear los pacientes
	private Paciente[] crearPacientes() {
		Paciente salaDeEspera1 = new Paciente("Dolores", "Fuertes", 132456, "Dolor de tripa");
		Paciente salaDeEspera2 = new Paciente("Estafilo", "Coco", 789123, "No puede mover el brazo");
		Paciente salaDeEspera3 = new Paciente("Sancho", "Panza", 654789, "Migrañas");
		Paciente salaDeEspera4 = new Paciente("Enrique", "Ortega", 321789, "COVID");
		Paciente[] salaDeEspera = {salaDeEspera1,salaDeEspera2,salaDeEspera3,salaDeEspera4};
		System.out.println("En la sala de espera estan los pacientes: \n");
		// Exponemos la sala de espera
		for (Paciente paciente : salaDeEspera) {
			System.out.println(paciente.toString());
		}
		return salaDeEspera;
	}
	
	// Creamos las derivaciones a consultas
	private Consulta[] gestionConsultas(Doctor[] doctores,Paciente[] salaDeEspera,Enfermero[] enfermeros) {
		Consulta[] consultas = new Consulta[4];
		System.out.println();
		for (int i=0; i<consultas.length; i++) {
			int aleatorio=(int)(Math.random()*10+1);
			int personal=aleatorio%2;
			if (consultas[i]==null && personal==0) {
				consultas[i]=enfermeros[personal].asignarConsulta(doctores[personal], salaDeEspera[i]);
			}else if(consultas[i]==null && personal==1) {
				consultas[i]=enfermeros[personal].asignarConsulta(doctores[personal], salaDeEspera[i]);
			}
		}
		System.out.println();
		// Exponemos las consultas
		for (Consulta consulta : consultas) {
			System.out.println(consulta.toString());
		}
		return consultas;
	}
	
	
	// Creamos las habitaciones
	private Enfermo[] gestionHabitaciones(Consulta[] consultas,Doctor[] doctores, Paciente[] pacientes) {
		Enfermo[] habitaciones = new Enfermo[4];
		System.out.println();
		for (int i=0; i<consultas.length; i++) {
			Doctor doctor=consultas[i].getDoctor();
			for (int j=0; j<habitaciones.length; j++) {
				habitaciones[j]=doctor.diagnosticar(pacientes[j]);
			}
		}
		return habitaciones;
	}
	
	// Metodo para que desfichen los medicos
	private void desficharDoctores(Doctor[] doctores) {
		for (Doctor doctor : doctores) {
			doctor.desfichar(doctor.getNombre(), doctor.getApellidos(), doctor.getDni());	
		}
	}
	
	// Metodo para que desfichen los enfermeros
	private void desficharEnfermeros(Enfermero[] enfermeros) {
		for (Enfermero enfermero : enfermeros) {
			enfermero.desfichar(enfermero.getNombre(), enfermero.getApellidos(), enfermero.getDni());	
		}
	}
	
}
