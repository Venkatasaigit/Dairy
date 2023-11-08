package project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import project.entity.Feeds;
import project.entity.User;
import project.jparepository.EntryRepository;
import project.jparepository.UserRepository;
import project.repository.EntryService;



@Service
public class EntryServiceImpl implements EntryService {
	
	@Autowired
	private EntryRepository enteryDao;
	
	@Autowired
	private UserRepository userdao;

	@Override
	public Feeds saveEntry(Feeds feeds) {
		enteryDao.save(feeds);
		return feeds; 
	}
	

	@Override
	public List<Feeds> findAll() {
		List<Feeds> notes= enteryDao.findAll();
		return notes;
	}

	@Override
	public Feeds findById(long id) {
		Feeds note=enteryDao.findById(id).get();
		return note;
	}


	@Override
	public Feeds updateEntry(long id, Feeds feeds) {
		try {
			Feeds note=enteryDao.findById(id).get();
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
	public void deleteEntry(long id) {
		try{
			enteryDao.deleteById(id);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}


	@Override
	public String assignUserToNotes(long uid, long fid) {
		User u=userdao.findById(uid).orElseThrow(()->
		new ResourceNotFoundException("User", "Id", uid));
		
		Feeds f=enteryDao.findById(fid).orElseThrow(()->
		new ResourceNotFoundException("Feeds", "Id", fid));
		
		List<Feeds> notes=new ArrayList<>();
		notes.add(f);		
		//assign notes to user
		u.getId();
		
		//assign user to notes
		f.getId();
		
		enteryDao.save(f);
		return "Students assigned to teacher successfully";
	}

}