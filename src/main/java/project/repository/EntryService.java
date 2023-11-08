package project.repository;

import java.util.List;

import project.entity.Feeds;


public interface EntryService {
	
	public Feeds saveEntry(Feeds feeds);
	public Feeds updateEntry(long id,Feeds feeds);
	public void deleteEntry(long id);
	public String assignUserToNotes(long uid, long fid);
	public List<Feeds>findAll();
	public Feeds findById(long id);

}