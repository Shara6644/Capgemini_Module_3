package com.cg.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.demo.entity.Trainee;
import com.cg.demo.exception.TraineeException;
import com.cg.demo.service.TraineeService;



@RestController
@CrossOrigin("*")
public class TraineeController {

	@Autowired
	TraineeService traineeService;

	@GetMapping("trainee/{id}")
	public ResponseEntity<Trainee> findTraineeById(@PathVariable("id") int id) throws TraineeException {

		Trainee trainee = traineeService.findEmployeeById(id);
		ResponseEntity<Trainee> re = new ResponseEntity<Trainee>(trainee, HttpStatus.OK);
		return re;
	}

	@PostMapping("trainee")
	public ResponseEntity<Trainee> createtrainee(@RequestBody Trainee trainee)throws TraineeException {
		Trainee trainee1 = traineeService.addTrainee(trainee);
		ResponseEntity<Trainee> re = new ResponseEntity<Trainee>(trainee1, HttpStatus.OK);
		return re;
	}

	
	@PutMapping("trainee")
	public ResponseEntity<Trainee> updateTrainee(@RequestBody Trainee trainee) 
	throws TraineeException
	{
		Trainee trainee1 = traineeService.updateTrainee(trainee);
		ResponseEntity<Trainee> re = new ResponseEntity<Trainee>(trainee1, HttpStatus.OK);
		return re;
	}

	@GetMapping("trainee")
	public ResponseEntity<List<Trainee>> findAllTrainee() throws TraineeException {

		List<Trainee> list = traineeService.findAllTrainees();
		ResponseEntity<List<Trainee>> rt = new ResponseEntity<List<Trainee>>(list, HttpStatus.OK);
		return rt;

	}

	@DeleteMapping("trainee/{id}")
	public ResponseEntity<Trainee> deleteTraineeById(@PathVariable("id") int employeeId) throws TraineeException {

		ResponseEntity<Trainee> rt = null;

		Trainee trainee = traineeService.deleteTraineeById(employeeId);
		rt = new ResponseEntity<Trainee>(trainee, HttpStatus.OK);

		return rt;
	}

}
