package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entity.Developer;

public class MapExample {

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

		System.out.println("\nAll first names in uppercase: ");
		developers.stream().map(Developer::getFirstName) // Mapping only first names
				.map(String::toUpperCase) // Mapping them to their upper case first names
				.collect(Collectors.toList()) // stream to list
				.forEach(System.out::println); // printing each

		System.out.println("\nConverting developers to persons: ");
		List<Person> persons = developers.stream() // Streaming
				.map(developer -> {
					Person person = new Person();
					person.setfName(developer.getFirstName());
					person.setlName(developer.getLastName());
					return person;
				}) // Mapping developer to person
				.collect(Collectors.toList()); // stream to list
		persons.forEach(System.out::println);
	}
}

class Person {
	private String fName;
	private String lName;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	@Override
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + "]";
	}
}