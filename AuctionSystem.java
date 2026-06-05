import java.util.Scanner;

// Item class
class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Auction class
class Auction {
    private Item[] items;
    private boolean auctionActive = false;
    private int currentItemIndex = -1;

    private double highestBid;
    private String highestBidder;

    public Auction(Item[] items) {
        this.items = items;
    }

    // View all items
    public void viewItems() {
        System.out.println("\n--- Available Items ---");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i].getName() +
                    " - $" + items[i].getPrice());
        }
    }

    // Start auction for selected item
    public void startAuction(int index) {
        if (auctionActive) {
            System.out.println("\nAuction already active.");
            return;
        }

        if (index < 0 || index >= items.length) {
            System.out.println("\nInvalid item selection.");
            return;
        }

        currentItemIndex = index;
        auctionActive = true;
        highestBid = items[index].getPrice();
        highestBidder = "No bidder yet";

        System.out.println("\nAuction started for: " + items[index].getName());
    }

    // Place bid
    public void placeBid(String bidderName, double bidAmount) {
        if (!auctionActive) {
            System.out.println("\nAuction not active.");
            return;
        }

        if (bidAmount > highestBid) {
            highestBid = bidAmount;
            highestBidder = bidderName;
            System.out.println("\nBid accepted!");
        } else {
            System.out.println("\nBid rejected! Must be higher than $" + highestBid);
        }
    }

    // End auction
    public void endAuction() {
        if (!auctionActive) {
            System.out.println("\nNo active auction.");
            return;
        }

        auctionActive = false;

        System.out.println("\nAuction ended for: " + items[currentItemIndex].getName());
        displayWinner();
    }

    // Display winner
    public void displayWinner() {
        System.out.println("\n--- Winner ---");
        if (highestBidder.equals("No bidder yet")) {
            System.out.println("No bids placed.");
        } else {
            System.out.println("Winner: " + highestBidder);
            System.out.println("Winning Bid: $" + highestBid);
        }
    }
}

// Main class
public class AuctionSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Arrays for items and prices
        String[] itemNames = {"Laptop", "Phone", "Watch"};
        double[] prices = {500, 300, 150};

        // Convert arrays into Item objects
        Item[] items = new Item[itemNames.length];
        for (int i = 0; i < itemNames.length; i++) {
            items[i] = new Item(itemNames[i], prices[i]);
        }

        Auction auction = new Auction(items);

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. View Items");
            System.out.println("2. Start Auction");
            System.out.println("3. Place Bid");
            System.out.println("4. End Auction");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    auction.viewItems();
                    break;

                case 2:
                    auction.viewItems();
                    System.out.print("Select item number: ");
                    int index = sc.nextInt() - 1;
                    auction.startAuction(index);
                    break;

                case 3:
                    System.out.print("Enter bidder name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter bid amount: ");
                    double bid = sc.nextDouble();
                    auction.placeBid(name, bid);
                    break;

                case 4:
                    auction.endAuction();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
