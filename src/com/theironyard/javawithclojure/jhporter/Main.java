package com.theironyard.javawithclojure.jhporter;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static final String SAVE_LOCATION = "room.json";

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Room room;
        RoomBuilder builder = new RoomBuilder();
        String edit;

        System.out.println("Hello, and welcome to Room Builder 5.0.16.1542.");
        room = loadRoom(SAVE_LOCATION);
        if (room == null)
        {
            builder.setLoadSuccess(false);
            System.out.println("Let's build a new room, shall we?");
            edit = "y";
            room = new Room();
        }
        else
        {
            builder.setLoadSuccess(true);
            System.out.println(room.toString());
            System.out.println("Would you like to edit the details of this room?[y/n]");
            edit = input.nextLine();
        }
        if (edit.equalsIgnoreCase("y")) {

            builder.setLength(room, input);
            builder.setWidth(room, input);
            builder.setHeight(room, input);
            builder.setWallColor(room, input);
            builder.setCeilingType(room, input);
            builder.setFloorCovering(room, input);
            saveRoom(room, SAVE_LOCATION);
        }
    }

    public static void saveRoom(Room room, String fileName)
    {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(room);
        File f = new File(fileName);
        try
        {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Room loadRoom(String fileName)
    {
        File f = new File(fileName);
        try
        {
            Scanner scanner = new Scanner(f);
            scanner.useDelimiter("\\Z");
            String contents = scanner.next();
            JsonParser parser = new JsonParser();
            return parser.parse(contents, Room.class);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File failed to load. I'm sorry, but you'll have to start from scratch.");
        }
        return null;
    }
}
