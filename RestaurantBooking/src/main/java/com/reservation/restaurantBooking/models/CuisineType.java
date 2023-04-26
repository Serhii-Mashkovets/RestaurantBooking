package com.reservation.restaurantBooking.models;

/**
 * The CuisineType enum represents the type of cuisine offered by a restaurant in the restaurant booking system.
 * It contains three possible values - ITALIAN, CHINESE, and MOLECULAR.
 * The enum is used to specify the type of cuisine offered by a restaurant when creating or updating a restaurant object.
 * It allows for easy filtering and searching of restaurants based on their cuisine type.
 * Example usage:
 * // create a new restaurant object
 * Restaurant restaurant = new Restaurant();
 * // set the restaurant's name, address, and cuisine type
 * restaurant.setName("Pasta Palace");
 * restaurant.setAddress("123 Main St, Anytown USA");
 * restaurant.setCuisineType(CuisineType.ITALIAN);
 * // retrieve the restaurant's cuisine type
 * CuisineType cuisineType = restaurant.getCuisineType();
 * // check if the restaurant serves Italian food
 * if (cuisineType == CuisineType.ITALIAN) {
 * public enum CuisineType {
 System.out.println("This restaurant serves Italian food!");
 }
 */


public enum CuisineType {

    ITALIAN, CHINESE, MOLECULAR
}
