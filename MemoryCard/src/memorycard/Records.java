/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorycard;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rade
 */
public class Records {

    static List<Result> results = new ArrayList<>();;

    public Records() {
       
    }

    public static String getResults() {
        
        StringBuffer sb = new StringBuffer();
        sort();
        Path path = Paths.get("results.txt");

        try (Scanner sc = new Scanner(path, StandardCharsets.UTF_8.name())) {

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String result[] = line.split(",");
                String name = result[0].trim();
                int points = Integer.parseInt(result[1].trim());
                results.add(new Result(name, points));
                sb.append(line + "\n");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return sb.toString();

    }

    public  void addResult(String name, int points) {
        results.add(new Result(name, points));

    }

    void saveResults() {
        
        
        Path path = Paths.get("results.txt");
        sort();
        try (BufferedWriter out = Files.newBufferedWriter(path)) {
            
            for (Result result : results) {
                out.append(result.getName() + "," + result.getPoints());
                out.newLine();
                System.out.println(result.getName());
            }
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    static void sort(){
    Collections.sort(results, new Comparator<Result>() {
            @Override
            public int compare(Result r1, Result r2) {

                return -Integer.compare(r1.getPoints(), r2.getPoints());
            }
        });
    }

}
