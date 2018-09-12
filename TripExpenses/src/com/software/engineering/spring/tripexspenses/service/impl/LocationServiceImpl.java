package com.software.engineering.spring.tripexspenses.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.engineering.spring.tripexspenses.dao.LocationDAO;
import com.software.engineering.spring.tripexspenses.domen.Location;
import com.software.engineering.spring.tripexspenses.service.LocationService;
@Service("locationsService")
public class LocationServiceImpl implements LocationService {
		@Autowired
		LocationDAO locationDAO;
	@Override
	public List<Location> findAll() {
		// TODO Auto-generated method stub
		return locationDAO.findAll();
	}

	@Override
	public void delete(Long locId) {
		locationDAO.delete(locId);
		
	}

	@Override
	public Location save(Location location) {
		// TODO Auto-generated method stub
		return locationDAO.save(location);
	}

	@Override
	public Location findByID(Long locId) {
		// TODO Auto-generated method stub
		return locationDAO.findOne(locId);
	}

}
