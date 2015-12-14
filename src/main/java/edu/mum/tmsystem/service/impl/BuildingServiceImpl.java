package edu.mum.tmsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.tmsystem.domain.Building;
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
	public void addNewBuilding(Building building) {
		buildingRepository.save(building);	
		
	}

	@Override
	public Building getBuildingOne(Integer id) {
		return buildingRepository.findOne(id);
	}

	@Override
	public void deleteBuilding(Integer id) {
		buildingRepository.delete(id);
		
	}

}
