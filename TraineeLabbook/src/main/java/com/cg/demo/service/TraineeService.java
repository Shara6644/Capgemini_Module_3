package com.cg.demo.service;

import java.util.List;

import com.cg.demo.entity.Trainee;
import com.cg.demo.exception.TraineeException;

public interface TraineeService {

    public Trainee findEmployeeById(int traineeId)  throws TraineeException ;
	
	public Trainee addTrainee(Trainee  trainee)     throws TraineeException;
	
	public Trainee updateTrainee(Trainee  trainee)  throws TraineeException;
	
	public List<Trainee>  findAllTrainees()         throws TraineeException;
	
	public Trainee deleteTraineeById(int traineeId) throws TraineeException;
}
