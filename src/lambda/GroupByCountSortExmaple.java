package lambda;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import entity.Developer;

public class GroupByCountSortExmaple {

	public static void main(String[] args) {

		List<Developer> developers = new ArrayList<Developer>();
		developers.add(new Developer("jay", "mod", 10));
		developers.add(new Developer("ruc", "sha", 50));
		developers.add(new Developer("dhr", "pat", 20));
		developers.add(new Developer("jay", "dam", 60));
		developers.add(new Developer("ruc", "pat", 80));
		developers.add(new Developer("jay", "pat", 10));

		System.out.println("List of developers: ");
		developers.stream().forEach(System.out::println);

		System.out.println("\nGroup by first name: ");
		Map<String, Long> result = developers.stream() // streaming
				.collect( // stream to map
						Collectors.groupingBy( // Grouping
								Developer::getFirstName, // by first name
								Collectors.counting() // operation which is counting
						));
		System.out.println(result);

		System.out.println("\nSum of salaries which has same first name: ");
		Map<String, Integer> sum = developers.stream() // Streaming
				.collect( // stream to collection
						Collectors.groupingBy( // grouping
								Developer::getFirstName, // Group by first name
								Collectors.summingInt(Developer::getSalary // then sum up the grouped
								)));
		System.out.println(sum);

		System.out.println("\nSort by sum of the salaries: ");
		Map<String, Integer> sortedSum = new LinkedHashMap<String, Integer>();
		sum.entrySet().stream() // Streaming
				.sorted(Map.Entry.<String, Integer>comparingByValue()) // Sorting by map value
				.forEachOrdered( // putting them to a new map
						developer -> sortedSum.put(developer.getKey(), developer.getValue()));
		System.out.println(sortedSum);
	}

}
