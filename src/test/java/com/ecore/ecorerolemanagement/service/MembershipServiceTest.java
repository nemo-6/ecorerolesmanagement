package com.ecore.ecorerolemanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ecore.ecorerolemanagement.model.MembershipModel;
import com.ecore.ecorerolemanagement.repository.MembershipRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MembershipService.class})
@ExtendWith(SpringExtension.class)
class MembershipServiceTest {
    @MockBean
    private MembershipRepository membershipRepository;

    @Autowired
    private MembershipService membershipService;

    /**
     * Method under test: {@link MembershipService#insert(MembershipModel)}
     */
    @Test
    void testInsert() {
        // Arrange
        when(this.membershipRepository.insert((MembershipModel) any()))
                .thenReturn(new MembershipModel("42", "42", "42", "Role Name"));
        when(this.membershipRepository.findMembershipModelByRoleNameAndMemberIdAndTeamId((String) any(), (String) any(),
                (String) any())).thenReturn(Optional.of(new MembershipModel("42", "42", "42", "Role Name")));
        MembershipModel membershipModel = new MembershipModel("42", "42", "42", "Role Name");

        // Act
        this.membershipService.insert(membershipModel);

        // Assert that nothing has changed
        verify(this.membershipRepository).findMembershipModelByRoleNameAndMemberIdAndTeamId((String) any(), (String) any(),
                (String) any());
        assertEquals("42", membershipModel.getId());
        assertEquals("42", membershipModel.getTeamId());
        assertEquals("Role Name", membershipModel.getRoleName());
        assertEquals("42", membershipModel.getMemberId());
    }

    /**
     * Method under test: {@link MembershipService#insert(MembershipModel)}
     */
    @Test
    void testInsert2() {
        // Arrange
        when(this.membershipRepository.insert((MembershipModel) any()))
                .thenReturn(new MembershipModel("42", "42", "42", "Role Name"));
        when(this.membershipRepository.findMembershipModelByRoleNameAndMemberIdAndTeamId((String) any(), (String) any(),
                (String) any())).thenReturn(Optional.empty());
        MembershipModel membershipModel = new MembershipModel("42", "42", "42", "Role Name");

        // Act
        this.membershipService.insert(membershipModel);

        // Assert that nothing has changed
        verify(this.membershipRepository).insert((MembershipModel) any());
        verify(this.membershipRepository).findMembershipModelByRoleNameAndMemberIdAndTeamId((String) any(), (String) any(),
                (String) any());
        assertEquals("42", membershipModel.getId());
        assertEquals("42", membershipModel.getTeamId());
        assertEquals("Role Name", membershipModel.getRoleName());
        assertEquals("42", membershipModel.getMemberId());
    }


    @Test
    void testInsert4() {
        // Arrange
        when(this.membershipRepository.insert((MembershipModel) any()))
                .thenReturn(new MembershipModel("42", "42", "42", "Role Name"));
        when(this.membershipRepository.findMembershipModelByRoleNameAndMemberIdAndTeamId((String) any(), (String) any(),
                (String) any())).thenReturn(Optional.of(new MembershipModel("42", "42", "42", "Role Name")));
        MembershipModel membershipModel = new MembershipModel("42", "42", "42", "Role Name");

        // Act
        this.membershipService.insert(membershipModel);

        // Assert that nothing has changed
        verify(this.membershipRepository).findMembershipModelByRoleNameAndMemberIdAndTeamId((String) any(), (String) any(),
                (String) any());
        assertEquals("42", membershipModel.getId());
        assertEquals("42", membershipModel.getTeamId());
        assertEquals("Role Name", membershipModel.getRoleName());
        assertEquals("42", membershipModel.getMemberId());
    }

    @Test
    void testInsert5() {
        // Arrange
        when(this.membershipRepository.insert((MembershipModel) any()))
                .thenReturn(new MembershipModel("42", "42", "42", "Role Name"));
        when(this.membershipRepository.findMembershipModelByRoleNameAndMemberIdAndTeamId((String) any(), (String) any(),
                (String) any())).thenReturn(Optional.empty());
        MembershipModel membershipModel = new MembershipModel("42", "42", "42", "Role Name");

        // Act
        this.membershipService.insert(membershipModel);

        // Assert that nothing has changed
        verify(this.membershipRepository).insert((MembershipModel) any());
        verify(this.membershipRepository).findMembershipModelByRoleNameAndMemberIdAndTeamId((String) any(), (String) any(),
                (String) any());
        assertEquals("42", membershipModel.getId());
        assertEquals("42", membershipModel.getTeamId());
        assertEquals("Role Name", membershipModel.getRoleName());
        assertEquals("42", membershipModel.getMemberId());
    }


    /**
     * Method under test: {@link MembershipService#getMembershipsByRole(String)}
     */
    @Test
    void testGetMembershipsByRole() {
        // Arrange
        ArrayList<MembershipModel> membershipModelList = new ArrayList<>();
        when(this.membershipRepository.findMembershipModelByRoleName((String) any())).thenReturn(membershipModelList);

        // Act
        List<MembershipModel> actualMembershipsByRole = this.membershipService.getMembershipsByRole("Role Name");

        // Assert
        assertSame(membershipModelList, actualMembershipsByRole);
        assertTrue(actualMembershipsByRole.isEmpty());
        verify(this.membershipRepository).findMembershipModelByRoleName((String) any());
    }

    /**
     * Method under test: {@link MembershipService#getMembershipsByRole(String)}
     */
    @Test
    void testGetMembershipsByRole2() {
        // Arrange
        ArrayList<MembershipModel> membershipModelList = new ArrayList<>();
        when(this.membershipRepository.findMembershipModelByRoleName((String) any())).thenReturn(membershipModelList);

        // Act
        List<MembershipModel> actualMembershipsByRole = this.membershipService.getMembershipsByRole("Role Name");

        // Assert
        assertSame(membershipModelList, actualMembershipsByRole);
        assertTrue(actualMembershipsByRole.isEmpty());
        verify(this.membershipRepository).findMembershipModelByRoleName((String) any());
    }

    /**
     * Method under test: {@link MembershipService#getAll()}
     */
    @Test
    void testGetAll() {
        // Arrange
        ArrayList<MembershipModel> membershipModelList = new ArrayList<>();
        when(this.membershipRepository.findAll()).thenReturn(membershipModelList);

        // Act
        List<MembershipModel> actualAll = this.membershipService.getAll();

        // Assert
        assertSame(membershipModelList, actualAll);
        assertTrue(actualAll.isEmpty());
        verify(this.membershipRepository).findAll();
    }

    /**
     * Method under test: {@link MembershipService#getAll()}
     */
    @Test
    void testGetAll2() {
        // Arrange
        ArrayList<MembershipModel> membershipModelList = new ArrayList<>();
        when(this.membershipRepository.findAll()).thenReturn(membershipModelList);

        // Act
        List<MembershipModel> actualAll = this.membershipService.getAll();

        // Assert
        assertSame(membershipModelList, actualAll);
        assertTrue(actualAll.isEmpty());
        verify(this.membershipRepository).findAll();
    }
}

