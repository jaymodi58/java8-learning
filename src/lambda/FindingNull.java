package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entity.Developer;

public class FindingNull {

	public static void main(String[] args) {

		List<Developer> developers = new ArrayList<Developer>();
		developers.add(new Developer("jay", "mod", 10));
		developers.add(null);
		developers.add(new Developer("dhr", "pat", 20));
		developers.add(new Developer("jay", "dam", 60));
		developers.add(null);
		developers.add(new Developer("jay", "pat", 10));

		System.out.println("List of developers: ");
		developers.stream().forEach(System.out::println);

		System.out.println("\nRemoving nulls: ");
		developers.stream().filter(developer -> developer != null).collect(Collectors.toList())
				.forEach(System.out::println);
	}

}
