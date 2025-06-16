package dev.omriyahoo.mcp_spring_java.config;

import dev.omriyahoo.mcp_spring_java.service.GraphQLService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MCPConfig {

    private final GraphQLService graphQLService;

    @Autowired
    public MCPConfig(GraphQLService graphQLService) {
        this.graphQLService = graphQLService;
    }

    @Bean
    ToolCallbackProvider userTools() {
        return MethodToolCallbackProvider.builder().toolObjects(graphQLService).build();
    }

}
