package com.ecore.ecorerolemanagement.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("membership")
public class MembershipModel {
    private String id;
    private String memberId;
    private String teamId;
    private String roleName;

    public MembershipModel(String id, String memberId, String teamId, String roleName) {
        this.id = id;
        this.memberId = memberId;
        this.teamId = teamId;
        this.roleName = roleName;

        // Default Value
        if(roleName == null) {
            this.roleName = "Developer";
        }
    }
}
