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

import ma.mercureit.Recrute.entities.Poste;
import ma.mercureit.Recrute.repositories.PosteRepository;

@RestController
@RequestMapping("/api/v1")
public class PosteController {

	@Autowired
	private PosteRepository posteRepository;

	// get All Poste
	
	@GetMapping("/postes")
	public List<Poste> getAllPoste() {
		return posteRepository.findAll();
	}
	
	
	//create Poste  
	
		@PostMapping("/postes")
		public Poste posteEquipe(@RequestBody Poste poste) {
			return posteRepository.save(poste);
		}
		
		//delete Poste
	@DeleteMapping("/poste/{id}")
	public Map<String, Boolean> deletePoste(@PathVariable(value = "id") Long posteId)
			throws AttributeNotFoundException {
		Poste poste = posteRepository.findById(posteId)
				.orElseThrow(() -> new AttributeNotFoundException("Poste not found for this id :: " + posteId));

		posteRepository.delete(poste);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
