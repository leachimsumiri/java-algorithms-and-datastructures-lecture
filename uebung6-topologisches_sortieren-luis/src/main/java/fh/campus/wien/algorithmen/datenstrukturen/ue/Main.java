package fh.campus.wien.algorithmen.datenstrukturen.ue;

import fh.campus.wien.algorithmen.datenstrukturen.ue.lib.Graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static Graph g = new Graph();
    public static void main(String[] args) {

        read_file();

    }


    private static void read_file() {
        int source = 0;
        int target = 0;

        Path path = FileSystems.getDefault().getPath("");
        Path stations_path = Paths.get(path.toAbsolutePath().toString(), "src/main/resources/Makefile");
        System.out.println(stations_path.toAbsolutePath());
        System.out.println();
        int i = 0;
        try {

            FileInputStream file = new FileInputStream(stations_path.toAbsolutePath().toString());

            Scanner scanner = new Scanner(file , "UTF-8");
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                row = row.replaceAll("(?m)^[ \t]*\r?\n", "");
                if(row.isEmpty()){
                    continue;
                }
               // System.out.println(row);

                String [] row_values = row.split(":");
                String target_value = row_values[0].trim();
                String source_value = row_values[1].trim();

               target = g.addNode(target_value);
               for(String source_value2: source_value.split(" ")) {
                   source = g.addNode(source_value2);

                   g.adjMatrix[target][source] = 1;
                   System.out.print(String.format("[%d, %s]   <-  [%d, %s]\n", target, g.nodes[target].name, source, g.nodes[source].name));
               }

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }

        g.topologySearch();


    }
}
