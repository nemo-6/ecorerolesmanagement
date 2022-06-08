package com.ecore.ecorerolemanagement.repository;

import com.ecore.ecorerolemanagement.model.MembershipModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MembershipRepository extends MongoRepository<MembershipModel, String> {

    Optional<MembershipModel> findMembershipModelByRoleNameAndMemberIdAndTeamId(String roleName, String memberId, String teamId);

    List<MembershipModel> findMembershipModelsByTeamIdAndMemberId(String teamId, String memberId);

    List<MembershipModel> findMembershipModelByRoleName(String roleName);

}
