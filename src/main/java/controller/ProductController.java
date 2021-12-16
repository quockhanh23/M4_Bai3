package controller;
import model.Customer;
import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.IProductService;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService iProductService = new ProductService();
    @GetMapping("")
    public String index(Model model, String find) {
        List<Product> productList;
        if (find == null) {
            productList= iProductService.findAll();
        } else {
            productList = iProductService.findByName(find);
        }
        model.addAttribute("products", productList);
        return "/index_product";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("products", new Product());
        return "/create_product";
    }

    @PostMapping("/save")
    public String saveProduct(Product product) {
        product.setId((int) (Math.random() * 10000));
        iProductService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit_product")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("products", iProductService.findById(id));
        return "/edit_product";
    }

    @PostMapping("/update")
    public String update(Product product) {
        iProductService.update(product.getId(), product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("products1", iProductService.findById(id));
        return "/delete_product";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        iProductService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("products", iProductService.findById(id));
        return "/view_product";
    }

}
