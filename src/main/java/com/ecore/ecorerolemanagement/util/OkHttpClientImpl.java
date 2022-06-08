package com.ecore.ecorerolemanagement.util;

import com.ecore.ecorerolemanagement.model.TeamModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class OkHttpClientImpl implements HttpClient {

    private static final String TEAMS_URL = "https://cgjresszgg.execute-api.eu-west-1.amazonaws.com/teams/";

    @Override
    public Optional<TeamModel> getTeam(String teamId) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(TEAMS_URL + teamId)
                .build();
        Call call = client.newCall(request);
        TeamModel team = null;
        try {
            Response response = call.execute();
            ObjectMapper objectMapper = new ObjectMapper();
            team = objectMapper.readValue(response.body().string(), TeamModel.class);
        } catch (IOException e) {
            return Optional.empty();
        }
        return Optional.of(team);
    }

    public String get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String post(String url, String jsonBody) {
        RequestBody formBody = new FormBody.Builder()
                .add("username", "test")
                .add("password", "test")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
