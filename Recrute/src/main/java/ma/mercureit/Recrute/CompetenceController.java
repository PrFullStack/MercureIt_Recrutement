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

import ma.mercureit.Recrute.entities.Competence;
import ma.mercureit.Recrute.repositories.CompetenceRepository;

@RestController
@RequestMapping("/api/v1")
public class CompetenceController {
	@Autowired
	private CompetenceRepository competenceRepository;

	// get All Competences
	
	@GetMapping("/competences")
	public List<Competence> getAllCompetence() {
		return competenceRepository.findAll();
	}
	
	//create Competence  
	@PostMapping("/competences")
	public Competence createCompetence(@RequestBody Competence competence) {
		return competenceRepository.save(competence);
	}
	
	//delete Competence
	@DeleteMapping("/competence/{id}")
	public Map<String, Boolean> deleteCompetence(@PathVariable(value = "id") Long competenceId)
			throws AttributeNotFoundException {
		Competence competence = competenceRepository.findById(competenceId)
				.orElseThrow(() -> new AttributeNotFoundException("Competence not found for this id :: " + competenceId));

		competenceRepository.delete(competence);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
