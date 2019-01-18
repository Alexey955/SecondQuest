import classes.Point;
import classes.Quad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {


        Point point = new Point(Integer.parseInt(args[1]), Integer.parseInt(args[2]));

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

        List<Point> pointsList =  Files.lines(Paths.get(args[0]))
                .map(funcPointsList)
                .collect(Collectors.toList());

        Quad quad = new Quad(pointsList, point);
        System.out.println(quad.checkPointLocation().getDescription());
    }

}


