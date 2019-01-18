package classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {


        Point point = new Point(1, 1);

        Function<String, Point> funcPointsList =
                x -> {
                    int firstScope = x.indexOf("<");
                    int secondScope = x.indexOf(">");
                    int numX = Integer.parseInt(x.substring(firstScope + 1, secondScope));

                    String str = x.substring(secondScope + 1);

                    firstScope = str.indexOf("<");
                    secondScope = str.indexOf(">");
                    int numY = Integer.parseInt(str.substring(firstScope + 1, secondScope));

                    return new Point(numX, numY);
                };

        String filePath = "src/main/resources/FileInput.txt";

        List<Point> pointsList =  Files.lines(Paths.get(filePath))
                .map(funcPointsList)
                .collect(Collectors.toList());

        Quad quad = new Quad(pointsList, point);
        System.out.println(quad.checkPointLocation().getDescription());
    }

}


