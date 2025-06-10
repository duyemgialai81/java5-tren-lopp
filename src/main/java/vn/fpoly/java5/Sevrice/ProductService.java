package vn.fpoly.java5.Sevrice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fpoly.java5.entity.Category;
import vn.fpoly.java5.entity.Product;
import vn.fpoly.java5.repository.ProductRepository;
import vn.fpoly.java5.repository.categoryRepository;

import java.util.List;

//
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private categoryRepository categoryRepository;
    public List<Product> getAll(){
        return productRepository.findAll();
    }
    public void save(Product product){
        Product add = new Product();
        add.setId(product.getId());
        add.setMa(product.getMa());
        add.setTen(product.getTen());
        add.setSoLuong(product.getSoLuong());
        add.setGiaBan(product.getGiaBan());
        add.setWebsite(product.getWebsite());
        Long categoryId = product.getCategory().getId();
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy danh mục có id = " + categoryId)).getCategory();
        add.setCategory(category);
    }

}
