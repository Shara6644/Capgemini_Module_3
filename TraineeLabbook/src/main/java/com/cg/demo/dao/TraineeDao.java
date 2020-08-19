package com.cg.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.demo.entity.Trainee;

@Repository
public interface TraineeDao extends JpaRepository<Trainee, Integer> {

}
