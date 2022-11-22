package ru.maaax.elasticsearchservice.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import ru.maaax.elasticsearchservice.entity.Product;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"authors.name\": \"?0\"}}]}}")
    Page<Product> findByAuthorsNameUsingCustomQuery(String name, Pageable pageable);
    @Query("{\"multi_match\": {\"query\": \"?0\", \"fields\": [\"name\"], \"fuzziness\": \"AUTO\"}}")
    Page<Product> findByName(String name, Pageable pageRequest);
}
