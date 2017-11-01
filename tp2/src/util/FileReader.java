package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReader {

  public static List<String> getFileContent(String filePath) throws IOException {
	  List<String> content = Files.readAllLines(Paths.get(filePath));
	  return content;
  }
}