package service;


import model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "haha", 1, "alo1", "alo"));
        productList.add(new Product(2, "alo", 1, "alo2", "alo"));
        productList.add(new Product(3, "Bánh bao", 1, "alo3", "alo"));
        productList.add(new Product(4, "Bánh rán", 1, "alo4", "alo"));
        productList.add(new Product(5, "Bánh", 1, "alo5", "alo"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);

    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
           if (productList.get(i).getId()==id) {
               return productList.get(i);
           }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        productList.set(findIndexById(id), product);
    }

    @Override
    public void remove(int id) {
        productList.remove(findIndexById(id));

    }

    @Override
        public List<Product> findByName(String name) {
            List<Product> productList1 = new ArrayList<>();
            for(int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getName().contains(name)) {
                    productList1.add(productList.get(i));
                }
            }
            return productList1;
    }

    public int findIndexById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

}
