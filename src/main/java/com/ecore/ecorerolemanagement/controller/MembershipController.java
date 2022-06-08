package com.ecore.ecorerolemanagement.controller;


import com.ecore.ecorerolemanagement.model.MembershipModel;
import com.ecore.ecorerolemanagement.service.MembershipService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/memberships",  produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class MembershipController {
    private final MembershipService membershipService;

    @GetMapping
    public List<MembershipModel> getMembershipsByRole(@RequestParam Optional<String> roleName){
        if(roleName.isPresent() ) {
            return membershipService.getMembershipsByRole(roleName.get());
        }
        return membershipService.getAll();
    }

    // Does the same operation as POST /roles/assign
    @PostMapping
    public ResponseEntity<String> createMembership(@RequestBody MembershipModel membership) {
        membershipService.insert(membership);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
