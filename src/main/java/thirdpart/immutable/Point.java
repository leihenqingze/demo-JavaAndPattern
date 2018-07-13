package thirdpart.immutable;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
public class Point implements Serializable {

    @Getter
    private int x;
    @Getter
    private int y;

    public Point() {
        this(0, 0);
    }

    public Point(Point p) {
        this(p.x, p.y);
    }

    /**
     * 返还点对象
     */
    public Point getLocation() {
        return new Point(x, y);
    }

    /**
     * 将点移到(x,y)
     */
    public Point setLocation(Point p) {
        return new Point(p.x, p.y);
    }

    /**
     * 将点移到(x,y)
     */
    public Point setLocation(int x, int y) {
        return new Point(x, y);
    }

    /**
     * 将点移到(x,y)
     */
    public Point setLocation(double x, double y) {
        return new Point((int) Math.round(x), (int) Math.round(y));
    }

    /**
     * 将点移到(x,y)
     */
    public Point move(int x, int y) {
        return new Point(x, y);
    }

    /**
     * 将点移动x和y单位
     */
    public Point translate(int x, int y) {
        return new Point(this.x + x, this.y + y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point pt = (Point) obj;
            return (x == pt.x) && (y == pt.y);
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[x= " + x + ",y=" + y + "]";
    }
}