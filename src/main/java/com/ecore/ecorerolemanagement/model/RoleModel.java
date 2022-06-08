package com.ecore.ecorerolemanagement.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("role")
public class RoleModel {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
}
