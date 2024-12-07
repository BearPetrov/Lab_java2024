package Lab7;
import java.util.*;

    class Product {
        private final String name;
        private final double recommendedPrice;

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
            return String.format("Product{name='%s', recommendedPrice=%.2f}", name, recommendedPrice);
        }
    }

    class OnlineStore {
        private final String name;
        private final Map<Product, Double> productsWithPrices;

        public OnlineStore(String name) {
            this.name = name;
            this.productsWithPrices = new HashMap<>();
        }

        public String getName() {
            return name;
        }

        public Map<Product, Double> getProductsWithPrices() {
            return productsWithPrices;
        }

        public void addProduct(Product product, double price) {
            productsWithPrices.put(product, price);
        }

        @Override
        public String toString() {
            return String.format("OnlineStore{name='%s', products=%s}", name, productsWithPrices);
        }
    }

    class ProductSearchService {
        private final List<OnlineStore> stores;

        public ProductSearchService() {
            this.stores = new ArrayList<>();
        }

        public void addStore(OnlineStore store) {
            stores.add(store);
        }

        // Задача 1: знайти мінімальну ціну на заданий товар (нетипізований ітератор)
        public double findMinPrice(String productName) {
            double minPrice = Double.MAX_VALUE;
            Iterator<OnlineStore> iterator = stores.iterator();

            while (iterator.hasNext()) {
                OnlineStore store = iterator.next();
                for (Map.Entry<Product, Double> entry : store.getProductsWithPrices().entrySet()) {
                    if (entry.getKey().getName().equals(productName)) {
                        minPrice = Math.min(minPrice, entry.getValue());
                    }
                }
            }

            return minPrice == Double.MAX_VALUE ? -1 : minPrice;
        }

        // Задача 2: список магазинів, де товар можна купити за мінімальною ціною (for-each цикл)
        public List<String> findStoresWithMinPrice(String productName) {
            double minPrice = findMinPrice(productName);
            List<String> result = new ArrayList<>();

            for (OnlineStore store : stores) {
                for (Map.Entry<Product, Double> entry : store.getProductsWithPrices().entrySet()) {
                    if (entry.getKey().getName().equals(productName) && entry.getValue() == minPrice) {
                        result.add(store.getName());
                    }
                }
            }

            return result;
        }

        // Задача 3: чи є магазин, усі товари якого дешевші за рекомендовану ціну (типізований ітератор)
        public boolean isStoreCheaperThanRecommended() {
            ListIterator<OnlineStore> iterator = stores.listIterator();

            while (iterator.hasNext()) {
                OnlineStore store = iterator.next();
                boolean allCheaper = true;

                for (Map.Entry<Product, Double> entry : store.getProductsWithPrices().entrySet()) {
                    if (entry.getValue() >= entry.getKey().getRecommendedPrice()) {
                        allCheaper = false;
                        break;
                    }
                }

                if (allCheaper) {
                    return true;
                }
            }

            return false;
        }
    }

    public class Lab7 {
        public static void main(String[] args) {

            Product product1 = new Product("Laptop", 1000);
            Product product2 = new Product("Phone", 500);
            Product product3 = new Product("Tablet", 300);

            OnlineStore store1 = new OnlineStore("TechStore");
            store1.addProduct(product1, 950);
            store1.addProduct(product2, 450);

            OnlineStore store2 = new OnlineStore("GadgetShop");
            store2.addProduct(product1, 1000);
            store2.addProduct(product3, 290);

            OnlineStore store3 = new OnlineStore("DiscountMart");
            store3.addProduct(product1, 920);
            store3.addProduct(product2, 400);
            store3.addProduct(product3, 280);

            ProductSearchService service = new ProductSearchService();
            service.addStore(store1);
            service.addStore(store2);
            service.addStore(store3);


            System.out.println("Задача 1: Мінімальна ціна на 'Laptop':");
            System.out.println(service.findMinPrice("Laptop"));

            System.out.println("Задача 2: Магазини з мінімальною ціною на 'Laptop':");
            System.out.println(service.findStoresWithMinPrice("Laptop"));

            System.out.println("Задача 3: Чи є магазин, усі товари якого дешевші за рекомендовану ціну?");
            System.out.println(service.isStoreCheaperThanRecommended());
        }
    }

