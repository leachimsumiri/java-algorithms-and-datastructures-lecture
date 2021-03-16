import classes.Graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    private static Graph g = new Graph(20);

    public static void main(String[] args) {
        readFile();
        g.topologySearch();
    }

    public static void readFile(){
        int source = 0;
        int target = 0;

        Path path = FileSystems.getDefault().getPath("");
        Path makefilePath = Paths.get(path.toAbsolutePath().toString(), "src/resources/Makefile");

        try{
            FileInputStream file = new FileInputStream(makefilePath.toAbsolutePath().toString());

            Scanner scanner = new Scanner(file, "UTF-8");
            while(scanner.hasNextLine()){
                String row = scanner.nextLine();
                row = row.replaceAll("(?m)^[ \t]*\r?\n", "");

                if(row.isEmpty()){
                    continue;
                }

                String [] rowValues = row.split(":");
                String targetValue = rowValues[0].trim();
                String sourceValue = rowValues[1].trim();

                target = g.addNode(targetValue);
                for(String source_value2: sourceValue.split(" ")) {
                    source = g.addNode(source_value2);

                    g.adjMatrix[target][source] = 1;
                    System.out.print(String.format("[%d, %s] <- [%d, %s]\n", target, g.nodes[target].getName(), source, g.nodes[source].getName()));
                }



            }
            scanner.close();
        }catch(FileNotFoundException e){
            System.err.println(e);
        }
    }

}
