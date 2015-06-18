package test;

import java.io.*;

public class ReadCSV {
	private static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(
				new FileInputStream("test.csv")));

		String line;
		String name;
		String age;
		String birthday;
		while ((line = br.readLine()) != null) {
			// System.out.println(line);
			String[] info = line.split(",");
			name = info[0].trim();
			age = info[1].trim();
			birthday = info[2].trim();
			System.out.print(name + "\t" + age + "\t" + birthday + "\n");
		}
	}
}