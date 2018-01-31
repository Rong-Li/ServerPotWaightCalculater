package com.example.lirongl.servingsizecalculator;

/**
 * Store information about a single pot
 */

public class Pot {

    // Set member data based on parameters.
    public Pot(String aname, int aweightInG)
    {
        name = aname;
        weightInG = aweightInG;
    }

    // Return the weight
    public int getWeightInG()
    {
        return weightInG;
    }

    // Set the weight. Throws IllegalArgumentException if weight is less than 0.
    public void setWeightInG(int aweightInG)
    {
        if (aweightInG < 0)
            throw new IllegalArgumentException();
        weightInG = aweightInG;
    }

    // Return the name.
    public String getName()
    {
        return name;
    }

    // Set the name. Throws IllegalArgumentException if name is an empty string (length 0),
    // or if name is a null-reference.
    public void setName(String aname)
    {
        if (aname.length() == 0)
            throw new IllegalArgumentException();
        name = aname;
    }

    private String name;
    private int weightInG;

}