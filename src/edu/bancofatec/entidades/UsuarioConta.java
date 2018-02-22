package edu.bancofatec.entidades;

public class UsuarioConta {

	private Long id,idConta,idUsuario;
	
	public UsuarioConta(){}

	public UsuarioConta(Long idConta,Long idUsuario){
		this.idConta=idConta;
		this.idUsuario=idUsuario;
	}
	
	public UsuarioConta(Long id, Long idConta, Long idUsuario) {
		this.id = id;
		this.idConta = idConta;
		this.idUsuario = idUsuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	

	}


