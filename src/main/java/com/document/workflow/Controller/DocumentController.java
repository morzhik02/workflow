package com.document.workflow.Controller;

import com.document.workflow.Entity.Document;
import com.document.workflow.Service.DocumentService;
import com.document.workflow.dto.DocumentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Document createDocument(@RequestBody DocumentDto documentDto){
        return documentService.createDocument(documentDto.getType());
    }

    @PutMapping("update/{id}")
    public Document updateDocument(@RequestBody Document documentDto){
        return documentService.updateDocument(documentDto.getId(), documentDto.getType(), documentDto.getStatus());
    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Document> getById(Long documentId){
//        return
//    }
//


}
