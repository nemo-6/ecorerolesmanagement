package com.ecore.ecorerolemanagement.repository;
import com.ecore.ecorerolemanagement.model.RoleModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<RoleModel, String> {
    Optional<RoleModel> findRoleModelByName(String name);

    @Query("{ name: { $in: [ \"Developer\", \"Product Owner\", \"Tester\", ] } }")
    List<RoleModel> findDefaultRoles();

}
