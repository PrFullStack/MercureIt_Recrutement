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

import ma.mercureit.Recrute.entities.Departement;
import ma.mercureit.Recrute.repositories.DepartementRepository;


@RestController
@RequestMapping("/api/v1")
public class DepartementController {
  
	@Autowired
	private DepartementRepository departementRepository;

	// get All Departements
	
	@GetMapping("/departements")
	public List<Departement> getAllDepartement() {
		return departementRepository.findAll();
	}
	
	//create Departement  
	@PostMapping("/departements")
	public Departement createDepartement(@RequestBody Departement departement) {
		return departementRepository.save(departement);
	}
	
	//delete Departement
	@DeleteMapping("/departement/{id}")
	public Map<String, Boolean> deleteDepartement(@PathVariable(value = "id") Long departementId)
			throws AttributeNotFoundException {
		Departement departement = departementRepository.findById(departementId)
				.orElseThrow(() -> new AttributeNotFoundException("Departement not found for this id :: " + departementId));

		departementRepository.delete(departement);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
