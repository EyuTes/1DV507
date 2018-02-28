package eb223db_assign1.Exercise3;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * 1. prints all .java files in the directory and all its sub directories. 2.
 * Both the name of the file & the size, given as the number of rows, should be
 * printed. 3. All exceptions should be handled in the program.
 * 
 * @author eyuel
 *
 */
public class PrintJavaMain {

	private static int depth = 1;
	private static int count = 0;

	private static void printJavaFile(File file) { // Indented printing
		int lines = 0;
		try {
			lines = Files.readAllLines(file.toPath()).size();
		} catch (Exception ex) { ex.printStackTrace(); 	}
		
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < depth; i++)
			buf.append("  ");
		
		System.out.printf("%s%s%s (%d lines)\n", (++count), buf.toString(),
				file.getName(), lines);
	}

	public static void printAllJavaFiles(File directory) {
		if (isDirectoryFound(directory)) {

			String space = "";
			for (int i = 0; i < depth; i++)
				space += " ";

			System.out.println(space + directory.getName());
			depth++;

			for (File f : directory.listFiles()) {
				try {
					if (f.isDirectory()) {
						printAllJavaFiles(f);
					 } else if (f.getName().endsWith(".java")) {
						printJavaFile(f);
					 }
					} catch (Exception e) {
					System.out.println("Error reading \n" + f.getName()
							+ directory.getName() + e.toString());
				}
			}
		}
		depth--;
	}

	private static boolean isDirectoryFound(File dir) {

		if (!dir.exists())
			try {
				throw new FileNotFoundException();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					return false;
				}
		 else
			return true;
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter path correct path ?");
		String path = scan.next();
		// "C:\\Users\\eyuel\\Documents\\lnu\\1DV507"
		File f = new File(path);
		try {
			PrintJavaMain.printAllJavaFiles(f);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		scan.close();
	}

}
