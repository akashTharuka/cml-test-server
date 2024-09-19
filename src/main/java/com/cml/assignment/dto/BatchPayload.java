package com.cml.assignment.dto;

import lombok.Data;

import java.util.List;

@Data
public class BatchPayload {
    private String batchId;
    private List<RecordDTO> records;
}
