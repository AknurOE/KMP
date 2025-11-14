package algorithms;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import algorithms.KMP;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

    private static final Gson gson = new Gson();

    public static void main(String[] args) {


        String[] inputs = {
                "src/main/resources/input_short.json",
                "src/main/resources/input_medium.json",
                "src/main/resources/input_long.json"
        };


        String[] outputs = {
                "src/output/output_short.json",
                "src/output/output_medium.json",
                "src/output/output_long.json"
        };


        for (int i = 0; i < inputs.length; i++) {
            processTest(inputs[i], outputs[i]);
        }
    }


    private static void processTest(String inputPath, String outputPath) {

        try {


            JsonObject jsonInput = gson.fromJson(new FileReader(inputPath), JsonObject.class);

            String pattern = jsonInput.get("pattern").getAsString();
            String text = jsonInput.get("text").getAsString();


            KMP kmp = new KMP();

            long startTime = System.nanoTime();
            var matches = kmp.search(pattern, text);
            long endTime = System.nanoTime();

            double timeMs = (endTime - startTime) / 1_000_000.0;


            JsonObject jsonOutput = new JsonObject();
            jsonOutput.addProperty("pattern", pattern);
            jsonOutput.addProperty("textLength", text.length());
            jsonOutput.add("matches", gson.toJsonTree(matches));
            jsonOutput.addProperty("timeMs", timeMs);


            try (FileWriter writer = new FileWriter(outputPath)) {
                gson.toJson(jsonOutput, writer);
            }

            System.out.println("DONE: " + inputPath);

        } catch (IOException e) {
            System.out.println("ERROR" + inputPath);
            e.printStackTrace();
        }
    }
}
