package com.ecore.ecorerolemanagement.service;

import com.ecore.ecorerolemanagement.model.TeamModel;
import com.ecore.ecorerolemanagement.util.HttpClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TeamService {
    private final HttpClient client;

    public Optional<TeamModel> getTeam(String teamId) {
         return client.getTeam(teamId);
    }
}
