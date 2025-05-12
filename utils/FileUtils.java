package com.hitchainapi.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {

    /**
     * Read a file as a list of strings.
     * @param file The file to read.
     * @return List of strings representing lines in the file.
     * @throws IOException If an I/O error occurs.
     */
    public static List<String> readFileAsLines(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    /**
     * Write a list of strings to a file.
     * @param file The file to write to.
     * @param lines The list of strings to write.
     * @throws IOException If an I/O error occurs.
     */
    public static void writeLinesToFile(File file, List<String> lines) throws IOException {
        Files.write(file.toPath(), lines);
    }

    /**
     * Create a file and ensure the parent directories exist.
     * @param file The file to create.
     * @throws IOException If an I/O error occurs.
     */
    public static void createFile(File file) throws IOException {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
    }

    /**
     * Delete a file or directory.
     * @param file The file or directory to delete.
     * @return true if the file was successfully deleted, false otherwise.
     */
    public static boolean deleteFile(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File subFile : files) {
                        deleteFile(subFile);
                    }
                }
            }
            return file.delete();
        }
        return false;
    }

    /**
     * Copy a file to a new location.
     * @param source The source file.
     * @param destination The destination file.
     * @throws IOException If an I/O error occurs.
     */
    public static void copyFile(File source, File destination) throws IOException {
        Files.copy(source.toPath(), destination.toPath());
    }

    /**
     * Move a file to a new location.
     * @param source The source file.
     * @param destination The destination file.
     * @throws IOException If an I/O error occurs.
     */
    public static void moveFile(File source, File destination) throws IOException {
        Files.move(source.toPath(), destination.toPath());
    }

    /**
     * Check if a file or directory exists.
     * @param path The path to check.
     * @return true if the file or directory exists, false otherwise.
     */
    public static boolean exists(String path) {
        return Files.exists(Paths.get(path));
    }

    /**
     * Ensure a directory exists, creating it if necessary.
     * @param directory The directory to ensure exists.
     * @throws IOException If an I/O error occurs.
     */
    public static void ensureDirectoryExists(File directory) throws IOException {
        if (!directory.exists()) {
            Files.createDirectories(directory.toPath());
        }
    }
}
