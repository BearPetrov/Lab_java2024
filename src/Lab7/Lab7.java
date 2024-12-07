package Lab7;
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
    public String toString() {
        return name + " (Recommended Price: " + recommendedPrice + ")";
    }
}

class OnlineStore {
    private String name;
    private List<Pair<Product, Double>> products;

    public OnlineStore(String name, List<Pair<Product, Double>> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public List<Pair<Product, Double>> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Store: " + name;
    }
}

class ProductSearchService {
    private List<OnlineStore> stores;

    public ProductSearchService(List<OnlineStore> stores) {
        this.stores = stores;
    }

    // Завдання 1: знайти мінімальну ціну на заданий товар (Iterator)
    public double findMinimumPrice(String productName) {
        double minPrice = Double.MAX_VALUE;
        Iterator<OnlineStore> iterator = stores.iterator(); // нетипізований ітератор
        while (iterator.hasNext()) {
            OnlineStore store = iterator.next();
            for (Pair<Product, Double> productEntry : store.getProducts()) {
                if (productEntry.getKey().getName().equals(productName)) {
                    minPrice = Math.min(minPrice, productEntry.getValue());
                }
            }
        }
        return minPrice == Double.MAX_VALUE ? -1 : minPrice; // -1 якщо товар не знайдено
    }

    // Завдання 2: скласти список магазинів з мінімальною ціною (for-each)
    public List<String> getStoresWithMinimumPrice(String productName) {
        List<String> result = new ArrayList<>();
        double minPrice = findMinimumPrice(productName);
        if (minPrice == -1) return result;

        for (OnlineStore store : stores) {
            for (Pair<Product, Double> productEntry : store.getProducts()) {
                if (productEntry.getKey().getName().equals(productName) &&
                        productEntry.getValue() == minPrice) {
                    result.add(store.getName());
                    break;
                }
            }
        }
        return result;
    }

    // Завдання 3: чи є магазин, усі товари якого дешевші за рекомендовану ціну (типізований ітератор)
    public boolean hasStoreWithAllCheaperThanRecommended() {
        for (OnlineStore store : stores) {
            boolean allCheaper = true;
            Iterator<Pair<Product, Double>> iterator = store.getProducts().iterator(); // типізований ітератор
            while (iterator.hasNext()) {
                Pair<Product, Double> productEntry = iterator.next();
                if (productEntry.getValue() >= productEntry.getKey().getRecommendedPrice()) {
                    allCheaper = false;
                    break;
                }
            }
            if (allCheaper) return true;
        }
        return false;
    }
}

// Клас Pair (власна реалізація)
class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}

public class Lab7 {
    public static void main(String[] args) {

        Product phone = new Product("Phone", 800);
        Product laptop = new Product("Laptop", 1500);
        Product tablet = new Product("Tablet", 500);

        OnlineStore store1 = new OnlineStore("TechShop", Arrays.asList(
                new Pair<>(phone, 780.0),
                new Pair<>(laptop, 1550.0)
        ));

        OnlineStore store2 = new OnlineStore("GadgetWorld", Arrays.asList(
                new Pair<>(phone, 800.0),
                new Pair<>(tablet, 450.0)
        ));

        OnlineStore store3 = new OnlineStore("ElectroMall", Arrays.asList(
                new Pair<>(phone, 790.0),
                new Pair<>(laptop, 1400.0),
                new Pair<>(tablet, 490.0)
        ));

        // Додати магазини до сервісу пошуку
        ProductSearchService service = new ProductSearchService(Arrays.asList(store1, store2, store3));

        // Завдання 1
        System.out.println("Minimum price for Phone: " + service.findMinimumPrice("Phone"));

        // Завдання 2
        System.out.println("Stores with minimum price for Phone: " + service.getStoresWithMinimumPrice("Phone"));

        // Завдання 3
        System.out.println("Is there a store where all products are cheaper than recommended price?");
        System.out.println(service.hasStoreWithAllCheaperThanRecommended());
    }
}