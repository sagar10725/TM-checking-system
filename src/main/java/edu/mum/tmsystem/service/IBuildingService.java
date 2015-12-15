package edu.mum.tmsystem.service;

import java.util.List;

import edu.mum.tmsystem.domain.Building;
import edu.mum.tmsystem.domain.Room;

public interface IBuildingService {
	public List<Building> getAllBuildings();

	public void addNewBuilding(Building building);

	public Building getBuildingOne(Integer id);

	public void deleteBuilding(Integer id);  
	
	public List<Room> getAllRoomByBuildingId(Integer Id);
}
