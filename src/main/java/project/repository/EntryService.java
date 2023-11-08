package project.repository;

import java.util.List;

import project.entity.Memory;


public interface EntryService {
	
	public Memory saveEntry(Memory memory);
	public Memory updateEntry(Long id,Memory memory);
	public void deleteEntry(Long id);
	public String assignUserToNotes(Long uid, Long fid);
	public List<Memory>findAll();
	public Memory findById(Long id);


}