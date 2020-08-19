package com.cg.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.demo.dao.TraineeDao;
import com.cg.demo.entity.Trainee;
import com.cg.demo.exception.TraineeException;

@Service
public class TraineeServiceImpl implements TraineeService{

	@Autowired
	TraineeDao traineeDao;
	@Override
	public Trainee findEmployeeById(int traineeId) throws TraineeException {
	
		if( ! traineeDao.existsById(traineeId))
		{
			throw new TraineeException(" ID NOT FOUND ");
		}
		return traineeDao.findById(traineeId).get();
	}

	@Override
	public Trainee addTrainee(Trainee trainee) throws TraineeException {
		Trainee trainee1 = traineeDao.saveAndFlush(trainee);
	     return trainee1;
	}

	@Override
	public Trainee updateTrainee(Trainee trainee) throws TraineeException {
		int id = trainee.getTraineeId();
		Trainee  trainee1=null;
		if( traineeDao.existsById(id))
		{
			trainee1=traineeDao.saveAndFlush(trainee);
		}
		else
		{
			throw new TraineeException(" ID NOT FOUND ");
		}
		return trainee1;
	}

	@Override
	public List<Trainee> findAllTrainees() throws TraineeException {
		List<Trainee> list = traineeDao.findAll();
		return list;
	}

	@Override
	public Trainee deleteTraineeById(int traineeId) throws TraineeException {
Trainee trainee =null;
		
		if( traineeDao.existsById(traineeId))
		{
			 trainee = traineeDao.findById(traineeId).get();
			 traineeDao.deleteById(traineeId);
		}
		else
		{
			throw new TraineeException(" ID NOT FOUND ");
		}
		return trainee ;
	}

}
