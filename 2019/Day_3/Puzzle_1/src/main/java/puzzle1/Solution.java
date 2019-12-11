package puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.awt.Point;

class Solution {
    private Set<Point> points = new HashSet<Point>();
    private Point currentPoint = new Point(0, 0);
    private int minManDistance = Integer.MAX_VALUE;
    private int numWires = 2;

    public static void main(String[] args) {
        Solution mySolution = new Solution();
        mySolution.points.add(mySolution.currentPoint);
        int returnValue = mySolution.calcManhattanDistance("puzzle_input.txt");
        System.out.println(returnValue);
    }

    public void movePoint(char direction, int amount, int wireNumber) {
        Map<Character, Integer> horMapping = new HashMap<Character, Integer>();
        horMapping.put('R', 1);
        horMapping.put('L', -1);
        Map<Character, Integer> vertMapping = new HashMap<Character, Integer>();
        vertMapping.put('U', 1);
        vertMapping.put('D', -1);
        while (amount > 0) {
            currentPoint.setLocation(currentPoint.getX()+horMapping.getOrDefault(direction, 0), currentPoint.getY()+vertMapping.getOrDefault(direction, 0));
            Point wirePosition = new Point(currentPoint);
            if (!points.add(wirePosition) && wireNumber == numWires) {
                System.out.println("Intersection found at point: " + wirePosition.toString());
                int currManDist = (int) Math.abs(currentPoint.getX()) + (int) Math.abs(currentPoint.getY());
                if (currManDist < minManDistance  && currManDist != 0) { 
                    minManDistance = currManDist;
                }
            }
            amount--;
        }
    }

    public int calcManhattanDistance(String filename) {
        String curDir = System.getProperty("user.dir") + "/2019/Day_3/Puzzle_1/src/main/java/puzzle1/";
        try {
            File input = new File(curDir + filename);
            Scanner inputReader = new Scanner(input);
            int wireNum = 1;
            while (inputReader.hasNextLine()) {
                String wire = inputReader.nextLine();
                for (String instruction : wire.split(",")) {
                    char direction = instruction.charAt(0);
                    int amount = Integer.parseInt(String.valueOf(instruction.substring(1)));
                    movePoint(direction, amount, wireNum);
                }
                currentPoint.setLocation(0,0);
                wireNum++;
            }
            inputReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(1);
        }

        return minManDistance;
    }
}