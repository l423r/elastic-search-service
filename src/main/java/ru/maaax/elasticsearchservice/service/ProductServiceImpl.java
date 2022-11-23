package ru.maaax.elasticsearchservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product save(final ProductDto productDto) {
        final Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        final Product saved = productRepository.save(product);
        log.info("Добавлен продукт {}", saved.getId());
        return saved;
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
    public void deleteById(final String id) {
        productRepository.deleteById(id);
        log.info("Удален продукт {}", id);
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

    @Override
    public Long getCount() {
        return productRepository.count();
    }

}
