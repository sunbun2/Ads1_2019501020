import java.util.ArrayList;
import java.util.Arrays;

// import java.arw.Point;

public class BruteCollinearPoints {
    LineSegment[] l;
    public BruteCollinearPoints(Point[] points){
        Point[] p = Arrays.copyOf(points, points.length);
        Arrays.sort(p);
        ArrayList<LineSegment> segmentsList = new ArrayList<LineSegment>();
        for (int i = 0; i < p.length - 1; i++) {
            if (p[i].compareTo(p[i + 1]) == 0) {
                throw new IllegalArgumentException("Duplicated points are present");
            }
        }
        for (int v = 0; v < p.length-3; v++){
            for (int  x = 0; x < p.length-2; x++) {
                for (int y = 0; y < p.length-1; y++) {
                    for (int z = 0; z < p.length; z++){
                        if ((p[v].slopeTo(p[x]) == p[v].slopeTo(p[y])) && (p[v].slopeTo(p[x])==p[v].slopeTo(p[z]))) {
                            LineSegment temp = new LineSegment(p[v], p[z]);
                            if (!segmentsList.contains(temp))
                                segmentsList.add(temp);
                        }
                    }
                }
            }
        }
        l = segmentsList.toArray(new LineSegment[segmentsList.size()]);
    }    
    // the number of line segments
    public           int numberOfSegments()   { return l.length;}     
    // the line segments
    public LineSegment[] segments() { return l;}
 }