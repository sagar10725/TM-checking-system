package edu.mum.tmsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.tmsystem.domain.Building;
import edu.mum.tmsystem.domain.Room;
import edu.mum.tmsystem.repository.IBuildingRepository;
import edu.mum.tmsystem.service.IBuildingService;

@Service
@Transactional
public class BuildingServiceImpl implements IBuildingService {
	
	@Autowired
	IBuildingRepository buildingRepository;

	@Override
	public List<Building> getAllBuildings() {
		List<Building> buildings = (List<Building>) buildingRepository.findAll();
		return buildings;
	}

	@Override
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	public void addNewBuilding(Building building) {
		buildingRepository.save(building);	
		
	}

	@Override
	public Building getBuildingOne(Integer id) {
		return buildingRepository.findOne(id);
	}

	@Override
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	public void deleteBuilding(Integer id) {
		buildingRepository.delete(id);
		
	}



	@Override
	public List<Room> getAllRoomByBuildingId(Integer Id) {
		Building building = buildingRepository.findOne(Id);
		return building.getRooms();
	}

}
