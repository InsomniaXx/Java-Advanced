package Advanced.StacksQueues;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E05Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputRobots = scanner.nextLine();
        String[] robotsData = inputRobots.split(";");
        LinkedHashMap<String, Integer> robots = getRobotsMap(robotsData);
        LinkedHashMap<String, Integer> robotsWorkingTime = getRobotsWorkingTimeMap(robotsData);

        String startTime = scanner.nextLine();
        int startTimeInSeconds = getStartTimeInSeconds(startTime);

        ArrayDeque<String> products = new ArrayDeque<>();
        String product = scanner.nextLine();

        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }

        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            startTimeInSeconds++;
            decreaseWorkingTime(robotsWorkingTime);

            boolean isTaken = false;

            for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
                if (robot.getValue() == 0) {
                    String takenTime = "[" + getStartTime(startTimeInSeconds) + "]";
                    System.out.println(robot.getKey() + " - " + currentProduct + " " + takenTime);
                    robotsWorkingTime.put(robot.getKey(), robots.get(robot.getKey()));
                    isTaken = true;
                    break;
                }
            }
            if (!isTaken) {
                products.offer(currentProduct);
            }
        }
    }

    private static void decreaseWorkingTime(LinkedHashMap<String, Integer> robotsWorkingTime) {
        for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
            if (robot.getValue() > 0) {
                robotsWorkingTime.put(robot.getKey(), robot.getValue() - 1);
            }
        }
    }

    private static String getStartTime(int startTimeInSeconds) {
        int hours = startTimeInSeconds / 3600 % 24;
        int minutes = startTimeInSeconds % 3600 / 60;
        int second = startTimeInSeconds % 60;


        return String.format("%02d:%02d:%02d", hours, minutes, second);
    }

    private static LinkedHashMap<String, Integer> getRobotsWorkingTimeMap(String[] robotsData) {
        LinkedHashMap<String, Integer> robotsWorkingTime = new LinkedHashMap<>();
        for (String robotData : robotsData) {
            String robotName = robotData.split("-")[0];

            robotsWorkingTime.put(robotName, 0);
        }
        return robotsWorkingTime;
    }

    private static int getStartTimeInSeconds(String startTime) {
        int hours = Integer.parseInt(startTime.split(":")[0]);
        int minutes = Integer.parseInt(startTime.split(":")[1]);
        int seconds = Integer.parseInt(startTime.split(":")[2]);

        return hours * 3600 + minutes * 60 + seconds;
    }

    private static LinkedHashMap<String, Integer> getRobotsMap(String[] robotsData) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String robotData : robotsData) {
            String robotName = robotData.split("-")[0];
            int processingTime = Integer.parseInt(robotData.split("-")[1]);

            robots.put(robotName, processingTime);
        }
        return robots;
    }
}
