package com.capgemini.annapurna.restaurant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.capgemini.annapurna.restaurant.entity.Address;
import com.capgemini.annapurna.restaurant.entity.FoodItem;
import com.capgemini.annapurna.restaurant.entity.Restaurant;
import com.capgemini.annapurna.restaurant.repository.RestaurantRepository;

/**
 * 
 * @author ugawari
 *
 * @SpringBootApplication to start a Spring application context
 */
@SpringBootApplication
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

	Set<FoodItem> foodItems = new HashSet<FoodItem>();
	Set<FoodItem> foodItems1 = new HashSet<FoodItem>();
	Map<Integer, Integer> ratings = new HashMap<Integer, Integer>();
	Map<Integer, String> reviews = new HashMap<Integer, String>();
	Set<String> photos = new HashSet<String>();

	@Bean
	public CommandLineRunner produceData(RestaurantRepository repository) {
		foodItems.add(new FoodItem("dum Biryani", true, 100.0,"veg ",photos));
		foodItems.add(new FoodItem("dum Biryani", true, 100.0,"veg ",photos));
		foodItems1.add(new FoodItem("Burger", true, 50.0,"veg ",photos));
		foodItems1.add(new FoodItem("Coffee", true, 10.0,"veg ",photos));
		ratings.put(101, 3);
		ratings.put(102, 4);

		reviews.put(101, "Quality Good");
		reviews.put(102, "Quality Good");

		photos.add("c:/food");
		photos.add("c:/seefood");

		return (env) -> {
			repository.save(
					new Restaurant(101, "Royal Foods", new Address("Vitawa", "Thane", "Maharashtra", "India", 450124),
							foodItems, ratings, reviews, "Veg-NonVeg", photos));
			
			repository.save(new Restaurant(102, "Tea Cafe", new Address("Vitawa", "Thane", "Maharashtra", "India", 450124),
					foodItems1, ratings, reviews, "Veg-NonVeg", photos));
					
			repository.save(new Restaurant(103, "Mc Donalds", new Address("Vitawa", "Thane", "Maharashtra", "India", 450124),
							foodItems1, ratings, reviews, "Veg-NonVeg", photos));
		};
	}

}
