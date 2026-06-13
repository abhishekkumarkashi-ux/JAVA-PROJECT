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
            System.out.println((i + 1) + ". " + items[i].getName()
                    + " - $" + items[i].getPrice());
        }
    }

    // Start auction
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

        System.out.println("\nAuction started for: "
                + items[index].getName());
        System.out.println("Starting Price: $" + highestBid);
    }

    // Continuous bidding
    public void placeBid(Scanner sc) {
        if (!auctionActive) {
            System.out.println("\nAuction not active.");
            return;
        }

        System.out.println("\n===== BIDDING STARTED =====");
        System.out.println("Type 'exit' to stop bidding.");

        while (true) {

            System.out.print("\nEnter bidder name: ");
            String bidderName = sc.nextLine();

            if (bidderName.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter bid amount: ");
            double bidAmount = sc.nextDouble();
            sc.nextLine();

            if (bidAmount > highestBid) {
                highestBid = bidAmount;
                highestBidder = bidderName;

                System.out.println("Bid Accepted!");
                System.out.println("Current Highest Bid: $"
                        + highestBid + " by " + highestBidder);
            } else {
                System.out.println("Bid Rejected!");
                System.out.println("Bid must be higher than $"
                        + highestBid);
            }
        }
    }

    // Show current highest bid
    public void showCurrentBid() {
        if (!auctionActive) {
            System.out.println("\nNo active auction.");
            return;
        }

        System.out.println("\nCurrent Highest Bid: $" + highestBid);
        System.out.println("Highest Bidder: " + highestBidder);
    }

    // End auction
    public void endAuction() {
        if (!auctionActive) {
            System.out.println("\nNo active auction.");
            return;
        }

        auctionActive = false;

        System.out.println("\nAuction ended for: "
                + items[currentItemIndex].getName());

        displayWinner();
    }

    // Display winner
    public void displayWinner() {
        System.out.println("\n===== WINNER =====");

        if (highestBidder.equals("No bidder yet")) {
            System.out.println("No bids were placed.");
        } else {
            System.out.println("Winner: " + highestBidder);
            System.out.println("Winning Bid: $" + highestBid);
        }
    }
}

// Main class
public class aution{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] itemNames = {"Laptop", "Phone", "Watch"};
        double[] prices = {500, 300, 150};

        Item[] items = new Item[itemNames.length];

        for (int i = 0; i < itemNames.length; i++) {
            items[i] = new Item(itemNames[i], prices[i]);
        }

        Auction auction = new Auction(items);

        int choice;

        do {
            System.out.println("\n===== ONLINE AUCTION SYSTEM =====");
            System.out.println("1. View Items");
            System.out.println("2. Start Auction");
            System.out.println("3. Start Bidding");
            System.out.println("4. Show Current Highest Bid");
            System.out.println("5. End Auction");
            System.out.println("6. Exit");
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
                    sc.nextLine();
                    auction.startAuction(index);
                    break;

                case 3:
                    auction.placeBid(sc);
                    break;

                case 4:
                    auction.showCurrentBid();
                    break;

                case 5:
                    auction.endAuction();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}


// SAMPLE INPUT:
        
// 2
// 1
// 3
// Abhi
// 600
// Rahul
// 750
// Aman
// 700
// exit
// 5
// 6

// SAMPLE OUTPUT:

// Auction Started For: Laptop
// Starting Price: $500.0

// Bid Accepted!
// Current Highest Bid = $600.0 by Abhi

// Bid Accepted!
// Current Highest Bid = $750.0 by Rahul

// Bid Rejected!
// Bid must be greater than $750.0

// ===== AUCTION ENDED =====
// Item: Laptop
// Winner: Rahul
// Winning Bid: $750.0
