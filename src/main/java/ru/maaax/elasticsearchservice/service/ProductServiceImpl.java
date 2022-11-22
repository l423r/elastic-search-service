package ru.maaax.elasticsearchservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.maaax.elasticsearchservice.dto.ProductDto;
import ru.maaax.elasticsearchservice.entity.Product;
import ru.maaax.elasticsearchservice.repository.ProductRepository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product save(final ProductDto productDto) {
        final Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        return productRepository.save(product);
    }

    @Override
    public Iterable<Product> saveAll(final Iterable<ProductDto> products) {
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
    public Page<Product> findAll(final Pageable pageRequest) {
        return productRepository.findAll(pageRequest);
    }

    @Override
    public Page<Product> findByName(final String name, final Pageable pageRequest) {
        return productRepository.findByName(name, pageRequest);
    }

}
