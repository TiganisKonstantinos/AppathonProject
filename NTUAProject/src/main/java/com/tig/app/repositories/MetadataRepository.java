package com.tig.app.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tig.app.entities.Metadata;

public interface MetadataRepository extends CrudRepository<Metadata, Long> {

	@Query("SELECT m FROM Metadata m WHERE LOWER(m.title) LIKE LOWER(CONCAT('%',?1,'%')) AND LOWER(m.title) LIKE LOWER(CONCAT('%',?2,'%')) AND m.publishTime BETWEEN ?3 AND ?4")
	List<Metadata> findMetadataByDateRangeAndWordKeys(String first, String second, Date from, Date to);
	

}
