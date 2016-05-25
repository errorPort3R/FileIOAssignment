package com.theironyard.javawithclojure.jhporter;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by jeffryporter on 5/25/16.
 */
public class MainTest {


    static final String TEST_FILE = "test.json";
    @Test
    public void saveAndLoad()
    {
        Room room = new Room();
        room.setLength(11.11);
        room.setWidth(22.22);
        room.setHeight(33.33);
        room.setWallColor("Mauve");
        room.setCeilingType("Metal Tile");
        room.setFloorCovering("Distressed Maple");
        Main.saveRoom(room, TEST_FILE);
        Room newRoom = Main.loadRoom(TEST_FILE);

        File f = new File(TEST_FILE);
        f.delete();

        assertTrue(newRoom != null);
        assertTrue(newRoom.getLength() == room.getLength());
        assertTrue(newRoom.getWidth() == room.getWidth());
        assertTrue(newRoom.getHeight() == room.getHeight());
        assertTrue(newRoom.getWallColor().equals(room.getWallColor()));
        assertTrue(newRoom.getCeilingType().equals(room.getCeilingType()));
        assertTrue(newRoom.getFloorCovering().equals(room.getFloorCovering()));
    }

}