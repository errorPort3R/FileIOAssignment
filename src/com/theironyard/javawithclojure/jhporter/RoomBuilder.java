package com.theironyard.javawithclojure.jhporter;

import java.util.Scanner;

/**
 * Created by jeffryporter on 5/25/16.
 */
public class RoomBuilder
{   private boolean loadSuccess;

    public void setLength(Room room, Scanner input)
    {
        room.setLength(setSize(room.getLength(), input, "length"));
    }

    public void setWidth(Room room, Scanner input)
    {
        room.setWidth(setSize(room.getWidth(), input, "width"));
    }

    public void setHeight(Room room, Scanner input)
    {
        room.setHeight(setSize(room.getHeight(), input, "height"));
    }

    public void setWallColor(Room room, Scanner input)
    {
        room.setWallColor(setDescription(room.getWallColor(), input, "wall color"));
    }
    public void setFloorCovering(Room room, Scanner input)
    {
        room.setFloorCovering(setDescription(room.getFloorCovering(), input, "floor covering"));
    }
    public void setCeilingType(Room room, Scanner input)
    {
        room.setCeilingType(setDescription(room.getCeilingType(), input, "ceiling type"));
    }

    private double setSize(double currentValue, Scanner input, String parameter)
    {
        String dblStr;
        double distance = currentValue;
        System.out.printf("\nWhat is the %s of the room?",parameter);
        if (loadSuccess)
        {
            System.out.printf("(press 'enter' to keep previous value)");
            distance = currentValue;
        }
        dblStr = input.nextLine();
        if (loadSuccess && dblStr.isEmpty())
        {
            System.out.println();
            return currentValue;
        }
        else
        {
            try
            {
                distance = Math.abs(Double.valueOf(dblStr));
            }
            catch (Exception e)
            {
                System.out.println("Not a valid number. Try Again.");
                return setSize(currentValue, input, parameter);
            }
        }
        return distance;
    }

    private String setDescription(String currentValue, Scanner input, String parameter)
    {
        String description = currentValue;
        System.out.printf("\nWhat is the %s of the room?",parameter);
        if (loadSuccess)
        {
            System.out.printf("(press 'enter' to keep previous value)");
        }
        description =input.nextLine();
        if (loadSuccess && description.isEmpty())
        {
            description = currentValue;
        }
        else
        {
            if (description.isEmpty())
            {
                System.out.println("Not a valid description. Try Again.");
                setDescription(currentValue, input, parameter);
            }
        }
        return description;
    }

    public void setLoadSuccess(boolean success)
    {
        loadSuccess = success;
    }

}
