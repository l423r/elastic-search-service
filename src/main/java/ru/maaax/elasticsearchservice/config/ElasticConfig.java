package ru.maaax.elasticsearchservice.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "ru.maaax.elasticsearchservice.repository")
public class ElasticConfig {
    @Bean
    public ElasticsearchTransport client() {
        RestClient httpClient = RestClient.builder(
                new HttpHost("localhost", 9200)
        ).build();
// Create the Java API Client with the same low level client

        return new RestClientTransport(
                httpClient,
                new JacksonJsonpMapper()
        );
    }

    @Bean
    public ElasticsearchClient elasticsearchClient() {
        return new ElasticsearchClient(client());
    }
}
