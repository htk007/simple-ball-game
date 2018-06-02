package com.example.hasan.simpleballgame;

/**
 * Created by HASAN on 6.01.2016.
 */
import android.graphics.Point;
public class Line {
    //class fields
    public Point start;
    public Point end;
    // default constructor initializes to (0, 0)
    public Line()
    {
        start = new Point(0,0);
        end = new Point(0,0);
    }
}