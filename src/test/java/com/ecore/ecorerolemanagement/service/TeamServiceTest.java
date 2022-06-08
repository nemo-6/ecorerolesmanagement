package com.ecore.ecorerolemanagement.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ecore.ecorerolemanagement.model.TeamModel;
import com.ecore.ecorerolemanagement.util.HttpClient;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TeamService.class})
@ExtendWith(SpringExtension.class)
class TeamServiceTest {
    @MockBean
    private HttpClient httpClient;

    @Autowired
    private TeamService teamService;

    @Test
    void testGetTeam() {
        // With
        TeamModel team = new TeamModel();
        team.setId("1");
        team.setName("Artful Ardvark");
        team.setTeamLeadId("1");
        team.setTeamMemberIds(new ArrayList<>());
        Optional<TeamModel> result = Optional.of(team);
        when(this.httpClient.getTeam((String) any())).thenReturn(result);

        // Then
        Optional<TeamModel> expected = this.teamService.getTeam("1");

        // Assert
        assertSame(result, expected);
        assertTrue(expected.isPresent());
        verify(this.httpClient).getTeam((String) any());
    }
}