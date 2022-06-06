package com.ecore.ecorerolemanagement.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class MembershipModel {
    private String id;
    private String memberId;
    private String teamId;
    private String roleName;
}
