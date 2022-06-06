package com.ecore.ecorerolemanagement.service;

import com.ecore.ecorerolemanagement.model.MembershipModel;
import com.ecore.ecorerolemanagement.model.RoleModel;
import com.ecore.ecorerolemanagement.repository.MembershipRepository;
import com.ecore.ecorerolemanagement.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    private final MembershipRepository membershipRepository;

    public List<RoleModel> findAll() {
        return roleRepository.findAll();
    }

    public void insert(RoleModel role) {
        roleRepository.insert(role);
    }

    public List<RoleModel> findDefaultRoles() {
        return roleRepository.findDefaultRoles();
    }

    public Optional<MembershipModel> findRoleNameByMembership(String memberId, String teamId) {
        return membershipRepository.findMembershipModelByTeamIdAndMemberId(teamId, memberId);
    }
}
