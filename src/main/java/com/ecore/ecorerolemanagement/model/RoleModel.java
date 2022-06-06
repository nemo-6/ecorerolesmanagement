package com.ecore.ecorerolemanagement.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class RoleModel {
    @Id
    private String id;
    private String name;
}
