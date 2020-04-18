package practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import practice.model.Product;
import practice.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ModelAndView allProducts() {
        List<Product> products = productService.allProducts();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("products");
        modelAndView.addObject("productList", products);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") int id) {
        Product product = productService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("product", product);
        modelAndView.addObject("product", productService.getById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editProduct(@ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        productService.edit(product);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addProduct(@ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        productService.add(product);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Product product = productService.getById(id);
        productService.delete(product);
        return modelAndView;
    }

}