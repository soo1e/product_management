package kr.co.soo1e.product.management.presentation;

import kr.co.soo1e.product.management.application.SimpleProductService;
import kr.co.soo1e.product.management.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    // 추가 부분 시작
    private SimpleProductService simpleProductService;

    @Autowired
    ProductController(SimpleProductService simpleProductService) {
        this.simpleProductService = simpleProductService;
    }
    // 추가 부분 종료

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        // Product를 생성하고 리스트에 넣는 작업이 필요함
        return simpleProductService.add(productDTO);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ProductDTO findProductById(@PathVariable Long id) {
        return simpleProductService.findById(id);
    }

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public List<ProductDTO> findAllProduct() {
        return simpleProductService.findAll();
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<ProductDTO> findProducts(@RequestParam(required = false) String name) {
        if (null == name) {
            return simpleProductService.findAll();
        }

        return simpleProductService.findByNameContaining(name);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        productDTO.setId(id);
        return simpleProductService.update(productDTO);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable Long id) {
        simpleProductService.delete(id);
    }
}
