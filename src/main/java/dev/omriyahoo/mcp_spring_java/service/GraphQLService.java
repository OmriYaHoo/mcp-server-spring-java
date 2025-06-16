package dev.omriyahoo.mcp_spring_java.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class GraphQLService {

    private final RestTemplate restTemplate;
    private final String BASE_URL = "http://192.168.0.50:9001";

    public GraphQLService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    @Tool(name = "getGraphQLSchema", description = "Get GraphQL schema")
    public String getGraphQLSchema() {
        String url = BASE_URL + "/schema"; // Use localhost since this runs on your machine
        try {
            return restTemplate.exchange(url, HttpMethod.GET, null, String.class).getBody();
        } catch (Exception e) {
            return "Error fetching schema: " + e.getMessage();
        }
    }

    @Tool(name = "executeGraphQLQuery", description = "Execute a GraphQL query")
    public String executeGraphQLQuery(String query) {
        String url = BASE_URL + "/graphql";
        try {
            Map<String, String> requestBody = new HashMap<>();
            requestBody.put("query", query);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

            return response.getBody();
        } catch (Exception e) {
            return "Error executing GraphQL query: " + e.getMessage();
        }
    }
}