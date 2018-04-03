package ocp.chapter6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;

public class Chapter6 {

	private void ex1() throws IOException {
		Path path1 = null;
		Path path2 = null;
		
		try (BufferedReader in = Files.newBufferedReader(path1) ; BufferedWriter out = Files.newBufferedWriter(path2, StandardOpenOption.WRITE)) {
			String line;
			while ( (line = in.readLine()) != null ) {
				System.out.println(line);
				out.write(line);
			}
		} 
	}
	
	public static void main(String[] args) throws Exception {
		Chapter6 chap6 = new Chapter6();
		chap6.ex1();
	}
}
