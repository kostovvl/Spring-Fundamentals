package spring.exam.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.exam.service.ProductService;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model,  HttpSession session) {

        if (session.getAttribute("user") == null) {
        return "index";
        }
        model.addAttribute("products", this.productService.findAllProducts());
        model.addAttribute("price", this.productService.getTotalPrice());

        System.out.println();
        return "home";
    }

}
