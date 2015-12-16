package edu.mum.tmsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.tmsystem.domain.Room;
import edu.mum.tmsystem.repository.IRoomRepositiry;
import edu.mum.tmsystem.service.IRoomService;

@Service
@Transactional
public class RoomService implements IRoomService {
	
	@Autowired
	IRoomRepositiry roomRepository;

	@Override
	public void addNewRoom(Room room) {
		roomRepository.save(room);
		
	}

	@Override
	public Room getRoomById(Integer id) {
		return (Room) roomRepository.findOne(id);
	}

}
