package vn.fpoly.java5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.fpoly.java5.Sevrice.ProductService;
import vn.fpoly.java5.entity.Product;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list-product")
    public String t(Model model){
        model.addAttribute("products",productService.getAll());
        return "product/product-list";
    }
    @PostMapping("/save-product")
    public String save(Product product){
        productService.save(product);
        return "redirect:/api/list-product";
    }


//    @GetMapping("/products/{size}/{number}")
//    public String product(@PathVariable("size") int pageSize, @PathVariable("number") int pageNumber) {
//        System.out.println("pageSize: " + pageSize);
//        System.out.println("pageNumber: " + pageNumber);
//        return "/product/product-list";
//    }
//
//    @GetMapping("/categories")
//    public String categories(Model model) {
//        Map<String, String> categories = new LinkedHashMap<>();
//        categories.put("1", "Category 1");
//        categories.put("2", "Category 2");
//        categories.put("3", "Category 3");
//        categories.put("4", "Category 4");
//        model.addAttribute("categories", categories);
//        model.addAttribute("selectedId", "3");
//        return "/product/categories";
//    }
}
