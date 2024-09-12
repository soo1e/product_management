package kr.co.soo1e.product.management.application;

import kr.co.soo1e.product.management.domain.Product;
import kr.co.soo1e.product.management.infrastructure.ListProductRepository;
import kr.co.soo1e.product.management.presentation.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
public class SimpleProductService {
    private ListProductRepository listProductRepository;
    private ModelMapper modelMapper;

    @Autowired
    SimpleProductService(ListProductRepository listProductRepository, ModelMapper modelMapper) {
        this.listProductRepository = listProductRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDTO add(ProductDTO productDTO) {
        // 1. ProductDTO를 Product로 변환하는 코드
        Product product = modelMapper.map(productDTO, Product.class);

        // 2. 레포지토리를 호출하는 코드
        Product savedProduct = listProductRepository.add(product);

        // 3. Product를 ProductDTO로 변환하는 코드
        ProductDTO savedProductDTO = modelMapper.map(savedProduct, ProductDTO.class);

        // 4. DTO를 반환하는 코드
        return savedProductDTO;
    }

    public ProductDTO findById(Long id) {
        Product product = listProductRepository.findById(id);
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return productDTO;
    }

    public List<ProductDTO> findAll() {
        List<Product> products = listProductRepository.findAll();
        List<ProductDTO> productDTOs = products.stream().map(product -> modelMapper.map(product, ProductDTO.class)).toList();
        return productDTOs;
    }

    public List<ProductDTO> findByNameContaining(String name) {
        List<Product> products = listProductRepository.findByNameContaining(name);
        List<ProductDTO> productDTOs = products.stream().map(product -> modelMapper.map(product, ProductDTO.class)).toList();
        return productDTOs;
    }

    public ProductDTO update(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        Product updatedProduct = listProductRepository.update(product);
        ProductDTO updatedProductDTO = modelMapper.map(updatedProduct, ProductDTO.class);
        return updatedProductDTO;
    }

    public void delete(Long id) {
        listProductRepository.delete(id);
    }
}
