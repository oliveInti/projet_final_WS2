package fr.adaming.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

/**
 * Définition des méthodes du web service avec Spring MVC
 * 
 * @author projet blue
 *
 */
@RestController
@RequestMapping("clients")
public class ClientRestController {

	@Autowired
	private IClientService clientService;

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	@CrossOrigin
	@RequestMapping(value = "/listeClient", method = RequestMethod.GET, produces = "application/json")
	public List<Client> recupererTout() {
		return clientService.recupererTout();
	}

	@CrossOrigin
	@RequestMapping(value = "/client/{pId}", method = RequestMethod.GET, produces = "application/json")
	public Client recupererParId(@PathVariable("pId") int id) {
		return clientService.recupererParId(id);
	}

	@CrossOrigin
	@RequestMapping(value = "/ajout", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Client ajouterClient(@RequestBody Client c) {
		return clientService.creer(c);
	}

	@CrossOrigin
	@RequestMapping(value = "/modif", method = RequestMethod.PUT, consumes = "application/json")
	public void modifierClient(@RequestBody Client c) {
		clientService.modifier(c);
	}

	@CrossOrigin
	@RequestMapping(value = "/supp/{pId}", method = RequestMethod.DELETE)
	public void supprimerClient(@PathVariable("pId") int id) {
		clientService.supprimer(id);
	}

	@CrossOrigin
	@RequestMapping(value = "/nomClient/{pNom}", method = RequestMethod.GET, produces = "application/json")
	public List<Client> recupererParNom(@PathVariable("pNom") String nom) {
		return clientService.recupererParNom(nom);
	}

	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public void authentification(@RequestBody Client c) {
		String mail = c.getMail();
		String mdp = c.getMdp();

		clientService.login(mail, mdp);
	}
}
