package classes;

import enums.PointLocationEnum;

public class Line {
    Point onePoint;
    Point twoPoint;

    public Line(Point firstPoint, Point secondPoint) {
        this.onePoint = firstPoint;
        this.twoPoint = secondPoint;
    }

    public PointLocationEnum checkPointLocation(Point point) {
        if(onePoint.equals(point) || twoPoint.equals(point)) {
            return PointLocationEnum.END;
        }

        int lineEquation = (onePoint.getY() - twoPoint.getY())*point.getX() +
                (twoPoint.getX() - onePoint.getX())*point.getY() + (onePoint.getX()*twoPoint.getY() -
                twoPoint.getX()*onePoint.getY());

        if(lineEquation < 0) {
            return PointLocationEnum.BELOW;
        }else if(lineEquation > 0){
            return PointLocationEnum.ABOVE;
        }else {
            return PointLocationEnum.ON;
        }
    }
}
