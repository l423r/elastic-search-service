package ru.maaax.elasticsearchservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.maaax.elasticsearchservice.dto.ProductDtoRequest;
import ru.maaax.elasticsearchservice.entity.Product;

public interface ProductService {

    Product save(ProductDtoRequest productDtoRequest);

    Iterable<Product> saveAll(Iterable<ProductDtoRequest> products);

    void delete(Product product);

    void deleteAll();

    Product findOne(String id);

    Iterable<Product> findAll();

    Page<Product> findByName(String name, Pageable pageRequest);

    Page<Product> findByNameAndDescription(String name, String description, Pageable pageRequest);

    Page<Product> findByNameOrDescription(String name, String description, Pageable pageRequest);
}
