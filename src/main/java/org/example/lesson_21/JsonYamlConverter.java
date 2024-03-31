package org.example.lesson_21;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.json.XML;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonYamlConverter {

    public static void main(String[] args) {
        String directoryPath;
        if (args.length > 0) {
            directoryPath = args[0];
        } else {
            directoryPath = ".";
        }

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".xml")) {
                    convertAndLog(file);
                }
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }

    private static void convertAndLog(File file) {
        String fileName = file.getName();
        long startTime = System.currentTimeMillis();
        try {
            String content = FileUtils.readFileToString(file, "UTF-8");
            String convertedContent = xmlToYaml(content);
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            Path convertedDirectory = Paths.get(file.getParent(), "converted");
            Files.createDirectories(convertedDirectory);
            Path newPath = Paths.get(convertedDirectory.toString(), getFileNameWithoutExtension(fileName) + ".yaml");
            FileUtils.writeStringToFile(newPath.toFile(), convertedContent, "UTF-8");
            String logEntry = fileName + " -> " + newPath.getFileName() + ", " + duration + " ms, " +
                    file.length() + " bytes -> " + Files.size(newPath) + " bytes";
            writeLog(logEntry);
        } catch (IOException e) {
            String logEntry = fileName + " -> Failed to convert: " + e.getMessage();
            writeLog(logEntry);
        }
    }

    private static String xmlToYaml(String xml) {
        JSONObject jsonObject = XML.toJSONObject(xml);
        return new Yaml().dump(jsonObject.toMap());
    }

    private static String getFileNameWithoutExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex == -1) {
            return fileName;
        }
        return fileName.substring(0, dotIndex);
    }

    private static void writeLog(String logEntry) {
        try {
            FileWriter writer = new FileWriter("result.log", true);
            writer.write(logEntry + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
