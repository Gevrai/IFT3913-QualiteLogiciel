package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReader {

  public static List<String> getFileContentFormatted(String filePath) throws IOException {
	  List<String> contentList = Files.readAllLines(Paths.get(filePath));
	  List<String> formattedContent = new ArrayList<String>();
	  
	  // MODEL modelName
	  formattedContent.add(contentList.remove(0));
	  
	  //Each sections separated with semicolon as a single string, easy but not very efficient...
	  String temp[] = String.join(" ", contentList).replaceAll("[ \t\n\r]+", " ").split("[ ]?;[ ]?",0);
	  formattedContent.addAll(Arrays.asList(temp));

	  return formattedContent;
  }
}