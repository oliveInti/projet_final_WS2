package fr.adaming.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Voyage;
import fr.adaming.service.IVoyageService;

/**
 * Définition des méthodes du web service Voyage avec Spring MVC
 * 
 * @author projet blue
 *
 */
@RestController // défini la classe comme un controller
@RequestMapping("/voyages") // controller mappé comme étant "/voyages" pour l'url
public class VoyageRestController {

	@Autowired // injection de dépendance + setter
	private IVoyageService voyageService;

	public void setVoyageService(IVoyageService voyageService) {
		this.voyageService = voyageService;
	}

	@CrossOrigin// annotation pour faire le lien entre service et angular
	@RequestMapping(value = "/listeVoyage", method = RequestMethod.GET, produces = "application/json")
	public List<Voyage> recupererTout() {
		return voyageService.recupererTout();
	}

	@CrossOrigin
	@RequestMapping(value = "/voyage/{pId}", method = RequestMethod.GET, produces = "application/json")
	public Voyage recupererParId(@PathVariable("pId") int id) {
		return voyageService.recupererParId(id);
	}

	@CrossOrigin
	@RequestMapping(value = "/ajout", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Voyage ajouterVoyage(@RequestBody Voyage v) {
		return voyageService.creer(v);
	}

	@CrossOrigin
	@RequestMapping(value = "/modif", method = RequestMethod.PUT, consumes = "application/json")
	public void modifierVoyage(@RequestBody Voyage v) {
		voyageService.modifier(v);
	}

	@CrossOrigin
	@RequestMapping(value = "/supp/{pId}", method = RequestMethod.DELETE)
	public void supprimerVoyage(@PathVariable("pId") int id) {
		voyageService.supprimer(id);
	}

	@CrossOrigin
	@RequestMapping(value = "/destination/{pNom}", method = RequestMethod.GET, produces = "application/json")
	public List<Voyage> recupererParNom(@PathVariable("pNom") String nom) {
		return voyageService.recupererParNom(nom);
	}
}