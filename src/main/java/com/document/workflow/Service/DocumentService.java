package com.document.workflow.Service;

import com.document.workflow.Entity.Document;

import java.util.List;


public interface DocumentService {
    Document createDocument(Document document);
    Document updateDocument(Document document, Long id);
    Document getDocument(Long id);
    List<Document> getDocuments();
    void deleteDocument(Long id);
}
