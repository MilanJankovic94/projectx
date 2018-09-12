package com.software.engineering.spring.tripexspenses.service;

import java.util.List;

import com.software.engineering.spring.tripexspenses.domen.Location;

public interface LocationService {
	public List<Location> findAll();
	public void delete(Long locId);
	public Location save(Location location);
	public Location findByID(Long locId) ;
}
