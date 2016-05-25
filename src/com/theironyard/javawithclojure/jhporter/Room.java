package com.theironyard.javawithclojure.jhporter;

/**
 * Created by jeffryporter on 5/25/16.
 */
public class Room
{
    private double length;
    private double height;
    private double width;
    private String wallColor;
    private String floorCovering;
    private String ceilingType;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getWallColor() {
        return wallColor;
    }

    public void setWallColor(String wallColor) {
        this.wallColor = wallColor;
    }

    public String getFloorCovering() {
        return floorCovering;
    }

    public void setFloorCovering(String floorCovering) {
        this.floorCovering = floorCovering;
    }

    public String getCeilingType() {
        return ceilingType;
    }

    public void setCeilingType(String ceilingType) {
        this.ceilingType = ceilingType;
    }

    @Override
    public String toString() {
        return String.format("Room{\nlength = %f\nheight = %f\nwidth = %f\nwallColor = %s\nfloorCovering = %s\nceilingType = %s\n}"
                ,length, height, width, wallColor, floorCovering, ceilingType);
    }
}

