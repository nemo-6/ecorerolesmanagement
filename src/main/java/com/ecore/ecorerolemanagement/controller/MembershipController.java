package com.ecore.ecorerolemanagement.controller;


import com.ecore.ecorerolemanagement.model.MembershipModel;
import com.ecore.ecorerolemanagement.service.MembershipService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/membership",  produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class MembershipController {
    private final MembershipService membershipService;

    @GetMapping
    public List<MembershipModel> getMembershipsByRole(@RequestParam String roleName){
        return membershipService.getMembershipsByRole(roleName);
    }

    @PostMapping
    public void createMembership(@RequestBody MembershipModel membership) {
        membershipService.insert(membership);
    }
}
