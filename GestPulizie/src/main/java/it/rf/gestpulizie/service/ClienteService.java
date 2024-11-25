package it.rf.gestpulizie.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.Cliente;
import it.rf.gestpulizie.model.Operaio;
import it.rf.gestpulizie.model.Sede;
import it.rf.gestpulizie.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository cr;
	
	public Optional<Cliente> findById(String cfCliente) {
		return this.cr.findById(cfCliente);
	}
	
	public void addCliente(Cliente c) {
		this.cr.save(c);
	}
	
	public boolean addCliente(Cliente c, String cfCliente) {
		
		Optional<Cliente> clienteTrovato=this.cr.findById(cfCliente);
		
		if(clienteTrovato.isPresent()) {
			return false;
		}
		else {
			cr.save(c);
			return true;
		}
	}
	
	public Boolean deleteCliente(String cfCliente) {
		Optional<Cliente> clienteTrovato=this.cr.findById(cfCliente);
		
		if(clienteTrovato.isPresent()) {
			this.cr.delete(clienteTrovato.get());
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean updateCliente(Cliente c) {
        return cr.save(c) != null;
    }
	
	/*public boolean addCliente(Cliente c, String cfCliente, String userCliente) {
		
		Optional<Cliente> clienteTrovato=this.cr.findByCfOrUser(cfCliente, userCliente);
		
		if(clienteTrovato.isPresent()) {
			return false;
		}
		else {
			cr.save(c);
			return true;
		}
	}*/
	
	public Optional<Cliente> findClienteByNomeAndCognome(String nomeCliente, String cognomeCliente) {
		//Optional<Operaio> opTrovato=this.or.findById(cfOperaio);
		Optional<Cliente> clienteTrovato=cr.findByNomeClienteAndCognomeCliente(nomeCliente, cognomeCliente);
		return clienteTrovato;

	}
	
	public Optional<Cliente> findClienteByUserAndPwd(String username, String pwd) {
		
		return this.cr.findByUsernameAndPwd(username, pwd);

	}
	
	public Optional<Cliente> findCliente(String cfCliente, String nomeCliente, String cognomeCliente) {
		
		Optional<Cliente> clienteTrovato=cr.findByNomeClienteAndCognomeClienteOrCfCliente(nomeCliente, cognomeCliente, cfCliente);
		return clienteTrovato;

	}
	
	public Optional<Cliente> findUserCliente(String username) {
		
		return this.cr.findUserCliente(username);
	}
	
	public Optional<Cliente> findPwdCliente(String password) {
		
		return this.cr.findPwdCliente(password);
	}
	
	public List<Cliente> elencoClienti(){
	
		List<Cliente> elencoClienti=this.cr.findClienti();
		
		return elencoClienti;
	}
	
	
}
