package project.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.entity.Feeds;

@Repository
public interface EntryRepository extends JpaRepository<Feeds, Long> {

	
}
