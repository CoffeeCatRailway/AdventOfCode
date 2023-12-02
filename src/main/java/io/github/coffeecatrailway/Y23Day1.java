package io.github.coffeecatrailway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Y23Day1
{
    private static final String[] NAMES = {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
    };

    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(Y23Day1.class.getClassLoader().getResourceAsStream("input_y23d1.txt")));

        //int sum = partOne(input);
        int sum = partTwo(input);
        input.close();
        System.out.println("Sum: " + sum);
    }

    public static int partOne(BufferedReader input) throws IOException
    {
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
        return sum;
    }

    public static int partTwo(BufferedReader input) throws IOException
    {
        String line;
        int sum = 0;
        while ((line = input.readLine()) != null)
        {
            List<String> foundNumbers = new ArrayList<>();
            String[] chars = line.split("");
            for (int i = 0; i < chars.length; i++)
            {
                try
                {
                    int numeric = Integer.parseInt(chars[i]);
                    foundNumbers.add(chars[i]);
                } catch (NumberFormatException e)
                {
                    for (int j = 0; j < NAMES.length; j++)
                    {
                        String number = line.substring(i, i + NAMES[j].length() > line.length() ? line.length() - 1 : i + NAMES[j].length());
                        if (number.equals(NAMES[j]))
                            foundNumbers.add(String.valueOf(j));
                    }
                }
            }
            sum += Integer.parseInt(foundNumbers.get(0) + foundNumbers.get(foundNumbers.size() - 1));
        }
        return sum;
    }

//    private static int getSpeltNumber(String line)
//    {
//        String noNumerics = line.replaceAll("[0-9]", "");
//        int foundNumber = -1;
//        for (int i = 0; i < noNumerics.length(); i++)
//        {
//            for (int j = 0; j < NAMES.length; j++)
//            {
//                String number = noNumerics.substring(i, i + NAMES[j].length() > noNumerics.length() ? noNumerics.length() - 1 : i + NAMES[j].length());
//                if (number.equals(NAMES[j]))
//                    foundNumber = j;
//            }
//        }
//        return foundNumber;
//    }
}