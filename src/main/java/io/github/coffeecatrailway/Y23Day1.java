package io.github.coffeecatrailway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Y23Day1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(Y23Day1.class.getClassLoader().getResourceAsStream("input_y23d1.txt")));

        String line;
        int sum = 0;
        while ((line = input.readLine()) != null)
        {
            String[] ints = line.replaceAll("[^0-9]", "").split("");
            if (ints.length == 1)
                sum += Integer.parseInt(ints[0] + ints[0]);
            else
                sum += Integer.parseInt(ints[0] + ints[ints.length - 1]);
        }
        input.close();
        System.out.println("Sum: " + sum);
    }
}