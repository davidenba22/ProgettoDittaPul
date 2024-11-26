package it.rf.gestpulizie.controller;

import java.nio.file.spi.FileSystemProvider;


import java.sql.Date;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.rf.gestpulizie.DTO.datiLavDTO;
import it.rf.gestpulizie.DTO.serviziDiLavDTO;
import it.rf.gestpulizie.model.AppSede;
import it.rf.gestpulizie.model.CategoriaOperaio;
import it.rf.gestpulizie.model.Operaio;
import it.rf.gestpulizie.model.Squadra;
import it.rf.gestpulizie.model.eFormata;
import it.rf.gestpulizie.model.Cliente;
import it.rf.gestpulizie.model.Comprende;
import it.rf.gestpulizie.model.Esegue;
import it.rf.gestpulizie.model.Lavorazione;
import it.rf.gestpulizie.model.Sede;
import it.rf.gestpulizie.model.Servizio;
import it.rf.gestpulizie.service.CategoriaOperaioService;
import it.rf.gestpulizie.service.ClienteService;
import it.rf.gestpulizie.service.ComprendeService;
import it.rf.gestpulizie.service.EsegueService;
import it.rf.gestpulizie.service.LavorazioneService;
import it.rf.gestpulizie.service.OperaioService;
import it.rf.gestpulizie.service.SquadraService;
import it.rf.gestpulizie.service.SedeService;
import it.rf.gestpulizie.service.ServizioService;
import it.rf.gestpulizie.service.AppSedeService;
import it.rf.gestpulizie.service.eFormataService;

@Controller
public class MainController {
	
	@Autowired
	private OperaioService os;
	@Autowired
	private CategoriaOperaioService cos;
	@Autowired
	private SquadraService ss;
	@Autowired
	private ClienteService cs;
	@Autowired
	private SedeService sedeS;
	@Autowired
	private eFormataService efs;
	@Autowired
	private AppSedeService aps;
	@Autowired
	private EsegueService eseS;
	@Autowired
	private LavorazioneService lavServ;
	@Autowired
	private ServizioService servService;
	@Autowired
	private ComprendeService comServ;

	
	
	@GetMapping("/Admin")
    public String Admin() {
        return "Admin";
	}
	
	@GetMapping("/Login")
    public String Login() {
        return "Login";
	}
	
	@GetMapping("/Logout")
    public String Logoutt(HttpSession session) {
		session.invalidate();		
        return "Login";
	}
	
	
	@GetMapping("/areaUser")
    public String areaCliente() {
        return "areaCliente";
	}
	
	
	@PostMapping("/areaCliente")
    public String loginAreaCliente(Model x, @RequestParam String username, String password, HttpSession session) {
	
		Optional<Cliente> clienteTrovato=this.cs.findClienteByUserAndPwd(username, password);
		
		if(clienteTrovato.isPresent()) {
			session.setAttribute("ClienteLoggato", clienteTrovato.get());
			return "sezioneCliente";
		}
		else {
			x.addAttribute("MessaggioErrore", "Username o Password Errati");
			return "areaCliente";
		}
	}
	
	
	@GetMapping("/registrazioneAreaRiservata")
	public String registrazioneAreaRiservata(Model x){

		return "registrazioneAreaRiservata";
	}
	
	
	@PostMapping("/registrazioneAreaRiservata")
	public String registrAreaRiservata(Model x, @ModelAttribute Operaio op, @RequestParam String cfOperaio){

		boolean esito;
		Optional<Operaio> userOpTrv=this.os.findUserOperaio(op.getUserOperaio());
        Optional<Operaio> pwdOpTrv=this.os.findPwdOperaio(op.getPwdOperaio());
		
		if(userOpTrv.isPresent()) {
        	x.addAttribute("erroreUsername","Username non disponibile");
        	return "registrazioneAreaRiservata";
        }
        else if(pwdOpTrv.isPresent()) {
        	x.addAttribute("errorePassword","Password non disponibile");
        	return "registrazioneAreaRiservata";
        }
        else {
        	esito=this.os.inserisciOperaio(op, cfOperaio);   
            
    		if(esito==false) {
    			x.addAttribute("erroreCf", "Codice Fiscale già inserito");
    			return "registrazioneAreaRiservata";
    		}
    		else {
    			//this.os.aggiornaOperaio(op);
    			x.addAttribute("MessaggioIns", "Operaio registrato correttamente");
    			return "registrazioneAreaRiservata";
    		}
        }
		
	}
	
	
	@GetMapping("/registrazioneCliente")
	public String registrationCliente(){
		return "registrazioneCliente";
	}
	
	
	@PostMapping("/registrazioneCliente")
	public String registrazioneCliente(Model x, @ModelAttribute Cliente c, Sede s, @RequestParam String cfCliente) {
		
		boolean esito;
		Optional<Cliente> userClTrv=this.cs.findUserCliente(c.getUserCliente());
		Optional<Cliente> pwdClTrv=this.cs.findPwdCliente(c.getPwdCliente());
		
		if(userClTrv.isPresent()) {
        	x.addAttribute("erroreUsername","Username non disponibile");
        	return "registrazioneCliente";
        }
        else if(pwdClTrv.isPresent()) {
        	x.addAttribute("errorePassword","Password non disponibile");
        	return "registrazioneCliente";
        }
        else {
        	esito=this.cs.addCliente(c, cfCliente);   
            
    		if(esito==false) {
    			x.addAttribute("erroreCf", "Codice Fiscale già inserito");
    			return "registrazioneCliente";
    		}
    		else {
    			this.sedeS.addSede(s);
    			x.addAttribute("MessaggioIns", "Cliente e Sedi inseriti correttamente");
    			return "registrazioneCliente";
    		}
        }
	}
	
	
	@GetMapping("/areaPrivata")
    public String areaPrivata() {
        return "areaRiservata";
	}
	
	
	@PostMapping("/areaRiservata")
    public String loginAreaRiservata(Model x, @RequestParam String username, String password, HttpSession session) {
		
		Optional<Operaio> opTrovato=this.os.ricercaOperaioByUserAndPwd(username, password);

		if(opTrovato.isPresent()) {
			
			CategoriaOperaio opTrv=(CategoriaOperaio) opTrovato.get().getOpCat();
			if(opTrv.getIdCategoria() == 1) {
				session.setAttribute("OperaioLoggato", opTrovato.get());
				return "Admin";
			}
			else{
				session.setAttribute("OperaioLoggato", opTrovato);
				return "sezioneOperai";
			}
		}
		else {
			x.addAttribute("credenzialiErrate", "Username o Password Errati");
			return "areaRiservata";
		}
	}
	
	
	//--------------AREA OPERAI---------------------
	@GetMapping("/sezioneOperai")
    public String sezioneOperai(HttpSession session) {
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
		return "sezioneOperai";
	}
	
	
	@GetMapping("/ricIntervOp")
    public String ricIntervOp(HttpSession session) {
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
        return "ricercaInterventiOperaio";
	}
	
	@PostMapping("/ricercaInterventiOperaio")
    public String ricInterventiOp(Model x, @RequestParam Date dataInizioPeriodo, Date dataFinePeriodo, HttpSession session) {
		Optional<Operaio> op=(Optional<Operaio>)session.getAttribute("OperaioLoggato");
		List<datiLavDTO> elencoLavPeriodoScelto=this.comServ.elencoInterventiPeriodoDiTempo(dataInizioPeriodo, dataFinePeriodo, op.get());
		
		if(elencoLavPeriodoScelto.size() == 0) {
			x.addAttribute("elencoVuoto","In questo periodo non c'è stato alcun intervento");
			return "ricercaInterventiOperaio";
		}
		else {
			x.addAttribute("elencoLavPeriodoScelto",elencoLavPeriodoScelto);
			return "ricercaInterventiOperaio";
		}
	}
	
	@PostMapping("/servIntervTrovato")
	public String serviziIntervTrovato(Model x, @RequestParam Long idLavorazione) {
		
		List<Servizio> elencoServIntervTrv=this.servService.findServizioById(idLavorazione);
		
		x.addAttribute("elencoServIntervTrv", elencoServIntervTrv);
		
		return "serviziInterventoTrovato";
	}
	
	@GetMapping("/interventiOp")
    public String interventiOperaio(HttpSession session) {
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "interventiOperaio";
	}
	
	
	
	@PostMapping("/interventiOperaio")
    public String getInterventiOperaio(Model x, @RequestParam Date dataDaRic, HttpSession session) {
		
		Optional<Operaio> cfOp=(Optional<Operaio>) session.getAttribute("OperaioLoggato");
		
		List<datiLavDTO> elencoInterventiVarieSedi=this.comServ.elencoInterventiVarieSedi(dataDaRic, cfOp.get());
		
		if(elencoInterventiVarieSedi.size() > 0) {
			x.addAttribute("elencoInterventiVarieSedi",elencoInterventiVarieSedi);
			return "interventiOperaio";
		}
		else {
			x.addAttribute("noMatch","Nessun intervento trovato con la data inserita");
			return "interventiOperaio";
		}
	}
	
	
	
	@PostMapping("/gestisciInterventiLavorazione")
	public String gestInterventiLavorazione(Model x, @RequestParam Long idLavorazione, HttpSession sessionLav, HttpSession session) {
		
		Optional<Operaio> op=(Optional<Operaio>) session.getAttribute("OperaioLoggato");
		Lavorazione lavDaEsp=this.lavServ.trovaPerIdLav(idLavorazione).get();
		
		eFormata opEformataTrv=this.efs.findCfOperaioInEformata(op.get().getCfOperaio());
		List<serviziDiLavDTO> elencoServiziSingolaLav=this.comServ.elencoServiziSingolaLavorazione(lavDaEsp.getIdLavorazione(), op.get());
		
		sessionLav.setAttribute("LavOttenuto", lavDaEsp);
		
		x.addAttribute("opEformata",opEformataTrv);
		x.addAttribute("elencoServiziSingolaLav",elencoServiziSingolaLav);
		
		return "gestioneSingolaLavorazione";
	}
	
	
	
	@PostMapping("/spuntaServiziOperaio")
	public String spuntaServOp(Model x,@RequestParam Long idComprende) {
		
		Optional<Comprende> idTrv=(Optional<Comprende>) this.comServ.findById(idComprende);
		
		//Boolean esito=comServ.spuntaServizio();
		
		if(idTrv.isPresent()) {
			Comprende c=new Comprende();
			c.setIdComprende(idTrv.get().getIdComprende());
			c.setFineEsecuzioneServizio(true);
			c.setDataAssociazioneComprende(idTrv.get().getDataAssociazioneComprende());
			c.setLavComprende(idTrv.get().getLavComprende());
			c.setServComprende(idTrv.get().getServComprende());
			c.setNoteComprende(idTrv.get().getNoteComprende());
			this.comServ.salvaComprende(c);
		}
		
		return "interventiOperaio";
	}
	
	
	
	@PostMapping("/spuntaLavoroTerminato")
	public String spuntaLavoroTerminato(Model x, @RequestParam Lavorazione idLavorazioneOttenuto) {
		
		Optional<Esegue> idLavorazioneEsegueTrovato=this.eseS.ricercaByIdLavInEsegue(idLavorazioneOttenuto.getIdLavorazione());
		Esegue es=new Esegue();
		
		if(idLavorazioneEsegueTrovato.isPresent()) {
			
			es.setLvEsegue(idLavorazioneEsegueTrovato.get().getLvEsegue());
			es.setSedeEsegue(idLavorazioneEsegueTrovato.get().getSedeEsegue());
			es.setSqEsegue(idLavorazioneEsegueTrovato.get().getSqEsegue());
			es.setNoteEsecuzione(idLavorazioneEsegueTrovato.get().getNoteEsecuzione());
			es.setDataLavoroEseguito(LocalDate.now());
			es.setCompletato(true);
			es.setIdEsecuzione(idLavorazioneEsegueTrovato.get().getIdEsecuzione());
			this.eseS.addEsegue(es);
		}
		
		return "interventiOperaio";
	}
	
	
	//----------------OPERAIO-------------------
	
	@GetMapping("/Operai")
	public String Operai(HttpSession session) {
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "Operai";
	}
	
	
	
	@GetMapping("/insOp")
    public String insOp(Model x, HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
		List<CategoriaOperaio> elencoCat=this.cos.ElencoCategoria();

		x.addAttribute("elenco", elencoCat);
        return "inserimentoOperaio";
	
	}
	
	
	
	@PostMapping("/inserimentoOperaio")
    public String inserimentoOperaio(Model x, @ModelAttribute Operaio op, @RequestParam String cfOperaio, @RequestParam Long idCategoria) {

		boolean esito;
		
		op.setOpCat(cos.ValoreIdCategoria(idCategoria));
		
        List<CategoriaOperaio> elencoCat=this.cos.ElencoCategoria();//Inserisco tutte le categorie in una lista le quali mi serviranno 
        															//per il menù a tendina nel jsp
        x.addAttribute("elenco", elencoCat);
        
        Optional<Operaio> userOpTrv=this.os.findUserOperaio(op.getUserOperaio());
        Optional<Operaio> pwdOpTrv=this.os.findPwdOperaio(op.getPwdOperaio());
        
        if(userOpTrv.isPresent()) {
        	x.addAttribute("erroreUsername","Username non disponibile");
        	return "inserimentoOperaio";
        }
        else if(pwdOpTrv.isPresent()) {
        	x.addAttribute("errorePassword","Password non disponibile");
        	return "inserimentoOperaio";
        }
        else {
        	
        	esito=this.os.inserisciOperaio(op, cfOperaio);

     		if(esito==false) {
     			x.addAttribute("erroreCf", "Codice Fiscale già inserito");
     			return "inserimentoOperaio";
     		}
     		else {
     			x.addAttribute("Messaggio", "Operaio inserito correttamente");
     			return "inserimentoOperaio";
     		}
        }
        
	}
	
	
	
	@GetMapping("/ricOp")
    public String ricOp(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "ricercaOperaio";
	}
	
	
	
	@PostMapping("/ricercaOperaio")
	public String ricercaOperaio(Model x,@ModelAttribute Operaio op, @RequestParam String cfOperaio, String nomeOperaio, String cognomeOperaio) {
		
		
		if (cfOperaio.isEmpty() && nomeOperaio.isEmpty() && cognomeOperaio.isEmpty()) {
	        x.addAttribute("Messaggio", "Campi vuoti");
	        return "ricercaOperaio"; // Ripristina la view se `cfOperaio` è nullo o vuoto
	    }

	    // Ricerca operaio
		Optional<Operaio> opTrovato = this.os.ricercaOperaio(cfOperaio, nomeOperaio, cognomeOperaio);

	    if (opTrovato.isPresent()) {
	        x.addAttribute("operaioTrovato", opTrovato.get()); 
	        return "ricercaOperaio";
	    } else {
	        x.addAttribute("Messaggio", "Nessuna corrispondenza");
	        return "ricercaOperaio";
	    }
	}
	
	
	
	@GetMapping("/modOp")
	public String modOp(Model x, HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
		return "modificaOperaio";
	}
	

	
	@PostMapping("/modificaOperaio")
    public String ModificaOperaio(Model x,@ModelAttribute Operaio o, @RequestParam String cfOperaio) {
    	
        Optional<Operaio> operaioDaModificare = os.ricercaOperaioCf(cfOperaio);
        
        List<CategoriaOperaio> elencoCat=this.cos.ElencoCategoria();
        x.addAttribute("elenco", elencoCat);
        
        if (operaioDaModificare.isPresent()) {
            x.addAttribute("operaioDaModificare", operaioDaModificare.get());
        } else {
            x.addAttribute("messaggioErrore", "Nessuna corrispondenza con codice fiscale: " + cfOperaio);
        }
        
        return "modificaOperaio"; // Ritorna alla pagina di modifica
    } 
	

	
	@PostMapping("/updateOperaio")
    public String updateOperaio(Model x, @ModelAttribute Operaio o, @RequestParam String cfOperaio, Long idCategoria, Boolean statoOperativita) {
		
        
		//Se non viene aggiornata la categoria, restituisco il valore originale
		if (idCategoria == null) {
	        // Recupera l'operatore dal database per ottenere l'id della categoria esistente
	        Optional<Operaio> operaioEsistente = os.ricercaOperaioCf(cfOperaio);
	        if (operaioEsistente.isPresent()) {
	            o.setOpCat(operaioEsistente.get().getOpCat());
	        } else {
	            x.addAttribute("messaggioErrore", "Errore: l'operaio non esiste.");
	            return "modificaOperaio";
	        }
	    } 
		else {
	        o.setOpCat(cos.ValoreIdCategoria(idCategoria));
	    }
		
		if(statoOperativita == null) {
			o.setStatoOperativita(false);
		}
		else {
			o.setStatoOperativita(true);
		}
		
        boolean aggiornato = os.aggiornaOperaio(o);
        
        if (aggiornato) {
            x.addAttribute("operaioDaModificare", o); // Aggiungi l'operatore aggiornato
            x.addAttribute("opSalvato", "Operaio aggiornato con successo.");
            return "modificaOperaio"; // Ritorna alla pagina di modifica con i dati aggiornati
        } 
        else {
            x.addAttribute("messaggioErrore", "Errore durante l'aggiornamento dell'operaio");
            return "modificaOperaio"; // Ritorna alla pagina di modifica con i dati aggiornati
        }

    }
	

	@PostMapping("/deleteOperaio")
	public String deleteOperaio(Model x, @RequestParam String cfOperaio) {
		
	    // qui ci andiamo a prendere il risultato true o false(nel caso in cui non ha trovato un cf)
	    Boolean eliminato=os.eliminaOperaio(cfOperaio);
	
	    // qui inviamo i messaggi al jsp in base all esito dell eliminazione
	    if (eliminato.equals(true)) {
	        x.addAttribute("messaggioDelete", "Operaio eliminato correttamente.");
	    } else {
	        x.addAttribute("messaggio", "Nessuna corrispondenza");
	    }
	    
	    return "modificaOperaio"; // Nome della pagina JSP di destinazione
	}  
	
	
	//-------------------CATEGORIA---------------------------
	@GetMapping("/Categoria")
    public String Categoria(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "Categoria";
	}
	
	
	
	@GetMapping("/addCat")
    public String addCat(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "aggiungiCategoria";
	}
	
	
	
	@PostMapping("/aggiungiCategoria")
    public String aggiungiCategoria(Model x, @ModelAttribute CategoriaOperaio co) {
		
		Boolean esito;
		
		esito=this.cos.addCategoria(co);
		
		if(esito.equals(true)) {
			x.addAttribute("Messaggio", "Nuova categoria inserita");
		}
		else {
			x.addAttribute("Messaggio", "Qualcosa è andato storto...");
		}
		
        return "aggiungiCategoria";
	}
	
	
	
	@GetMapping("/modCat")
    public String modCat(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "modificaCategoria";
	}
	
	
	
	@PostMapping("/modificaCategoria")
    public String modificaCategoria(Model x, @ModelAttribute CategoriaOperaio co) {
		
		 //La ricerca restituisce un oggetto Optional<Operatore>, che può contenere l'operatore trovato oppure essere vuoto se non esiste alcun operatore con il codice fiscale specificato.
        Optional<CategoriaOperaio> categoriaDaMod = this.cos.ricercaCategoria(co);
        
        if (categoriaDaMod.isPresent()) {
            x.addAttribute("categoriaDaMod", categoriaDaMod.get());
        } else {
            x.addAttribute("messaggioErrore", "Nessuna corrispondenza");
        }
        
        return "modificaCategoria";
	}
	
	
	@PostMapping("/updateCategoria")
    public String updateCategoria(Model x, @ModelAttribute CategoriaOperaio co) {
		
		Optional<CategoriaOperaio> categoriaDaMod = this.cos.ricercaCategoria(co);
		
		co.setIdCategoria(categoriaDaMod.get().getIdCategoria());
		
        Boolean aggiornato = cos.aggiornaCategoria(co);
        
        if (aggiornato.equals(true)) {
            x.addAttribute("categoriaDaMod", co); // Aggiungi l'operatore aggiornato
            x.addAttribute("salvato", "Categoria aggiornata con successo.");
        } else {
            x.addAttribute("messaggioErrore", "Errore durante l'aggiornamento della Categoria");
        }
        
        return "modificaCategoria"; // Ritorna alla pagina di modifica con i dati aggiornati
    }
	
	
	@GetMapping("/ricCat")
    public String ricCat(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "ricercaCategoria";
	
	}
	
	
	@PostMapping("/ricercaCategoria")
    public String findCategoria(Model x, @ModelAttribute CategoriaOperaio co) {
		
		Optional<CategoriaOperaio> catTrovata;
		
		// Ricerca operaio
		catTrovata = this.cos.ricercaCategoria(co);
		
		if (catTrovata.isPresent()) {
	        x.addAttribute("catTrovata", catTrovata.get()); 
	        return "ricercaCategoria";
	    } else {
	        x.addAttribute("Messaggio", "Nessuna corrispondenza");
	        return "ricercaCategoria";
	    }
	}

	
	//---------------SERVIZI---------------------
	@GetMapping("/Servizi")
    public String Servizi(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "Servizi";
	}
	
	
	@GetMapping("/insServ")
    public String insServizio(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "inserimentoServizio";
	}
	
	
	@PostMapping("/inserimentoServizio")
    public String addServizi(Model x, @ModelAttribute Servizio serv) {
		
		Boolean esito;
		
		esito=this.servService.addServizio(serv);
		
		if(esito.equals(true)) {
			x.addAttribute("Messaggio", "Nuovo servizio inserito");
		}
		else {
			x.addAttribute("Messaggio", "Qualcosa è andato storto...");
		}
        return "inserimentoServizio";
	}
	
	
	@GetMapping("/modServ")
    public String modServ(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "modificaServizio";
	}
	
	
	@PostMapping("/modificaServizio")
    public String modificaServizi(Model x, @RequestParam String nomeServizio) {
		
		Optional<Servizio> servDaMod=this.servService.findByNomeServizio(nomeServizio);
		

        if (servDaMod.isPresent()) {
            x.addAttribute("servizioDaMod", servDaMod.get());
            return "modificaServizio";
        } else {
            x.addAttribute("MessaggioErrore", "Nessuna corrispondenza con il servizio: " + nomeServizio);
            return "modificaServizio";
        }
	}
	
	
	@PostMapping("/updateServizio")
    public String updateServizio(Model x, @ModelAttribute Servizio serv) {
		
		Optional<Servizio> servizioDaMod = this.servService.findByNomeServizio(serv.getNomeServizio());
		
		serv.setIdServizio(servizioDaMod.get().getIdServizio());
		
        Boolean aggiornato = servService.updateServizio(serv);
        
        if (aggiornato.equals(true)) {
            x.addAttribute("servizioDaMod", serv); // Aggiungi l'operatore aggiornato
            x.addAttribute("MessaggioUpdate", "Servizio aggiornato con successo.");
            return "modificaServizio";
        } else {
            x.addAttribute("MessaggioUpdate", "Errore durante l'aggiornamento del servizio");
            return "modificaServizio";
        }
    }
	
	
	@PostMapping("/deleteServizio")
	public String deleteServizio(Model x, @RequestParam Long idServizio) {
		
		// qui ci andiamo a prendere il risultato true o false(nel caso in cui non ha trovato un cf)
	    Boolean eliminato=servService.deleteServizio(idServizio);
	
	    // qui inviamo i messaggi al jsp in base all esito dell eliminazione
	    if (eliminato.equals(true)) {
	        x.addAttribute("MessaggioDelete", "Servizio eliminato correttamente.");
	        return "modificaServizio";
	    } else {
	        x.addAttribute("MessaggioDelete", "Nessuna corrispondenza");
	        return "modificaServizio";
	    }
	}
	

	//--------------------PRENOTAZIONI----------------------------
	
	@GetMapping("/Prenotazioni")
	public String Prenotazioni(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
		List<Sede> sediCliente=(List<Sede>) session.getAttribute("elencoSediCliente");
		
		if(sediCliente.size() > 0){
			sediCliente.clear();
			return "aggiungiPrenotazione";
		}
		
        return "Prenotazioni";
	}
	
	
	
	@GetMapping("/addPren")
    public String addPrenotazioni(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
		return "aggiungiPrenotazione";
	}
	
	@PostMapping("/aggiungiPrenotazione")
    public String aggiungiPrenotazione(Model x, @ModelAttribute Esegue es, @RequestParam String nomeCliente, String cognomeCliente, String cfCliente, HttpSession session) {
		
		Optional<Cliente> clTrv=this.cs.findCliente(cfCliente, nomeCliente, cognomeCliente);
		List<Sede> sediClienteTrovato=this.sedeS.findSedeByCfClienteOrNomeAndCognomeCliente(cfCliente, nomeCliente, cognomeCliente);
		
		if(clTrv.isEmpty()) {
			x.addAttribute("nessunClienteTrovato","Nessuna corrispondenza");
			return "aggiungiPrenotazione";
		}

		if(sediClienteTrovato.size() == 0) {
			x.addAttribute("nessunaSedeClienteScelto","Questo cliente non possiede alcuna sede");
			return "aggiungiPrenotazione";
		}
		
		if(clTrv.isPresent()) {
			
			//Sessione utilizzata per potermi passare i dati nel  
			//form successivo a questo (in basso)
			session.setAttribute("clienteTrv", clTrv.get());
			session.setAttribute("elencoSediCliente", sediClienteTrovato);
		}
		
		return "aggiungiPrenotazione";
	}
	
	
	@PostMapping("/sedePrenotazione")
    public String sedePrenotazione(Model x, @ModelAttribute Esegue es, @RequestParam Long sedeCliente, Date dataPrenotazione, String noteEsecuzione, HttpSession session, HttpSession sessionDataEsec) {
		
		List<Squadra> sqDisp=this.ss.findSquadraByDataEsecuzione(dataPrenotazione);
		sessionDataEsec.setAttribute("dataEsec",dataPrenotazione);
		
		if(sqDisp.size() == 0) {
			x.addAttribute("squadreNonDisponibili","In questa data non sono disponibili squadre. Creane una per poter prenotare un intervento");
			return "aggiungiPrenotazione";
		}
		else {
			
			if(sedeCliente != null) {
				
				Lavorazione lv=new Lavorazione();
				
				lv.setDataPrenotazioneLavorazione(LocalDate.now());
				lv.setDataPrevistaEsecuzione(dataPrenotazione);
				lv.setDescrizioneLavorazione(noteEsecuzione);
				
				Cliente clienteTrv=(Cliente)session.getAttribute("clienteTrv");
				x.addAttribute("nomeClienteTrv", clienteTrv.getNomeCliente());
				x.addAttribute("cognomeClienteTrv", clienteTrv.getCognomeCliente());
				
				Sede idSedeTrovato=this.sedeS.findByIdSede(sedeCliente);
				x.addAttribute("sedeTrv", idSedeTrovato.getIdSede());
				x.addAttribute("dataEsecuzione", lv.getDataPrevistaEsecuzione());
				
				Squadra sqFinta=this.ss.findSqFinta();
				
				es.setSedeEsegue(idSedeTrovato);
				es.setSqEsegue(sqFinta);
				
				this.lavServ.addLavorazione(lv);
				
				session.setAttribute("idLav", lv);
				
				es.setLvEsegue(lv);
				es.setNoteEsecuzione(noteEsecuzione);
				this.eseS.addEsegue(es);
				
				session.setAttribute("idSede", idSedeTrovato);
				session.setAttribute("idEsegue", es.getIdEsecuzione());
				x.addAttribute("idLavorazione", lv.getIdLavorazione());
				
			}
		}

        return "aggiungiPrenotazione";
	}
	
	
	@GetMapping("/addServPren")
    public String addServiziPrenotazione(HttpSession session) {	
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "addServiziPrenotazione";
	}
	
	
	@PostMapping("/addServiziPrenotazione")
    public String sceltaServSq(Model x, @RequestParam Date dataEsecuzioneScelta, String idLavScelto) {
		
		List<Servizio> elencoServizi=this.servService.elencoServizi();
		List<Squadra> elencoSqDisp=this.ss.findSquadraByDataEsecuzione(dataEsecuzioneScelta);
		x.addAttribute("idLavScelto",idLavScelto);
		x.addAttribute("elencoSqDisp",elencoSqDisp);
		x.addAttribute("dataEsec", dataEsecuzioneScelta);
		x.addAttribute("elencoServizi",elencoServizi);
		x.addAttribute("Messaggio","Servizi aggiunti");
		
        return "addServiziPrenotazione";
	}
	
	
	@PostMapping("/serviziScelti")
    public String ServiziScelti(Model x, @ModelAttribute Esegue es, @RequestParam List<Long> servScelti, Long idLavScelto, Long squadraScelta, Double acconto, String noteComprende, HttpSession session, HttpSession sessionDataEsec) {
		
		Squadra sqTrv=this.ss.ricercaSquadraById(squadraScelta).get();
		Lavorazione lavTrv=this.lavServ.findByIdLavNoOptional(idLavScelto);
		
		Long idEsegueSession=(Long) session.getAttribute("idEsegue");	
		Sede idSedeScelta=(Sede) session.getAttribute("idSede");
		//Optional<Esegue> idEsegueTrv=this.eseS.ricercaById(idEsegueSession);
		
		int i;
		for(i=0;i<servScelti.size();i++) {
			Comprende com=new Comprende();
			com.setLavComprende(this.lavServ.trovaPerIdLav(idLavScelto).get());
			com.setServComprende(this.servService.trovaServizioPerId(servScelti.get(i)).get());
			com.setDataAssociazioneComprende(LocalDate.now());
			com.setFineEsecuzioneServizio(false);
			com.setNoteComprende(noteComprende);
			es.setLvEsegue(this.lavServ.trovaPerIdLav(idLavScelto).get());
			es.setSedeEsegue(idSedeScelta);
			es.setSqEsegue(sqTrv);
			es.setIdEsecuzione(idEsegueSession);
			
			this.comServ.salvaComprende(com);
		}
		
		//Per ogni servizio eseguo la query sommando i prezzi,
		//altrimenti verrebbe aggiunto il prezzo di un solo servizio
		int j;
		for(j=0;j<servScelti.size();j++) {
			lavTrv.setPrezzoTotale(this.servService.prezzoVendita(idLavScelto));
		}
		
		//Somma della durata dei servizi
		Integer durataServizi=this.servService.totDurataServizi(lavTrv.getIdLavorazione())+30;
		
		//Conta degli operai presenti nella squadra scelta per l'intervento
		Integer totOperaiTrovatiInSquadra=this.efs.countCfOperaioByIdSquadra(sqTrv.getIdSquadra());
		
		//Totale del tempo che impiegherà la squadra per l'intervento 
		Integer tempoTotIntervento=durataServizi*totOperaiTrovatiInSquadra;
		
		//Estraggo i minuti accumulati dalla squadra dagli altri interventi
		Integer minutiAccumulatiSqScelta=sqTrv.getMinutiSquadraAccumulati();
		
		//Variabili utilizzate per eseguire un pre-controllo sulla disponibilità della squadra
		Integer sommaTempTotMinutiSq=minutiAccumulatiSqScelta+tempoTotIntervento;
		//Integer minutiDisponibilitaSq=sqTrv.getTotMinutiSquadra()-minutiAccumulatiSqScelta;
		
		//Se il tempo dell'intervento non rispetta la disponibilità della squadra, avvisiamo l'admin
		if(sommaTempTotMinutiSq>=sqTrv.getTotMinutiSquadra()) {
			Squadra sqFinta=this.ss.findSqFinta();
			Date dataEsec=(Date)sessionDataEsec.getAttribute("dataEsec");
			es.setSqEsegue(sqFinta);
			sqFinta.setDataOperativita(dataEsec);
			lavTrv.setAcconto(acconto);
			this.ss.saveSquadra(sqTrv);
			
			x.addAttribute("messaggioDisponibilitaSq","Il/I Servizio/i scelto/i non garantiscono la disponibilità della squadra scelta");
			x.addAttribute("messaggioDisponibilitaSq2","L'intervento dovrà essere modificato con una squadra disponibile");
			return "aggiungiPrenotazione";
		}
		else {
			sqTrv.setMinutiSquadraAccumulati(tempoTotIntervento+sqTrv.getMinutiSquadraAccumulati());
			this.ss.saveSquadra(sqTrv);
		}
		
		lavTrv.setAcconto(acconto);
		this.eseS.addEsegue(es);
		this.lavServ.addLavorazione(lavTrv);
		x.addAttribute("messaggioPren","Prenotazione avvenuta con successo!");

        return "aggiungiPrenotazione";
	}

	
	@GetMapping("/modPren")
    public String modPren(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "modificaPrenotazione";
	}
	
	
	@PostMapping("/modificaPrenotazione")
    public String modificaPrenotazione(Model x, @RequestParam Date dataDaRic, HttpSession sessionDataDaRic) {
		
		List<datiLavDTO> elencoInterventiVarieSedi=this.comServ.elencoInterventiVarieSedi(dataDaRic);
		List<Squadra> elencoSqDisp=this.ss.findSquadraByDataEsecuzione(dataDaRic);
		//Utilizzata per rimuovere i minuti dalla squadra dell'intervento
		//qualora si rimuovesse un servizio
		sessionDataDaRic.setAttribute("dataDaRic",dataDaRic);
		
		if(elencoInterventiVarieSedi.size()>0) {
			x.addAttribute("elencoInterventiVarieSedi",elencoInterventiVarieSedi);
			x.addAttribute("elencoSqDisp",elencoSqDisp);
			return "modificaPrenotazione";
		}
		else {
			x.addAttribute("NessunaPrenotazione","Nessuna prenotazione per la data inserita");
			return "modificaPrenotazione";
		}
	}
	
	
	@PostMapping("/gestisciPrenotazione")
	public String gestPrenotazione(Model x, @RequestParam Long idLavorazione, Long squadraScelta, HttpSession sessionLavorazione) {
		
		sessionLavorazione.setAttribute("idLavPrenotazione",idLavorazione);
		
		Esegue esTrv=this.eseS.ricercaByIdLavInEsegue(idLavorazione).get();
		
		esTrv.setSqEsegue(this.ss.ricercaSquadraById(squadraScelta).get());
		this.eseS.addEsegue(esTrv);
		
		List<Servizio> elencoServiziNonScelti=this.servService.elencoServiziNonScelti(idLavorazione);
		List<Comprende> serviziSceltiPerIntervento=this.comServ.serviziSceltiPerIntervento(idLavorazione);
		x.addAttribute("elencoServiziNonScelti", elencoServiziNonScelti);
		x.addAttribute("serviziSceltiPerIntervento", serviziSceltiPerIntervento);
		
		return "gestisciPrenotazione";
	}
	
	
	@PostMapping("/deletePrenotazione")
	public String deletePrenotazione(HttpSession sessionLavorazione) {
		
		Long idLav=(Long) sessionLavorazione.getAttribute("idLavPrenotazione");
		
		this.comServ.deleteComprendeByIdLav(idLav);
		this.lavServ.deleteLavorazione(idLav);
		this.eseS.deleteEsegueByIdLav(idLav);
		
		return "gestisciPrenotazione";
	}
	
	
	@PostMapping("/addServizi")
	public String addServizi(Model x, @RequestParam List<Servizio> serviziScelti, String noteServizio, HttpSession sessionLavorazione){
		
		Long idLavPrenotazione=(Long) sessionLavorazione.getAttribute("idLavPrenotazione");
		Long idSqTrv=this.eseS.findSquadraByIdLavInEsegue(idLavPrenotazione);
		
		Squadra sqTrv=this.ss.ricercaSquadraById(idSqTrv).get();
		
		//Estraggo i vari minutaggi per poter effettuare un pre-controllo prima
		//di inserire gli eventuali servizi
		Integer tempMinutiAccumulati=sqTrv.getMinutiSquadraAccumulati();
		Integer sommaMinutiServAggiunti=0;
		int j;
		for(j=0;j<serviziScelti.size();j++) {
			sommaMinutiServAggiunti=sommaMinutiServAggiunti+serviziScelti.get(j).getDurataServizio();
		}
		
		Integer sommaTempMinutiTot=sommaMinutiServAggiunti+tempMinutiAccumulati;
		
		if(sommaTempMinutiTot>=sqTrv.getTotMinutiSquadra()) {
			x.addAttribute("limiteOrarioSuperato","La squadra inerente è ancora disponibile per "+(sqTrv.getTotMinutiSquadra()-sqTrv.getMinutiSquadraAccumulati())+" min."
					+ "Garantisci l'intervento solo con alcuni servizi o cambia squadra");
			return "modificaPrenotazione";
		}
		
		//Lavorazione lavTrv=this.lavServ.findByIdLavNoOptional(idLavPrenotazione);
		
		int i;
		for(i=0;i<serviziScelti.size();i++) {
			Comprende com=new Comprende();
			com.setLavComprende(this.lavServ.findByIdLavNoOptional(idLavPrenotazione));
			com.setNoteComprende(noteServizio);
			com.setServComprende(serviziScelti.get(i));
			com.setDataAssociazioneComprende(LocalDate.now());
			com.setFineEsecuzioneServizio(false);
			this.comServ.salvaComprende(com);
		}
		
		sqTrv.setMinutiSquadraAccumulati(sqTrv.getMinutiSquadraAccumulati()+sommaMinutiServAggiunti);
		this.ss.saveSquadra(sqTrv);
		
		x.addAttribute("prenotazioneAggiornata","Servizi aggiunti correttamente");
		
		return "modificaPrenotazione";
	}
	
	
	@PostMapping("/removeServizio")
	public String removeServizio(Model x, Long servScelto, Integer durataServizio, HttpSession sessionDataDaRic, HttpSession sessionLavorazione) {
		
		Long idLavPrenotazione=(Long) sessionLavorazione.getAttribute("idLavPrenotazione");
		Date dataDaRic=(Date) sessionDataDaRic.getAttribute("dataDaRic");
		
		Long idSqTrv=this.eseS.findSquadraByIdLavInEsegue(idLavPrenotazione);
		Long idServDaEliminare=this.comServ.findIdServizioDaEliminare(servScelto);
		
		//Cerco la squadra inerente alla prenotazione e aggiorno le ore di lavoro accumulate
		Squadra sqTrv=this.ss.ricercaSquadraById(idSqTrv).get();
		Integer minutiAccumulatiAttuali=sqTrv.getMinutiSquadraAccumulati();
		Integer minutiAccumulatiAggiornati=minutiAccumulatiAttuali-durataServizio;
		
		sqTrv.setMinutiSquadraAccumulati(minutiAccumulatiAggiornati);
		this.ss.saveSquadra(sqTrv);
		this.comServ.deleteServizio(idServDaEliminare);
		
		x.addAttribute("servizioRimosso","Servizio rimosso correttamente");
		
		return "modificaPrenotazione";
	}
	
	
	@GetMapping("/ricPren")
    public String ricPren(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "ricercaPrenotazione";
	}
	
	
	@PostMapping("/ricercaPrenotazione")
    public String findPrenotazione(Model x, @RequestParam Date dataPrevistaEsecuzione) {
		
		List<Lavorazione> lavTrv=this.lavServ.findLavorazioneByDataEsecuzione(dataPrevistaEsecuzione);
		
		if(lavTrv != null) {
			int i;
			for(i=0;i<lavTrv.size();i++) {
				List<Servizio>  elencoServTrv=this.servService.findServizioById(lavTrv.get(i).getIdLavorazione());
				x.addAttribute("elencoServTrv",elencoServTrv);
			}
			x.addAttribute("lavorazioneTrovata",lavTrv);
			return "ricercaPrenotazione";
		}
		else {
			x.addAttribute("NoMatch","Nessuna prenotazione trovata per questa data");
			return "ricercaPrenotazione";
		}

	}
	
	
	//------------------SQUADRA------------------------
	
	@GetMapping("/Squadra")
    public String Squadra(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "Squadra";
	}
	
	
	
	@GetMapping("/addSq")
    public String addSq(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "creaSquadra";
	}
	
	
	@PostMapping("/creaSquadra")
    public String creaSquadra(Model x, @ModelAttribute Squadra s, @RequestParam String nomeSquadra, Date dataOperativita, HttpSession session) {
		
		Boolean esito;
		
		esito=this.ss.addSquadra(s, nomeSquadra);
		
		if(esito.equals(true)) {
			
			List<Operaio> elencoDisponibili=this.os.operaiDisp(dataOperativita);
			
			session.setAttribute("dataOp", dataOperativita);
			session.setAttribute("idSquadra", s.getIdSquadra());
			
			//x.addAttribute("idSquadra", s.getIdSquadra());
			x.addAttribute("elencoDisponibili", elencoDisponibili);
			x.addAttribute("esito", true);
			return "creaSquadra";
		}
		else {
			x.addAttribute("Messaggio", "Nome Squadra già utilizzato");
			return "creaSquadra";
		}
	}
	
	
	@PostMapping("/associaSquadra")
    public String associaSquadra(Model model, @RequestParam String[] cfOperaio, String setResp, HttpSession session) {
        Long idSquadra = (Long) session.getAttribute("idSquadra");
        Optional<Squadra> squadra = ss.ricercaSquadraById(idSquadra);
        Squadra squad=squadra.get();
        Boolean responsabileSquadra=false;

        for (String cf : cfOperaio) {
        	Optional<Operaio> operaio = os.ricercaOperaioCf(cf);
        	Operaio oper=operaio.get();
            eFormata eformata = new eFormata();
            
            if(cf.equals(setResp)) {
        		eformata.setResponsabileSquadra(true);
        	}
            else{
            	eformata.setResponsabileSquadra(false);
            }
            //eformata.setResponsabileSquadra(responsabileSquadra);
            eformata.setOpF(oper);
            eformata.setSqFormata(squad);
            eformata.setDataCreazione(LocalDate.now());
            
            efs.addeFormata(eformata);
        }
        
        Integer cfTotaliTrovati=this.efs.countCfOperaioByIdSquadra(squad.getIdSquadra());
        
        Integer sommaMinTotSquadra=cfTotaliTrovati*480;
        squad.setTotMinutiSquadra(sommaMinTotSquadra);
        squad.setMinutiSquadraAccumulati(0);
        ss.saveSquadra(squad);
        
        model.addAttribute("MessaggioIns", "Operai associati alla squadra con successo");
        return "creaSquadra"; 
    }
	
	
	@GetMapping("/modSq")
    public String modSq(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "modificaSquadra";
	}
	
	
	@PostMapping("/modificaSquadra")
    public String modificaSquadra(Model x, @ModelAttribute Squadra s) {
        int i;
        
		Optional<Squadra> squadraDaMod=this.ss.findSquadraByNomeSquadraAndDataEsecuzione(s.getNomeSquadra(), s.getDataOperativita());
		
		if(squadraDaMod.isPresent()) {
			List<Operaio> elencoDisponibili=this.os.operaiDisp(s.getDataOperativita());
			x.addAttribute("MessaggioErrore", "Tutti gli operai sono occupati in questa data");
			x.addAttribute("esito", true);
			x.addAttribute("idSquadraDaMod", squadraDaMod.get().getIdSquadra());
			x.addAttribute("elencoDisp", elencoDisponibili);
		}
		else {
			x.addAttribute("Messaggio", "Nessuna corrispondenza");
		}
		
		
		return "modificaSquadra";
	}
	
	
	@PostMapping("/updateSquadra")
    public String updateSquadra(Model x, @ModelAttribute eFormata ef, @RequestParam String[] cfOperaio, Long squadraDaMod) {
		
		 Optional<Squadra> squadra = ss.ricercaSquadraById(squadraDaMod);
		 LocalDate dataCreazioneSq=efs.ricercaDataCreazioneSquadra(squadraDaMod);
		 Squadra squad=squadra.get();
		
		 for (String cf : cfOperaio) {
	        	Optional<Operaio> operaio = os.ricercaOperaioCf(cf);
	        	Operaio oper=operaio.get();
	            eFormata eformata = new eFormata();
	            
	            eformata.setResponsabileSquadra(false);
	            eformata.setOpF(oper);
	            eformata.setSqFormata(squad);
	            eformata.setDataCreazione(dataCreazioneSq);
	            
	            efs.addeFormata(eformata);
	        }
		 
		 Integer cfTotaliTrovati=this.efs.countCfOperaioByIdSquadra(squad.getIdSquadra());
	        
		 Integer sommaMinTotSquadra=cfTotaliTrovati*480;
		 squad.setTotMinutiSquadra(sommaMinTotSquadra);
		 squad.setMinutiSquadraAccumulati(squadra.get().getMinutiSquadraAccumulati());
		 ss.saveSquadra(squad);
		
		x.addAttribute("MessaggioIns", "Operai aggiunti correttamente");
		
        return "modificaSquadra";
	}
	
	
	
	//-------------CLIENTE--------------------
	@GetMapping("/Cliente")
    public String Cliente(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "Cliente";
	}
	
	
	@GetMapping("/sezioneCliente")
    public String sezioneCliente(HttpSession session) {
		
		Cliente cl=(Cliente) session.getAttribute("ClienteLoggato");
		
		if(cl == null) {
			return "Login";
		}
		
        return "sezioneCliente";
	}
	
	
	@GetMapping("/prenCl")
    public String prenCl(HttpSession session) {
		
		Cliente cl=(Cliente) session.getAttribute("ClienteLoggato");
		
		if(cl == null) {
			return "Login";
		}
		
        return "prenotazioneCliente";
	}
	
	
	@PostMapping("/prenotazioneCliente")
    public String prenotazioneCliente(Model x, @RequestParam Date dataEsecuzione, String descrizioneLavorazione, HttpSession session) {

		
		Lavorazione lv=new Lavorazione();
		
		lv.setDataPrenotazioneLavorazione(LocalDate.now());
		lv.setDataPrevistaEsecuzione(dataEsecuzione);
		lv.setDescrizioneLavorazione(descrizioneLavorazione);
		
		this.lavServ.addLavorazione(lv);
		
		x.addAttribute("idLavCliente", lv.getIdLavorazione());
		Optional<Cliente> clienteLog=(Optional<Cliente>)session.getAttribute("ClienteLoggato");
		
		List<Sede> sediClienteTrovato=this.sedeS.findSedeByCfCliente(clienteLog.get().getCfCliente());
		List<Servizio> elencoServizio=this.servService.elencoServizi();
		x.addAttribute("elencoSediCliente", sediClienteTrovato);
		x.addAttribute("elencoServizi", elencoServizio);
		
        return "prenotazioneCliente";
	}
	
	
	@PostMapping("/insSedeServ")
	public String insSedeServ(Model x, @ModelAttribute Esegue es, @RequestParam List<Long> servScelti, String noteServ, Long idLavCliente, Long sedeScelta, Double acconto, HttpSession session) {

		
		Lavorazione lavTrv=this.lavServ.findByIdLavNoOptional(idLavCliente);
		Squadra sqFinta=this.ss.findSqFinta();
		
		int i;
		for(i=0;i<servScelti.size();i++) {
			Comprende com=new Comprende();
			com.setServComprende(this.servService.trovaServizioPerId(servScelti.get(i)).get());
			com.setNoteComprende(noteServ);
			com.setLavComprende(this.lavServ.trovaPerIdLav(idLavCliente).get());
			com.setDataAssociazioneComprende(LocalDate.now());
			com.setFineEsecuzioneServizio(false);
			es.setLvEsegue(this.lavServ.trovaPerIdLav(idLavCliente).get());
			es.setSqEsegue(sqFinta);
			es.setSedeEsegue(this.sedeS.findByIdSede(sedeScelta));
			this.comServ.salvaComprende(com);
		}
		
		//Per ogni servizio eseguo la query sommando i prezzi,
		//altrimenti verrebbe aggiunto il prezzo di un solo servizio
		int j;
		for(j=0;j<servScelti.size();j++) {
			lavTrv.setPrezzoTotale(this.servService.prezzoVendita(idLavCliente));
		}
		
		lavTrv.setAcconto(acconto);
		this.eseS.addEsegue(es);
		this.lavServ.addLavorazione(lavTrv);
		
		x.addAttribute("confermaPrenotazione","Intervento prenotato correttamente");
		return "prenotazioneCliente";
	}
	
	
	@GetMapping("/addCl")
    public String addCl(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "aggiungiCliente";
	}
	
	
	@PostMapping("/aggiungiCliente")
    public String addCliente(Model x, @ModelAttribute Cliente c, @RequestParam String cfCliente) {
		
		boolean esito;
		Optional<Cliente> userClTrv=this.cs.findUserCliente(c.getUserCliente());
		Optional<Cliente> pwdClTrv=this.cs.findPwdCliente(c.getPwdCliente());
		
		if(userClTrv.isPresent()) {
        	x.addAttribute("erroreUsername","Username non disponibile");
        	return "registrazioneCliente";
        }
        else if(pwdClTrv.isPresent()) {
        	x.addAttribute("errorePassword","Password non disponibile");
        	return "registrazioneCliente";
        }
        else {
        	esito=this.cs.addCliente(c, cfCliente);   
            
    		if(esito==false) {
    			x.addAttribute("erroreCf", "Codice Fiscale già inserito");
    			return "registrazioneCliente";
    		}
    		else {
    			x.addAttribute("MessaggioIns", "Cliente inserito correttamente");
    			return "registrazioneCliente";
    		}
        }
	
	}
	
	
	@GetMapping("/modCl")
    public String modCl(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "modificaCliente";
	}
	
	
	@PostMapping("/modificaCliente")
    public String modificaCliente(Model x, @ModelAttribute Cliente c, @RequestParam String cfCliente, String nomeCliente, String cognomeCliente) {
		
		Optional<Cliente> clienteTrovato;
		
		if (cfCliente.isEmpty() && nomeCliente.isEmpty() && cognomeCliente.isEmpty()) {
	        x.addAttribute("Messaggio", "Campi vuoti");
	        return "modificaCliente"; // Ripristina la view se `cfOperaio` è nullo o vuoto
	    }

	    // Ricerca operaio
		clienteTrovato = this.cs.findCliente(cfCliente, nomeCliente, cognomeCliente);

	    if (clienteTrovato.isPresent()) {
	        x.addAttribute("clienteTrovato", clienteTrovato.get()); 
	        return "modificaCliente";
	    } else {
	        x.addAttribute("Messaggio", "Nessuna corrispondenza");
	        return "modificaCliente";
	    }
		
	}
	
	
	@PostMapping("/updateCliente")
	public String updateCliente(Model x, @ModelAttribute Cliente c) {
		
		Optional<Cliente> clienteDaMod=this.cs.findById(c.getCfCliente());
		
		c.setCfCliente(clienteDaMod.get().getCfCliente());
		
        Boolean aggiornato = cs.updateCliente(c);
        
        if (aggiornato.equals(true)) {
            x.addAttribute("MessaggioUpdate", "Cliente aggiornato con successo.");
            return "modificaCliente";
        } else {
            return "modificaCliente";
        }

	}
	
	
	@GetMapping("/ricCl")
    public String ricCl(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "ricercaCliente";
	}
	
	
	@PostMapping("/ricercaCliente")
    public String findCliente(Model x, @ModelAttribute Cliente c, @RequestParam String cfCliente, String nomeCliente, String cognomeCliente) {
		Optional<Cliente> clienteTrovato;
		
		if (cfCliente.isEmpty() && nomeCliente.isEmpty() && cognomeCliente.isEmpty()) {
	        x.addAttribute("Messaggio", "Campi vuoti");
	        return "ricercaCliente"; // Ripristina la view se `cfOperaio` è nullo o vuoto
	    }

	    // Ricerca operaio
		clienteTrovato = this.cs.findCliente(cfCliente, nomeCliente, cognomeCliente);

	    if (clienteTrovato.isPresent()) {
	        x.addAttribute("clienteTrovato", clienteTrovato.get()); 
	        return "ricercaCliente";
	    } else {
	        x.addAttribute("Messaggio", "Nessuna corrispondenza");
	        return "ricercaCliente";
	    }
	}
	
	
	@GetMapping("/addCont")
	public String addCont(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
		return "creaContratto";
	}
	
	
	@PostMapping("/creaContratto")
	public String createContratto(Model x, @RequestParam String nomeCliente, String cognomeCliente, String cfCliente) {
		
		Optional<Cliente> trv=this.cs.findCliente(cfCliente, nomeCliente, cognomeCliente);
		List<Sede> elencoSedi=this.sedeS.elencoSedi();
		
		if(trv.isPresent()) {

			x.addAttribute("clienteTrovato", trv.get());
			x.addAttribute("elencoSedi", elencoSedi);

			return "creaContratto";
		}
		else {
			x.addAttribute("MessaggioErrore", "Nessuna corrispondenza");
			 return "creaContratto";
		}
	}
	
	
	@PostMapping("/addContratto")
	public String addContratto(Model x, @ModelAttribute AppSede contratto, @RequestParam String clienteTrv, Long sedeScelta) {
		
		contratto.setClAppSede(this.cs.findById(clienteTrv).get());
		contratto.setnCnSede(this.sedeS.findByIdSede(sedeScelta));
		this.aps.addAppSede(contratto);
		x.addAttribute("Messaggio","Contratto creato correttamente");
		return "creaContratto";
	}
	
	
	
	//------------SEDE-----------------
	@GetMapping("/Sede")
    public String Sede(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "Sede";
	}
	
	
	@GetMapping("/addSede")
    public String addSede(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "aggiungiSede";
	}
	
	
	@PostMapping("/aggiungiSede")
    public String aggiungiSede(Model x, @ModelAttribute Sede s) {
		
		Boolean esito;
		
		esito=this.sedeS.addSede(s);
		
		if(esito.equals(true)) {
			x.addAttribute("Messaggio", "Nuova sede inserita");
			return "aggiungiSede";
		}
		else {
			return "aggiungiSede";
		}

	}
	
	
	@GetMapping("/modSede")
    public String modSede(HttpSession session) {
		
		Operaio op=(Operaio) session.getAttribute("OperaioLoggato");
		
		if(op == null) {
			return "Login";
		}
		
        return "modificaSede";
	}
	
	
	@PostMapping("/modificaSede")
    public String modificaSede(Model x, @RequestParam String nomeSede, String cittaSede) {
		
		List<Sede> sedeDaMod=this.sedeS.findByNomeSedeAndCittaSede(nomeSede, cittaSede);
		
		if(sedeDaMod.size() > 0) {
			x.addAttribute("sedeDaMod", sedeDaMod);
			return "modificaSede";
		}
		else {
			x.addAttribute("NoMatch", "Nessuna corrispondenza i dati inseriti");
			return "modificaSede";
		}
	}
	
	
	@PostMapping("/updateSede")
	public String updateSede(Model x, @ModelAttribute Sede s) {
		
		Optional<Sede> sedeDaMod=this.sedeS.findByNomeSedeAndCittaOptional(s.getNomeSede(), s.getCittaSede());
		
		s.setIdSede(sedeDaMod.get().getIdSede());
		
        Boolean aggiornato = sedeS.updateSede(s);
        
        if (aggiornato.equals(true)) {
            x.addAttribute("MessaggioUpdate", "Sede aggiornata con successo.");
            return "modificaSede";
        } 
        else {
            return "modificaSede";
        }
	}
	
	
	@PostMapping("/deleteSede")
	public String deleteSede(Model x, @RequestParam Long idSede) {
		
		// qui ci andiamo a prendere il risultato true o false(nel caso in cui non ha trovato un cf)
	    Boolean eliminato=sedeS.deleteSede(idSede);
	
	    // qui inviamo i messaggi al jsp in base all esito dell eliminazione
	    if (eliminato.equals(true)) {
	        x.addAttribute("MessaggioDelete", "Sede eliminato correttamente.");
	        return "modificaSede";
	    } 
	    else {
	        return "modificaSede";
	    }
		
	}
}