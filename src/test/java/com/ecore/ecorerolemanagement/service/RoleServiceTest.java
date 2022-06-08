package com.ecore.ecorerolemanagement.service;

import com.ecore.ecorerolemanagement.model.MembershipModel;
import com.ecore.ecorerolemanagement.model.RoleModel;
import com.ecore.ecorerolemanagement.repository.MembershipRepository;
import com.ecore.ecorerolemanagement.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {RoleService.class})
@ExtendWith(SpringExtension.class)
class RoleServiceTest {
    @MockBean
    private MembershipRepository membershipRepository;

    @MockBean
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    private ArrayList<RoleModel> expected;

    private ArrayList<RoleModel> populateRoles() {
        ArrayList<RoleModel> list = new ArrayList<>();

        var dev = new RoleModel();
        dev.setName("Developer");
        list.add(dev);

        var po = new RoleModel();
        po.setName("Product Owner");
        list.add(po);

        var tester = new RoleModel();
        tester.setName("Tester");
        list.add(tester);

        return list;
    }

    @Test
    void testFindAll() {
        // With
        when(this.roleRepository.findAll()).thenReturn(expected);

        // Then
        List<RoleModel> result = this.roleService.findAll();

        // Assert
        assertSame(expected, result);
        verify(this.roleRepository).findAll();
    }

    @Test
    void testInsert() {
        // With
        var dev = new RoleModel();
        dev.setName("Developer");
        RoleRepository mockedRoleRepository = mock(RoleRepository.class);

        // Then
        mockedRoleRepository.insert(dev);

        // Assert
        verify(mockedRoleRepository).insert(dev);
    }

    @Test
    void testFindDefaultRoles() {
        // With
        ArrayList<RoleModel> roleModelList = new ArrayList<>();
        when(this.roleRepository.findDefaultRoles()).thenReturn(roleModelList);

        // Then
        List<RoleModel> actualFindDefaultRolesResult = this.roleService.findDefaultRoles();

        // Assert
        assertSame(roleModelList, actualFindDefaultRolesResult);
        verify(this.roleRepository).findDefaultRoles();
    }

    @Test
    void testFindRoleNameByMembership() {
        // With
        List<MembershipModel> expected = new ArrayList();
                expected.add(new MembershipModel("42", "42", "42", "Role Name"));
        when(this.membershipRepository.findMembershipModelsByTeamIdAndMemberId((String) any(), (String) any()))
                .thenReturn(expected);

        // Then
        List<MembershipModel> result = this.roleService.findRoleNameByMembership("42",
                "42");

        // Assert
        assertSame(expected, result);
        verify(this.membershipRepository).findMembershipModelsByTeamIdAndMemberId((String) any(), (String) any());
    }
}
