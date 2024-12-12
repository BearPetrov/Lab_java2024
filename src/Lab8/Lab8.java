package Lab8;
import java.util.*;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.recommendedPrice, recommendedPrice) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, recommendedPrice);
    }

    @Override
    public String toString() {
        return name + " (Recommended Price: " + recommendedPrice + ")";
    }
}

class OnlineStore {
    private String name;
    private Map<Product, Double> productPriceMap;

    public OnlineStore(String name, Map<Product, Double> productPriceMap) {
        this.name = name;
        this.productPriceMap = productPriceMap;
    }

    public String getName() {
        return name;
    }

    public Map<Product, Double> getProductPriceMap() {
        return productPriceMap;
    }

    @Override
    public String toString() {
        return "Store: " + name;
    }
}

class ProductSearchService {
    private Set<OnlineStore> stores;

    public ProductSearchService(Set<OnlineStore> stores) {
        this.stores = stores;
    }

    // Завдання 1: знайти мінімальну ціну на заданий товар
    public double findMinimumPrice(String productName) {
        double minPrice = Double.MAX_VALUE;
        for (OnlineStore store : stores) {
            for (Map.Entry<Product, Double> entry : store.getProductPriceMap().entrySet()) {
                if (entry.getKey().getName().equals(productName)) {
                    minPrice = Math.min(minPrice, entry.getValue());
                }
            }
        }
        return minPrice == Double.MAX_VALUE ? -1 : minPrice;
    }

    // Завдання 2: скласти список магазинів з мінімальною ціною
    public Set<String> getStoresWithMinimumPrice(String productName) {
        Set<String> result = new HashSet<>();
        double minPrice = findMinimumPrice(productName);
        if (minPrice == -1) return result;

        for (OnlineStore store : stores) {
            for (Map.Entry<Product, Double> entry : store.getProductPriceMap().entrySet()) {
                if (entry.getKey().getName().equals(productName) &&
                        entry.getValue() == minPrice) {
                    result.add(store.getName());
                    break;
                }
            }
        }
        return result;
    }

    // Завдання 3: чи є магазин, усі товари якого дешевші за рекомендовану ціну
    public boolean hasStoreWithAllCheaperThanRecommended() {
        for (OnlineStore store : stores) {
            boolean allCheaper = true;
            for (Map.Entry<Product, Double> entry : store.getProductPriceMap().entrySet()) {
                if (entry.getValue() >= entry.getKey().getRecommendedPrice()) {
                    allCheaper = false;
                    break;
                }
            }
            if (allCheaper) return true;
        }
        return false;
    }
}

public class Lab8 {
    public static void main(String[] args) {

        Product phone = new Product("Phone", 800);
        Product laptop = new Product("Laptop", 1500);
        Product tablet = new Product("Tablet", 500);

        OnlineStore store1 = new OnlineStore("Rozetka", new HashMap<>(Map.of(
                phone, 780.0,
                laptop, 1550.0
        )));

        OnlineStore store2 = new OnlineStore("GadgetStore", new HashMap<>(Map.of(
                phone, 800.0,
                tablet, 450.0
        )));

        OnlineStore store3 = new OnlineStore("Mall", new HashMap<>(Map.of(
                phone, 750.0,
                laptop, 1400.0,
                tablet, 490.0
        )));

        ProductSearchService service = new ProductSearchService(Set.of(store1, store2, store3));

        // Завдання 1
        System.out.println("Minimum price for Phone: " + service.findMinimumPrice("Phone"));

        // Завдання 2
        System.out.println("Stores with minimum price for Phone: " + service.getStoresWithMinimumPrice("Phone"));

        // Завдання 3
        System.out.println("Is there a store where all products are cheaper than recommended price?");
        System.out.println(service.hasStoreWithAllCheaperThanRecommended());
    }
}