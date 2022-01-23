package com.Lakson;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to our game! Soon you will be " +
                "dropped into the world. Follow the directions, and remember:");
        System.out.println("Q is to QUIT, W is WEST, E is EAST, S is SOUTH and N is NORTH");
        System.out.println("You can either write a single letter, or the whole word! I should be able to understand either.");
        System.out.println(" I also like it if you say something else, like `please go south`, Thank you for that.");
        System.out.println(" Good luck !");
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "You wake up. It's a brand new day, a great day! Today you get to go and learn how to be a developer!"));
        locations.put(1, new Location(1, "You are standing at the gates of Udemy. Should you finish that course, or get a new one?"));
        locations.put(2, new Location(2, "You completed the course! You are at the top of Udemy hill!"));
        locations.put(3, new Location(3, "Your project breaks down as soon as you deviate from the tutorial. It's not working out..."));
        locations.put(4, new Location(4, "Despite the hardships, you persevere! You keep at it, and every day your work becomes better and better!"));
        locations.put(5, new Location(5, "You did it! WIth the help of friends, guidance, perseverance, and hours of trial and error, you did it! You got the internship!!!"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);
//        locations.get(1).addExit("Q", 0);

        locations.get(2).addExit("N", 5);
//        locations.get(2).addExit("Q", 0);

        locations.get(3).addExit("W", 1);
//        locations.get(3).addExit("Q", 0);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
//        locations.get(4).addExit("Q", 0);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
//        locations.get(5).addExit("Q", 0);

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH" ,"N" );
        vocabulary.put("SOUTH" ,"S");
        vocabulary.put("WEST" , "W");
        vocabulary.put("EAST" ,"E" );


        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are:");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if(direction.length() >1) {
                String[] words = direction.split(" ");
                for (String word : words){
                    if (vocabulary.containsKey((word))) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("CAN'T GO THERE BRO");
            }
        }
        }
    }
