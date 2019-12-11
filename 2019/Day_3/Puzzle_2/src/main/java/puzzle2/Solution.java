package puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.awt.Point;

class Solution {
    private List<Point> wireOne = new ArrayList<Point>();
    private List<Point> wireTwo = new ArrayList<Point>();
    private Map<Point, Integer> wireOneDelay = new HashMap<Point, Integer>();
    private Map<Point, Integer> wireTwoDelay = new HashMap<Point, Integer>();
    private Point currentPoint = new Point(0, 0);
    private int minDelay = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Solution mySolution = new Solution();
        int returnValue = mySolution.calcSignalDelay("puzzle_input.txt");
        System.out.println(returnValue);
    }

    public int constructWire(char direction, int amount, int wireNum, int delay) {
        Map<Character, Integer> horMapping = new HashMap<Character, Integer>();
        horMapping.put('R', 1);
        horMapping.put('L', -1);
        Map<Character, Integer> vertMapping = new HashMap<Character, Integer>();
        vertMapping.put('U', 1);
        vertMapping.put('D', -1);
        while (amount > 0) {
            delay++;
            currentPoint.setLocation(currentPoint.getX() + horMapping.getOrDefault(direction, 0),
                    currentPoint.getY() + vertMapping.getOrDefault(direction, 0));
            Point wirePosition = new Point(currentPoint);
            if (wireNum == 1) {
                wireOne.add(wirePosition);
                wireOneDelay.put(wirePosition, delay);
            } else {
                wireTwo.add(wirePosition);
                wireTwoDelay.put(wirePosition, delay);
            }
            amount--;
        }
        return delay;
    }

    public int calcSignalDelay(String filename) {
        String curDir = System.getProperty("user.dir") + "/2019/Day_3/Puzzle_2/src/main/java/puzzle2/";
        try {
            File input = new File(curDir + filename);
            Scanner inputReader = new Scanner(input);
            int wireNum = 1;
            while (inputReader.hasNextLine()) {
                int delay = 0;
                String wire = inputReader.nextLine();
                for (String instruction : wire.split(",")) {
                    char direction = instruction.charAt(0);
                    int amount = Integer.parseInt(String.valueOf(instruction.substring(1)));
                    delay = constructWire(direction, amount, wireNum, delay);
                }
                currentPoint.setLocation(0, 0);
                wireNum++;
                delay = 0;
            }
            inputReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(1);
        }
        wireOne.retainAll(wireTwo);
        for (Point p : wireOne) {
            int sumDelay = wireOneDelay.get(p) + wireTwoDelay.get(p);
            if (sumDelay < minDelay) {
                minDelay = sumDelay;
            }
        }

        return minDelay;
    }
}