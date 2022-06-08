package com.ecore.ecorerolemanagement.util;

import com.ecore.ecorerolemanagement.model.TeamModel;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

public interface HttpClient {

    String get(String url);

    String post(String url, String body);

    Optional<TeamModel> getTeam(String url);
}
