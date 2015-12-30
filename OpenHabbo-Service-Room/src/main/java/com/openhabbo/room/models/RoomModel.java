package com.openhabbo.room.models;

import com.openhabbo.room.util.Direction;

public class RoomModel {
    public String name;
    public int doorX;
    public int doorY;
    public float doorZ;
    public Direction doorDirection;
    public boolean hasSwimmingPool;
    public boolean clubOnly;

    private String mapStr;
    private char[][] map;
    private String heightMapStr;
    private String floorMapStr;

    public char[][] getMap()
    {
        return this.map;
    }

    public String getHeightMapString()
    {
        return this.heightMapStr;
    }

    public String getFloorMapString()
    {
        return this.floorMapStr;
    }

    public int getMaxX()
    {
        return this.map.length;
    }

    public int getMaxY()
    {
        return (this.map.length > 0) ? this.map[0].length : 0;
    }

    public boolean init(String heightmap)
    {
        // Set the map str
        this.mapStr = heightmap;

        // Parse the map axes from the string
        String[] axes = this.mapStr.split("\r");
        int maxX = axes[0].length();
        int maxY = axes.length;
        this.map = new char[maxX][maxY];

        // Process the map tiles and pre-build the strings for the client
        StringBuilder hmsb = new StringBuilder();
        StringBuilder fmsb = new StringBuilder();
        for(int y = 0; y < maxY; y++)
        {
            for(int x = 0; x < maxX; x++)
            {
                char tile = axes[y].charAt(x);
                hmsb.append(tile);
                if(x == this.doorX && y == this.doorY)
                {
                    tile = Integer.toString((int) this.doorZ).charAt(0);
                }
                this.map[x][y] = Character.toLowerCase(tile);
                fmsb.append(this.map[x][y]);
            }
            hmsb.append((char) 13);
            fmsb.append((char) 13);
        }
        this.heightMapStr = hmsb.toString();
        this.floorMapStr = fmsb.toString();

        // Validate this map by checking if the doortile can be found
        return (this.doorX <= this.getMaxX() && this.doorY <= this.getMaxY());
    }

}
