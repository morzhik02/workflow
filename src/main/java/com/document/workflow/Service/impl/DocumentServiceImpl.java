package com.document.workflow.Service.impl;

import com.document.workflow.Entity.Document;
import com.document.workflow.Repository.DocumentRepository;
import com.document.workflow.Service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Document createDocument(Document document) {
        document.setStatus("Создано");
        document.setCreatedAt(LocalDateTime.now());
        document.setUpdatedAt(LocalDateTime.now());
        return documentRepository.save(document);
    }

    @Override
    public Document updateDocument(Document document, Long id) {
        Document oldDocument = documentRepository.getReferenceById(id);
        oldDocument.setStatus(document.getStatus());
        oldDocument.setType(document.getType());
        oldDocument.setUpdatedAt(LocalDateTime.now());
        return documentRepository.save(oldDocument);
    }

    @Override
    public Document getDocument(Long id) {
        return documentRepository.findById(id).get();
    }

    @Override
    public List<Document> getDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }


    private Document mapDocument(String type){
        Document document = new Document();
        document.setType(type);
        document.setStatus("Не начато");
        document.setUpdatedAt(LocalDateTime.now());
        return document;
    }
}
