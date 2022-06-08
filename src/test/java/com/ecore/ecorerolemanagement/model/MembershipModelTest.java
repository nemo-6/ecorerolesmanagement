package com.ecore.ecorerolemanagement.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MembershipModelTest {
    /**
     * Method under test: {@link MembershipModel#MembershipModel(String, String, String, String)}
     */
    @Test
    void testConstructor() {
        // Arrange and Act
        MembershipModel actualMembershipModel = new MembershipModel("42", "42", "42", "Role Name");

        // Assert
        assertEquals("42", actualMembershipModel.getId());
        assertEquals("42", actualMembershipModel.getTeamId());
        assertEquals("Role Name", actualMembershipModel.getRoleName());
        assertEquals("42", actualMembershipModel.getMemberId());
    }

    /**
     * Method under test: {@link MembershipModel#MembershipModel(String, String, String, String)}
     */
    @Test
    void testConstructor2() {
        // Arrange and Act
        MembershipModel actualMembershipModel = new MembershipModel("foo", "foo", "foo", null);

        // Assert
        assertEquals("foo", actualMembershipModel.getId());
        assertEquals("foo", actualMembershipModel.getTeamId());
        assertEquals("Developer", actualMembershipModel.getRoleName());
        assertEquals("foo", actualMembershipModel.getMemberId());
    }
}

