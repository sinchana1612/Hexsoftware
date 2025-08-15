import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class URLShortener {
    private Map<String, String> urlMap; 
    private String domain; 
    private int counter; 

    public URLShortener(String domain) {
        this.urlMap = new HashMap<>();
        this.domain = domain.endsWith("/") ? domain : domain + "/";
        this.counter = 1;
    }

    public String expandURL(String shortURL) {
        String shortCode = shortURL.replace(domain, "");
        return urlMap.getOrDefault(shortCode, "URL not found!");
    }
    public String shortenURL(String longURL) {
        String shortenCode = Integer.toHexString(counter);
        String shortenURL = domain + shortenCode;
        urlMap.put(shortenCode, longURL);
        counter++;
        return shortenURL;
    }

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        URLShortener shortener = new URLShortener("http://shorturl.url");

        while (true) {
            System.out.println("\n1. Shorten URL");
            System.out.println("2. Expand URL");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter long URL: ");
                String longURL = sc.nextLine();
                String shortURL = shortener.shortenURL(longURL);
                System.out.println("Shortened URL: " + shortURL);
            } else if (choice == 2) {
                System.out.print("Enter shorten URL: ");
                String shortURL = sc.nextLine();
                String longURL = shortener.expandURL(shortURL);
                System.out.println("Original URL: " + longURL);
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}

