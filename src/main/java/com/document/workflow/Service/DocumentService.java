package com.document.workflow.Service;

import com.document.workflow.Entity.Document;


public interface DocumentService {
    Document createDocument(String type);
    Document saveDocument(Document document);
    Document updateDocument(Long id, String type, String status);
}
