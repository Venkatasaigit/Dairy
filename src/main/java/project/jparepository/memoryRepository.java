package project.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.entity.Memory;



@Repository
public interface memoryRepository extends JpaRepository<Memory, Long> {

	
}
