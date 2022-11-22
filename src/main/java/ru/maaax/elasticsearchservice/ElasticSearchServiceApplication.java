package ru.maaax.elasticsearchservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElasticSearchServiceApplication implements CommandLineRunner {
    @Value("${spring.elasticsearch.uris}")
    private String elasticUrl;

    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("1111111111111111111111111111");
        System.out.println(elasticUrl);
    }

}
