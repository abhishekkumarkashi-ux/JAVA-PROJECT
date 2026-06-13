# Online Auction System

## Project Overview

The Online Auction System is a Java-based console application developed using Object-Oriented Programming (OOP) concepts. The system allows users to view available items, start auctions, place bids, track the highest bid, and declare the winner based on the highest bid amount.

This project demonstrates the practical implementation of Java classes, objects, encapsulation, constructors, arrays, and menu-driven programming.

---

## Features

* View available auction items
* Start an auction for a selected item
* Place multiple bids on an item
* Track the current highest bid
* Automatically determine the highest bidder
* End auction and display winner details
* User-friendly menu-driven interface

---

## Technologies Used

* Programming Language: Java
* Concepts: Object-Oriented Programming (OOP)
* IDE: VS Code / IntelliJ IDEA / Eclipse
* Input Handling: Scanner Class

---

## OOP Concepts Implemented

### 1. Class and Object

The project uses multiple classes such as:

* Item
* Auction
* AuctionSystem

### 2. Encapsulation

Private data members are accessed through public getter methods.

### 3. Constructors

Constructors are used to initialize item details and auction data.

### 4. Data Hiding

Sensitive data is protected using private access modifiers.

---

## Project Structure

### Item Class

Stores item information:

* Item Name
* Item Price

### Auction Class

Manages:

* Auction operations
* Bid processing
* Winner selection
* Highest bid tracking

### AuctionSystem Class

Contains:

* Main method
* User interface
* Menu handling

---

## How the System Works

1. User views available items.
2. User selects an item for auction.
3. Auction starts with the item's base price.
4. Multiple bidders place bids.
5. The system continuously updates the highest bid.
6. Bidding ends when the user exits the bidding process.
7. Auction is ended manually.
8. The highest bidder is declared the winner.

---

## Sample Run

### Start Auction

Auction Started For: Laptop

Starting Price: $500

### Bidding

Bidder: Abhi

Bid: 600

Bid Accepted

Bidder: Rahul

Bid: 750

Bid Accepted

Bidder: Aman

Bid: 700

Bid Rejected

### Result

Winner: Rahul

Winning Bid: $750

---

## Advantages

* Simple and easy to use
* Demonstrates real-world auction functionality
* Good implementation of Java OOP concepts
* Easy to extend with additional features

---

## Limitations

* Console-based application
* No database connectivity
* No user authentication
* Data is not stored permanently

---

## Future Enhancements

* MySQL database integration
* User registration and login system
* GUI using Java Swing or JavaFX
* Bid history tracking
* Online and real-time auctions
* Multiple auctions running simultaneously

---

## Conclusion

The Online Auction System successfully demonstrates the implementation of Object-Oriented Programming concepts in Java. The project provides a simple auction platform where users can bid on items and winners are determined automatically based on the highest bid.
