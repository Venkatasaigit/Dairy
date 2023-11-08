package project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import project.entity.Memory;
import project.entity.User;

import project.jparepository.UserRepository;
import project.jparepository.memoryRepository;
import project.repository.EntryService;



@Service
public class EntryServiceImpl implements EntryService {
	
	@Autowired
	private memoryRepository enteryDao;
	
	@Autowired
	private UserRepository userdao;

	@Override
	public Memory saveEntry(Memory memory) {
		enteryDao.save(memory);
		return memory; 
	}
	

	@Override
	public List<Memory> findAll() {
		List<Memory> notes= enteryDao.findAll();
		return notes;
	}

	@Override
	public Memory findById(Long id) {
		Memory note=enteryDao.findById(id).get();
		return note;
	}


	@Override
	public Memory updateEntry(Long id, Memory Memory) {
		try {
			Memory note=enteryDao.findById(id).get();
			if(note.getClass()!=null)
			{
				note.setDesc(note.getDesc());
			}
			enteryDao.save(note);
			return note;
			}
			catch(Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
		}


	@Override
	public void deleteEntry(Long id) {
		try{
			enteryDao.deleteById(id);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}


	@Override
	public String assignUserToNotes(Long uid, Long fid) {
		User u=userdao.findById(uid).orElseThrow(()->
		new ResourceNotFoundException("User", "Id", uid));
		
		Memory f=enteryDao.findById(fid).orElseThrow(()->
		new ResourceNotFoundException("Memory", "Id", fid));
		
		List<Memory> notes=new ArrayList<>();
		notes.add(f);		
		//assign notes to user
		u.getId();
		
		//assign user to notes
		//f.getId();
		
		enteryDao.save(f);
		return "Students assigned to teacher successfully";
	}



}