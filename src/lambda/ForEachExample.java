package lambda;

import java.util.ArrayList;
import java.util.List;

import entity.Developer;

public class ForEachExample {

	public static void main(String[] args) {

		List<Developer> developers = new ArrayList<Developer>();
		developers.add(new Developer("jay", "mod", 10));
		developers.add(new Developer("ruc", "sha", 50));
		developers.add(new Developer("dhr", "pat", 20));
		developers.add(new Developer("gan", "dam", 60));
		developers.add(new Developer("jai", "pat", 80));
		developers.add(new Developer("jay", "pat", 10));

		System.out.println("Print all Using forEach: ");
		developers.forEach(developer -> System.out.println(developer));

		System.out.println("\nPrint all Using forEach and method reference: ");
		developers.forEach(System.out::println);

		System.out.println("\nPrint only jay Using forEach: ");
		developers.forEach(developer -> {
			if (developer.getFirstName().equals("jay"))
				System.out.println(developer);
		});

		System.out.println("\nPrint only jay Using stream: ");
		developers.stream() // Stream the collection
				.filter(developer -> developer.getFirstName().equals("jay")) // filters only jay
				.forEach(System.out::println); // method reference

	}
}