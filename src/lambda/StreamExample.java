package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entity.Developer;

public class StreamExample {

	public static void main(String[] args) {

		List<Developer> developers = new ArrayList<Developer>();
		developers.add(new Developer("jay", "mod", 10));
		developers.add(new Developer("ruc", "sha", 50));
		developers.add(new Developer("dhr", "pat", 20));
		developers.add(new Developer("gan", "dam", 60));
		developers.add(new Developer("jai", "pat", 80));
		developers.add(new Developer("jay", "pat", 10));

		System.out.println("List of developers: ");
		developers.stream().forEach(System.out::println);

		// Find the developers other than jay
		List<Developer> listOfDevelopersOtherThanJay = (List<Developer>) developers.stream()
				.filter(developer -> !developer.getFirstName().equals("jay")) // No jay
				.collect(Collectors.toList()); // Converts stream to list
		System.out.println("\nList of developers other than \"jay\":");
		listOfDevelopersOtherThanJay.stream().forEach(System.out::println);

		// Find jai otherwise return null
		Developer developerJai = developers.stream() // streaming
				.filter(developer -> developer.getFirstName().equals("jai")) // filtering jai
				.findAny() // If found return
				.orElse(null); // otherwise return null
		System.out.println("\nLooking for \"jai\": ");
		System.out.println(developerJai);
			
	}
}