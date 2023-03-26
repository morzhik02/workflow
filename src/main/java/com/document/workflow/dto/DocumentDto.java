package com.document.workflow.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DocumentDto {
    @JsonProperty(value =  "id")
    private Long id;

    @JsonProperty(value = "type")
    private String type;

    @JsonProperty(value = "status")
    private String status;

//    private Long emp_id;
}
