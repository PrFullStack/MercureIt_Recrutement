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

import ma.mercureit.Recrute.entities.Candidat;
import ma.mercureit.Recrute.repositories.CandidatRepository;

@RestController
@RequestMapping("/api/v1")
public class CandidatController {

	@Autowired
	private CandidatRepository candidatRepository;

	// get All Candidats
	
	@GetMapping("/candidats")
	public List<Candidat> getAllCandidat() {
		return candidatRepository.findAll();
	}
	
	//create Candidat  
	@PostMapping("/candidats")
	public Candidat createCandidat(@RequestBody Candidat candidat) {
		return candidatRepository.save(candidat);
	}
	
	//delete Candidat
	@DeleteMapping("/candidat/{id}")
	public Map<String, Boolean> deleteCandidat(@PathVariable(value = "id") Long candidatId)
			throws AttributeNotFoundException {
		Candidat candidat = candidatRepository.findById(candidatId)
				.orElseThrow(() -> new AttributeNotFoundException("Candidat not found for this id :: " + candidatId));

		candidatRepository.delete(candidat);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
