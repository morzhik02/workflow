package com.document.workflow.Controller;

import com.document.workflow.Entity.Document;
import com.document.workflow.Service.DocumentService;
import com.document.workflow.dto.DocumentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public Document createDocument(@RequestBody Document document){
        return documentService.createDocument(document);
    }

    @PutMapping("/{id}")
    public Document updateDocument(@RequestBody Document document, @PathVariable("id") Long id){
        return documentService.updateDocument(document, id);
    }

    @GetMapping(value = "/{id}")
    public Document getDocument(@PathVariable("id") Long id){
        return documentService.getDocument(id);
    }

    @GetMapping
    public List<Document> listAllDocuments(){
        List<Document> documents = documentService.getDocuments();
        return documents;
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable("id") Long id){
        documentService.deleteDocument(id);
    }

}
