package com.hitchainapi.utils;

import java.util.concurrent.TimeUnit;

public class TimerUtils {

    /**
     * Runs a task after a specified delay.
     * @param delay The delay in milliseconds before executing the task.
     * @param task The task to execute after the delay.
     */
    public static void runTaskAfterDelay(long delay, Runnable task) {
        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
                task.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    /**
     * Runs a task periodically at the specified interval.
     * @param interval The interval in milliseconds between each execution.
     * @param task The task to execute periodically.
     */
    public static void runTaskPeriodically(long interval, Runnable task) {
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    task.run();
                    TimeUnit.MILLISECONDS.sleep(interval);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }

    /**
     * Converts a time in milliseconds to a readable format (days, hours, minutes, seconds).
     * @param timeMillis The time in milliseconds to format.
     * @return A formatted string representing the time in days, hours, minutes, and seconds.
     */
    public static String formatTime(long timeMillis) {
        long days = TimeUnit.MILLISECONDS.toDays(timeMillis);
        long hours = TimeUnit.MILLISECONDS.toHours(timeMillis) - TimeUnit.DAYS.toHours(days);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(timeMillis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeMillis));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(timeMillis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeMillis));

        return String.format("%dd %dh %dm %ds", days, hours, minutes, seconds);
    }
}

