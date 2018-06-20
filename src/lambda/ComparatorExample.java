package lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import entity.Developer;

public class ComparatorExample {

	public static void main(String[] args) {

		List<Developer> developers = new ArrayList<Developer>();
		developers.add(new Developer("jay", "mod", 10));
		developers.add(new Developer("ruc", "sha", 50));
		developers.add(new Developer("dhr", "pat", 20));
		developers.add(new Developer("gan", "dam", 60));
		developers.add(new Developer("jai", "pat", 80));
		developers.add(new Developer("jay", "pat", 10));

		// Comparator<Developer> byFirsNameAscAndLastNameDesc = new
		// Comparator<Developer>() {
		//
		// @Override
		// public int compare(Developer o1, Developer o2) {
		//
		// int sameName = o1.getFirstName().compareTo(o2.getFirstName());
		// if (sameName == 0) {
		// // multiplying -1 for reverse order
		// return (-1) * o1.getLastName().compareTo(o2.getLastName());
		// }
		// return sameName;
		// }
		// };
		//
		// System.out.println("Before Sorting: ");
		// print(developers);
		//
		// Collections.sort(developers, byFirsNameAscAndLastNameDesc);
		//
		// System.out.println("\nAfter Sorting: ");
		// print(developers);

		System.out.println("Before Sorting: ");
		print(developers);

		developers.sort(Comparator.comparing(Developer::getFirstName)
				.thenComparing(Comparator.comparing(Developer::getLastName).reversed()));

		System.out.println("\nAfter Sorting: ");
		print(developers);

	}

	private static <T> void print(Collection<T> collection) {

		Iterator<T> it = collection.iterator();

		while (it.hasNext()) {
			T developer = it.next();
			System.out.println(developer);
		}
	}
}