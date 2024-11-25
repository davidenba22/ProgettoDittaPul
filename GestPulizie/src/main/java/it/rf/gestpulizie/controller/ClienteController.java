package it.rf.gestpulizie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.rf.gestpulizie.model.Cliente;
import it.rf.gestpulizie.model.Operaio;
import it.rf.gestpulizie.repository.OperaioRepository;
import it.rf.gestpulizie.service.ClienteService;
import it.rf.gestpulizie.service.OperaioService;

@RestController
@RequestMapping("/gestCliente")
public class ClienteController {
	
	@Autowired
	public ClienteService cs;
	
	@GetMapping("/ricercaCliente")
	public Cliente findCliente(@RequestParam String cfCliente){
		Optional<Cliente> clTrv=this.cs.findById(cfCliente);
		return clTrv.get();	
	}
	
	@PostMapping("/insCliente")
	public Boolean addCliente(@ModelAttribute Cliente c, @RequestParam String cfCliente){
		Optional<Cliente> clTrv=this.cs.findById(cfCliente);
		
		if(clTrv.isPresent()) {
			return false;
		}
		else {
			this.cs.addCliente(c, cfCliente);
			return true;
		}
	}
	
	@DeleteMapping("/deleteCliente")
	public Boolean deleteCliente(@RequestParam String cfCliente) {
		Optional<Cliente> clTrv=this.cs.findById(cfCliente);
		
		if(clTrv.isPresent()) {
			this.cs.deleteCliente(cfCliente);
			return true;
		}
		else {
			return false;
		}
	}
	
	@PutMapping("/putCliente")
	public Boolean putCliente(@ModelAttribute Cliente c) {
		Optional<Cliente> clTrv=this.cs.findById(c.getCfCliente());
		
		if(clTrv.isPresent()) {
			this.cs.updateCliente(c);
			return true;
		}
		else {
			return false;
		}
	}
	
	@PatchMapping("/patchCliente")
	public Boolean patchCliente(@RequestParam String cfCliente, String cognomeCliente) {
		Optional<Cliente> clTrv=this.cs.findById(cfCliente);
		
		if(clTrv.isPresent()) {
			clTrv.get().setCognomeCliente(cognomeCliente);
			this.cs.updateCliente(clTrv.get());
			return true;
		}
		else {
			return false;
		}
	}
}
