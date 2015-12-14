package edu.mum.tmsystem.service;

import java.util.List;

import edu.mum.tmsystem.domain.Building;

public interface IBuildingService {
	public List<Building> getAllBuildings();

	public void addNewBuilding(Building building);

	public Building getBuildingOne(Integer id);  
}
