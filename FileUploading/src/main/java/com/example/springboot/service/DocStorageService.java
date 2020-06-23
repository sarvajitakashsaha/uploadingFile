package com.example.springboot.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot.model.Doc;
import com.example.springboot.repository.DocRepository;

@Service
public class DocStorageService {

	@Autowired
	private DocRepository docRepository;
	
	public Doc saveFile(MultipartFile file) throws IOException {
		String docName = file.getOriginalFilename();
		String docType = file.getContentType();
		byte[] data = file.getBytes();
		long size = file.getSize();
		try {
			Doc doc = new Doc(docName, docType, data);
			return docRepository.save(doc);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Optional<Doc> getFile(Integer fileId) {
		return docRepository.findById(fileId);
	}
	
	public List<Doc> getallFile(){
		return docRepository.findAll();
	}
}
