package com.tig.app.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tig.app.entities.Metadata;
import com.tig.app.repositories.MetadataRepository;

@Service
public class MetadataService {
	
	@Autowired
	private MetadataRepository metadataRepository;
	
	public List<Metadata> getMetadataByDateRangeAndWordKeys(String first, String second, Date from, Date to){
		List<Metadata> metadata = new ArrayList<>();
		metadataRepository.findMetadataByDateRangeAndWordKeys(first, second, from, to).forEach(metadata::add);
		return metadata;
	}

}
