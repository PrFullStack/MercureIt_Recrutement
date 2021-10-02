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

import ma.mercureit.Recrute.entities.Etape;
import ma.mercureit.Recrute.repositories.EtapeRepository;

@RestController
@RequestMapping("/api/v1")
public class EtapeController {

	@Autowired
	private EtapeRepository etapeRepository;

	// get All Etapes
	
	@GetMapping("/etapes")
	public List<Etape> getAllEtape() {
		return etapeRepository.findAll();
	}
	
	//create Etape 
	@PostMapping("/etapes")
	public Etape createEtape(@RequestBody Etape etape) {
		return etapeRepository.save(etape);
	}
	
	//delete Etape
	@DeleteMapping("/etape/{id}")
	public Map<String, Boolean> deleteEtape(@PathVariable(value = "id") Long etapeId)
			throws AttributeNotFoundException {
		Etape etape = etapeRepository.findById(etapeId)
				.orElseThrow(() -> new AttributeNotFoundException("Etape not found for this id :: " + etapeId));

		etapeRepository.delete(etape);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
