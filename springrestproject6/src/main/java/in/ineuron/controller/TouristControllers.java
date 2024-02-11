package in.ineuron.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Tourist;
import in.ineuron.service.ITouristMgmtService;

@RestController
@RequestMapping("/api/tourist")
public class TouristControllers {
	@Autowired
	private ITouristMgmtService service;
	@GetMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
		
			String resultMsg = service.Adduser(tourist);
			return new ResponseEntity<String>(resultMsg, HttpStatus.OK);
		
	}
	@GetMapping("/findAll")
	public ResponseEntity<?> fetchAllDetails()
	{
		
		  List<Tourist> list=service.FetchAlldetails();
		  return new ResponseEntity <List<Tourist>>(list,HttpStatus.OK);
	}
	
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> fetchByDetails(@PathVariable("id") Integer id)
	{
		  Tourist list=service.fetchDetailsByid(id);
		  return new ResponseEntity <Tourist>(list,HttpStatus.OK);
	     
	}
	@PutMapping("/update")
	public ResponseEntity<?> UpdateRecordByTourist(@RequestBody Tourist tourist)
	{
		
			String response=service.updateTouristByDetails(tourist);
			return new ResponseEntity<String>(response,HttpStatus.OK);
		}
		
	
	@PatchMapping("/budgetModify/{id}/{hike}")
	public ResponseEntity<String> modifytouristBudgetById(@PathVariable("id") Integer id,
			@PathVariable("hike") Float hikeAmt) {
		
			String msg = service.updateTouristById(id, hikeAmt);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		
	
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deletedetails(@PathVariable ("id")Integer id)
	{
		  	String msg=service.deleteTouristById(id);
		   	return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}

}
