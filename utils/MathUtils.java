package com.hitchainapi.utils;

public class MathUtils {

    /**
     * Clamp a value between a minimum and maximum value.
     * @param value The value to clamp.
     * @param min The minimum value.
     * @param max The maximum value.
     * @return The clamped value.
     */
    public static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(value, max));
    }

    /**
     * Calculate the distance between two points in 2D space.
     * @param x1 The x-coordinate of the first point.
     * @param y1 The y-coordinate of the first point.
     * @param x2 The x-coordinate of the second point.
     * @param y2 The y-coordinate of the second point.
     * @return The distance between the two points.
     */
    public static double distance2D(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Calculate the distance between two points in 3D space.
     * @param x1 The x-coordinate of the first point.
     * @param y1 The y-coordinate of the first point.
     * @param z1 The z-coordinate of the first point.
     * @param x2 The x-coordinate of the second point.
     * @param y2 The y-coordinate of the second point.
     * @param z2 The z-coordinate of the second point.
     * @return The distance between the two points.
     */
    public static double distance3D(double x1, double y1, double z1, double x2, double y2, double z2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double dz = z2 - z1;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /**
     * Calculate the angle between two vectors in 2D space.
     * @param x1 The x-coordinate of the first vector.
     * @param y1 The y-coordinate of the first vector.
     * @param x2 The x-coordinate of the second vector.
     * @param y2 The y-coordinate of the second vector.
     * @return The angle between the two vectors in degrees.
     */
    public static double angle2D(double x1, double y1, double x2, double y2) {
        double dotProduct = (x1 * x2 + y1 * y2);
        double magnitudeA = Math.sqrt(x1 * x1 + y1 * y1);
        double magnitudeB = Math.sqrt(x2 * x2 + y2 * y2);
        return Math.toDegrees(Math.acos(dotProduct / (magnitudeA * magnitudeB)));
    }

    /**
     * Convert degrees to radians.
     * @param degrees The angle in degrees.
     * @return The angle in radians.
     */
    public static double degreesToRadians(double degrees) {
        return Math.toRadians(degrees);
    }

    /**
     * Convert radians to degrees.
     * @param radians The angle in radians.
     * @return The angle in degrees.
     */
    public static double radiansToDegrees(double radians) {
        return Math.toDegrees(radians);
    }
}
