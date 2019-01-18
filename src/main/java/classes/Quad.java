package classes;

import enums.PointLocationEnum;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Quad {

    private List<Point> pointsList;

    private Point inputPoint;

    private Line oneLine;
    private Line twoLine;
    private Line threeLine;
    private Line fourLine;

    List<Line> linesList = new LinkedList<>();

    public Quad(List<Point> pointsList, Point inputPoint) {
        this.inputPoint = inputPoint;

        this.pointsList = pointsList;

        oneLine = new Line(pointsList.get(0), pointsList.get(1));
        twoLine = new Line(pointsList.get(1), pointsList.get(2));
        threeLine = new Line(pointsList.get(2), pointsList.get(3));
        fourLine = new Line(pointsList.get(3), pointsList.get(0));

        Collections.addAll(linesList, oneLine, twoLine, threeLine, fourLine);
    }

    public PointLocationEnum checkPointLocation() {

        if(checkPointWithLine() != PointLocationEnum.OUTSIDE) {
            return checkPointWithLine();
        }

        return checkPointInside();
    }

    private PointLocationEnum checkPointWithLine() {
        for(Line line: linesList) {
            if(line.checkPointLocation(inputPoint) == PointLocationEnum.END) {
                return PointLocationEnum.END;
            }else if(line.checkPointLocation(inputPoint) == PointLocationEnum.ON) {
                return PointLocationEnum.ON;
            }
        }
        return PointLocationEnum.OUTSIDE;
    }

    private PointLocationEnum checkPointInside() {
        int insideCounter = (int) linesList.stream().filter(x -> x.checkPointLocation(inputPoint) == PointLocationEnum.BELOW).count();

        return insideCounter == 4? PointLocationEnum.INSIDE : PointLocationEnum.OUTSIDE;
    }
}
