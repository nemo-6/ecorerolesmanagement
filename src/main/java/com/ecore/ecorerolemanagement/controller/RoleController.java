package com.ecore.ecorerolemanagement.controller;

import com.ecore.ecorerolemanagement.model.MembershipModel;
import com.ecore.ecorerolemanagement.model.RoleModel;
import com.ecore.ecorerolemanagement.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/role",  produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/default")
    public List<RoleModel> getDefaultRoles() {
        return roleService.findDefaultRoles();
    }

    @PostMapping
    public void insertRole(@RequestBody RoleModel role) {
        roleService.insert(role);
    }

    @GetMapping()
    public String findRoleNameByMembership(@RequestParam String memberId, @RequestParam String teamId) {
        Optional<MembershipModel> membership = roleService.findRoleNameByMembership(memberId, teamId);
        if(membership.isPresent()) {
            return membership.get().getRoleName();
        } else {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Role not found"
            );
        }
    }
}
