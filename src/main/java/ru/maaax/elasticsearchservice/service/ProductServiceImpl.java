package ru.maaax.elasticsearchservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.maaax.elasticsearchservice.dto.ProductDtoRequest;
import ru.maaax.elasticsearchservice.entity.Product;
import ru.maaax.elasticsearchservice.repository.ProductRepository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product save(final ProductDtoRequest productDtoRequest) {
        final Product product = new Product();
        product.setId(productDtoRequest.getId());
        product.setName(productDtoRequest.getName());
        product.setDescription(productDtoRequest.getDescription());
        return productRepository.save(product);
    }

    @Override
    public Iterable<Product> saveAll(final Iterable<ProductDtoRequest> products) {
        return StreamSupport.stream(products.spliterator(), false).map(this::save).collect(Collectors.toList());
    }

    @Override
    public void delete(final Product product) {
        productRepository.delete(product);
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }

    @Override
    public Product findOne(final String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findByName(final String name, final Pageable pageRequest) {
        return productRepository.findByName(name, pageRequest);
    }

    @Override
    public Page<Product> findByNameAndDescription(final String name, final String description, final Pageable pageRequest) {
        return productRepository.findByNameAndDescription(name, description, pageRequest);
    }

    @Override
    public Page<Product> findByNameOrDescription(final String name, final String description, final Pageable pageRequest) {
        return productRepository.findByNameContainsOrDescriptionContains(name, description, pageRequest);
    }
}
