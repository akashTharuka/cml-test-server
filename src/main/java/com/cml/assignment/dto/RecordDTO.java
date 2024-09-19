package com.cml.assignment.dto;

import lombok.Data;

import java.util.List;

@Data
public class RecordDTO {
    private String transId;
    private String transTms;
    private String rcNum;
    private String clientId;
    private List<EventDTO> event;
}
