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

import ma.mercureit.Recrute.entities.Employe;
import ma.mercureit.Recrute.repositories.EmployeRepository;


@RestController
@RequestMapping("/api/v1")
public class EmployeController {
	@Autowired
	private EmployeRepository employeRepository;

	// get All Employes
	
	@GetMapping("/employes")
	public List<Employe> getAllEmploye() {
		return employeRepository.findAll();
	}
	
	//create Employe  
	@PostMapping("/employes")
	public Employe createEmploye(@RequestBody Employe employe) {
		return employeRepository.save(employe);
	}
	
	//delete Employe
	@DeleteMapping("/employe/{id}")
	public Map<String, Boolean> deleteCandidat(@PathVariable(value = "id") Long employeId)
			throws AttributeNotFoundException {
		Employe employe = employeRepository.findById(employeId)
				.orElseThrow(() -> new AttributeNotFoundException("Employe not found for this id :: " + employeId));

		employeRepository.delete(employe);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
