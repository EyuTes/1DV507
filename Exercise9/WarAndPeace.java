package eb223db_assign1.Exercise9;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WarAndPeace {

	public static void main(String[] args) {

		// String path="C:..\\1DV507\\src\\eb223db_assign1\\Exercise9\\WarAndPeace.txt";
		String text = readText("C:..\\1DV507\\src\\eb223db_assign1\\Exercise9\\WarAndPeace.txt"); // My own method

		String[] words = text.split(" "); // Simple split, will be cleaned up
											// later on
		System.out.println("Initial word count: " + words.length); // We found
																	// 577,091
																	// and
																	// unique=51,292

		Stream<String> stream = Arrays.stream(words);
		long wordCount = stream
				.map(s -> s.toLowerCase().replaceAll("\\s+", ""))
				.filter(s -> s.length() > 0).distinct().count();
		System.out.println(wordCount);
	}

	public static String readText(String filename) {
		try {
			return Files
					.readAllLines(Paths.get(filename),
							Charset.forName("ISO-8859-1")).stream()
					.collect(Collectors.joining(" "));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
