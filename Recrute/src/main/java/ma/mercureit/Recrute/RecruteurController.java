package ma.mercureit.Recrute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.mercureit.Recrute.entities.Recruteur;
import ma.mercureit.Recrute.repositories.RecruteurRepository;


@RestController
@RequestMapping("/api/v1")
public class RecruteurController {

	@Autowired
	private RecruteurRepository recruteurRepository;

	// get All Recruteurs
	
	@GetMapping("/recruteurs")
	public List<Recruteur> getAllRecruteur() {
		return recruteurRepository.findAll();
	}
	
	//create Recruteur  
	@PostMapping("/recruteurs")
	public Recruteur createRecruteur(@RequestBody Recruteur recruteur) {
		return recruteurRepository.save(recruteur);
	}
	
	//delete Recruteur
	@DeleteMapping("/recruteur/{id}")
	public Map<String, Boolean> deleteRecruteur(@PathVariable(value = "id") Long recruteurId)
			throws AttributeNotFoundException {
		Recruteur recruteur = recruteurRepository.findById(recruteurId)
				.orElseThrow(() -> new AttributeNotFoundException("Recruteur not found for this id :: " + recruteurId));

		recruteurRepository.delete(recruteur);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
