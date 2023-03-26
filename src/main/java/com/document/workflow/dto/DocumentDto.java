package com.document.workflow.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DocumentDto {
    private Long id;

    @JsonProperty(value = "type")
    private String type;

    private String status;
//    private Long emp_id;
}
