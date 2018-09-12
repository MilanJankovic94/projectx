package com.software.engineering.spring.tripexspenses.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.software.engineering.spring.tripexspenses.domen.Employee;
import com.software.engineering.spring.tripexspenses.domen.Location;

@Repository("locationsDAO")
public interface LocationDAO extends JpaRepository<Location, Long>{

}
