/**
 * This package contains the core classes for the Restaurant application.
 *
 * The application simulates the functionality of a restaurant, where users
 * can view the menu, add items to their order, and submit orders. The system
 * also includes classes for managing menu items, orders, and the GUI components
 * for interacting with the user.
 *
 * <p>The main classes in this package are:
 * <ul>
 *     <li><b>RestaurantApp:</b> The entry point of the application that initializes
 *         the menu and launches the order-taking GUI.</li>
 *     <li><b>MenuItem:</b> Represents a menu item in the restaurant, including
 *         the name and price.</li>
 *     <li><b>Order:</b> Represents a customer's order, which contains a list of
 *         menu items.</li>
 *     <li><b>OrderGUI:</b> The graphical user interface (GUI) that allows the
 *         user to view the menu, add items to the order, and submit the order.</li>
 * </ul>
 *
 * This package also handles the basic operations like submitting an order and
 * updating the order summary in the GUI.
 *
 * <p>Example usage:
 * <pre>
 *     RestaurantApp app = new RestaurantApp();
 *     OrderGUI gui = new OrderGUI(app);
 * </pre>
 *
 * @since 1.0
 */
package com.restaurant;