package com.ecore.ecorerolemanagement.controller;

import com.ecore.ecorerolemanagement.model.MembershipModel;
import com.ecore.ecorerolemanagement.model.RoleModel;
import com.ecore.ecorerolemanagement.service.MembershipService;
import com.ecore.ecorerolemanagement.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/roles",  produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;
    private final MembershipService membershipService;

    // Create a new role
    @PostMapping
    public void insertRole(@RequestBody RoleModel role) {
        roleService.insert(role);
    }

    /*
     Create a new membership, assigning a *role* to a *team member* within a *team*
     Does the same operation as POST /memberships
    * */
    @PostMapping("/assign")
    public void assignRole(@RequestBody MembershipModel membership) {
        this.membershipService.insert(membership);
    }

    // Get all roles
    @GetMapping()
    public ResponseEntity<List<RoleModel>> getAllRoles() {
        return new ResponseEntity<>(this.roleService.findAll(), HttpStatus.FOUND);
    }

    // Given a *team member* within a *team*, find out if they have one or more *role* assigned
    @GetMapping("/search")
    public ResponseEntity<List<String>> findRoleNameByMembership(
            @RequestParam String memberId,
            @RequestParam String teamId) {
        List<MembershipModel> membership = roleService.findRoleNameByMembership(
                memberId,
                teamId);
        if(!membership.isEmpty()) {
            List<String> names = membership.stream().map(MembershipModel::getRoleName).toList();
            return new ResponseEntity<>(names, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
