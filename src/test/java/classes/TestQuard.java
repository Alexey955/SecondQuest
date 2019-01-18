package classes;

import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestQuard {

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

    @Test
    public void testCheckTops() throws IOException {

        String filePath = "src/test/java/resources/TestFileOne.txt";

        List<Point> pointsList =  Files.lines(Paths.get(filePath))
                .map(funcPointsList)
                .collect(Collectors.toList());

        Point testpoint = new Point(1,1);
        Quad quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is the top of the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(2,4);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is the top of the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(5,7);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is the top of the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(5,1);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is the top of the quadrilateral.", quad.checkPointLocation().getDescription());


        filePath = "src/test/java/resources/TestFileTwo.txt";

        pointsList =  Files.lines(Paths.get(filePath))
                .map(funcPointsList)
                .collect(Collectors.toList());

        testpoint = new Point(1,2);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is the top of the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(6,7);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is the top of the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(9,4);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is the top of the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(7,0);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is the top of the quadrilateral.", quad.checkPointLocation().getDescription());
    }

    @Test
    public void checkOnLines() throws IOException {
        String filePath = "src/test/java/resources/TestFileOne.txt";

        List<Point> pointsList =  Files.lines(Paths.get(filePath))
                .map(funcPointsList)
                .collect(Collectors.toList());

        Point testpoint = new Point(2,1);
        Quad quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point lies on the sides of the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(3,5);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point lies on the sides of the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(5,3);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point lies on the sides of the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(5,5);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point lies on the sides of the quadrilateral.", quad.checkPointLocation().getDescription());


        filePath = "src/test/java/resources/TestFileTwo.txt";

        pointsList =  Files.lines(Paths.get(filePath))
                .map(funcPointsList)
                .collect(Collectors.toList());

        testpoint = new Point(4,1);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point lies on the sides of the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(2,3);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point lies on the sides of the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(7,6);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point lies on the sides of the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(8,2);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point lies on the sides of the quadrilateral.", quad.checkPointLocation().getDescription());
    }

    @Test
    public void checkInside() throws IOException {
        String filePath = "src/test/java/resources/TestFileOne.txt";

        List<Point> pointsList =  Files.lines(Paths.get(filePath))
                .map(funcPointsList)
                .collect(Collectors.toList());

        Point testpoint = new Point(2,2);
        Quad quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is inside the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(3,4);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is inside the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(4,2);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is inside the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(4,5);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is inside the quadrilateral.", quad.checkPointLocation().getDescription());


        filePath = "src/test/java/resources/TestFileTwo.txt";

        pointsList =  Files.lines(Paths.get(filePath))
                .map(funcPointsList)
                .collect(Collectors.toList());

        testpoint = new Point(2,2);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is inside the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(6,1);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is inside the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(6,6);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is inside the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(8,4);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is inside the quadrilateral.", quad.checkPointLocation().getDescription());
    }

    @Test
    public void checkOutside() throws IOException {
        String filePath = "src/test/java/resources/TestFileOne.txt";

        List<Point> pointsList =  Files.lines(Paths.get(filePath))
                .map(funcPointsList)
                .collect(Collectors.toList());

        Point testpoint = new Point(1,2);
        Quad quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is outside the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(2,5);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is outside the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(0,3);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is outside the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(4,7);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is outside the quadrilateral.", quad.checkPointLocation().getDescription());


        filePath = "src/test/java/resources/TestFileTwo.txt";

        pointsList =  Files.lines(Paths.get(filePath))
                .map(funcPointsList)
                .collect(Collectors.toList());

        testpoint = new Point(1,1);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is outside the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(3,5);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is outside the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(8,1);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is outside the quadrilateral.", quad.checkPointLocation().getDescription());

        testpoint = new Point(8,6);
        quad = new Quad(pointsList, testpoint);
        Assert.assertEquals("Point is outside the quadrilateral.", quad.checkPointLocation().getDescription());
    }
}
