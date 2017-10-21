package pl.com.bottega.ecom.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Transactional
public class ProductController {

    @Autowired
    private ProductRepostitory repostitory;

    @PostMapping
    public void create(@RequestBody Product product) {
        repostitory.save(product);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        repostitory.save(product);
    }

    @GetMapping("/{id}")
    public Product get(Long id) {
        return repostitory.findOne(id);
    }

    @GetMapping
    public Iterable<Product> all() {
        return repostitory.findAll();
    }

}
