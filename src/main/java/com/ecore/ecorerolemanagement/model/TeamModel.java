package com.ecore.ecorerolemanagement.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("team")
public class TeamModel {
    private String id;
    private String name;
    private String teamLeadId;
    private List<String> teamMemberIds;
}
