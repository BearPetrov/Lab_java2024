package Lab8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Product {
    private String name;
    private double recommendedPrice;

    public Product(String name, double recommendedPrice) {
        this.name = name;
        this.recommendedPrice = recommendedPrice;
    }

    public String getName() {
        return name;
    }

    public double getRecommendedPrice() {
        return recommendedPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', recommendedPrice=" + recommendedPrice + "}";
    }
}

class OnlineStore {
    private String name;
    private Set<Product> products = new HashSet<>();
    private Map<Product, Double> productPrices = new HashMap<>();

    public OnlineStore(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product, double price) {
        products.add(product);
        productPrices.put(product, price);
    }

    public Double getPrice(Product product) {
        return productPrices.get(product);
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return name ;
    }
}

class ProductSearchService {
    private Set<OnlineStore> stores = new HashSet<>();

    public void addStore(OnlineStore store) {
        stores.add(store);
    }

    public Set<OnlineStore> getStores() {
        return stores;
    }

    public double findMinPrice(Product product) {
        double minPrice = Double.MAX_VALUE;
        for (OnlineStore store : stores) {
            Double price = store.getPrice(product);
            if (price != null && price < minPrice) {
                minPrice = price;
            }
        }
        return minPrice == Double.MAX_VALUE ? -1 : minPrice;
    }

    public Set<OnlineStore> findStoresWithMinPrice(Product product) {
        double minPrice = findMinPrice(product);
        Set<OnlineStore> result = new HashSet<>();
        for (OnlineStore store : stores) {
            if (Double.valueOf(minPrice).equals(store.getPrice(product))) {
                result.add(store);
            }
        }
        return result;
    }

    public boolean isAllProductsBelowRecommendedPrice(OnlineStore store) {
        for (Product product : store.getProducts()) {
            double price = store.getPrice(product);
            if (price >= product.getRecommendedPrice()) {
                return false;
            }
        }
        return true;
    }
}


public class Lab8 {
    public static void main(String[] args) {

        Product product1 = new Product("Телевізор", 500.0);
        Product product2 = new Product("Смартфон", 300.0);
        Product product3 = new Product("Ноутбук", 1000.0);

        OnlineStore store1 = new OnlineStore("Магазин 1");
        store1.addProduct(product1, 480.0);
        store1.addProduct(product2, 290.0);
        store1.addProduct(product3, 1050.0);

        OnlineStore store2 = new OnlineStore("Магазин 2");
        store2.addProduct(product1, 400.0);
        store2.addProduct(product2, 270.0);
        store2.addProduct(product3, 950.0);

        OnlineStore store3 = new OnlineStore("Магазин 3");
        store3.addProduct(product1, 470.0);
        store3.addProduct(product2, 310.0);
        store3.addProduct(product3, 980.0);

        ProductSearchService service = new ProductSearchService();
        service.addStore(store1);
        service.addStore(store2);
        service.addStore(store3);

        // 1. Знайти мінімальну ціну на товар
        Product targetProduct = product1;
        double minPrice = service.findMinPrice(targetProduct);
        System.out.println("Мінімальна ціна на " + targetProduct.getName() + ": " + minPrice);

        // 2. Знайти магазини з мінімальною ціною на товар
        Set<OnlineStore> minPriceStores = service.findStoresWithMinPrice(targetProduct);
        System.out.println("Магазини з мінімальною ціною на " + targetProduct.getName() + ": " + minPriceStores);

        // 3. Перевірити, чи є магазин, де всі товари дешевші за рекомендовану ціну
        for (OnlineStore store : service.getStores()) {
            boolean isBelowRecommended = service.isAllProductsBelowRecommendedPrice(store);
            System.out.println("У магазині " + store.getName() + " всі товари дешевші за рекомендовану ціну: " + isBelowRecommended);
        }
    }
}
