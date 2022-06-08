package com.ecore.ecorerolemanagement.service;

import com.ecore.ecorerolemanagement.model.MembershipModel;
import com.ecore.ecorerolemanagement.repository.MembershipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MembershipService {

    private final MembershipRepository membershipRepository;

    public void insert(MembershipModel membership){
        Optional<MembershipModel> existing_membership = this.membershipRepository
                .findMembershipModelByRoleNameAndMemberIdAndTeamId(
                        membership.getRoleName(),
                        membership.getMemberId(),
                        membership.getTeamId()
                );
        if(existing_membership.isEmpty()) {
            membershipRepository.insert(membership);
        }
    }

    public List<MembershipModel> getMembershipsByRole(String roleName) {
        return membershipRepository.findMembershipModelByRoleName(roleName);
    }

    public List<MembershipModel> getAll() {
        return this.membershipRepository.findAll();
    }
}
