package com.document.workflow.Service.impl;

import com.document.workflow.Entity.Document;
import com.document.workflow.Repository.DocumentRepository;
import com.document.workflow.Service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository) {
        //super();
        this.documentRepository = documentRepository;
    }

    @Override
    public Document createDocument(String type) {
        Document document = mapDocument(type);
        document.setCreatedAt(LocalDateTime.now());
        System.out.println(document);
        return documentRepository.save(document);
    }

    @Override
    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public Document updateDocument(Long id, String type, String status) {
        Document document = mapDocument(type);
        document.setId(id);
        document.setStatus(status);
        document.setUpdatedAt(LocalDateTime.now());
//        document.setEmp_id(emp_id);
        return documentRepository.save(document);
    }


    private Document mapDocument(String type){
        Document document = new Document();
        document.setType(type);
        document.setStatus("Не начато");
        document.setUpdatedAt(LocalDateTime.now());
        return document;
    }
}
