package main;

import main.IO.model.Model;
import main.IO.objreader.ObjReader;
import main.IO.objwriter.ObjWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Path fileName = Path.of("/home/paperclip/Documents/tasks/ComputerGraphicsTasks/task3_3_5/src/main/cube.obj");
        String fileContent = Files.readString(fileName);
        Model model = ObjReader.read(fileContent);
        int[] vertexIndicesToRemove = new int[2];
        vertexIndicesToRemove[0] = 5;
        vertexIndicesToRemove[1] = 1;
        ModelProcessor.removeVertices(model, vertexIndicesToRemove);
        ObjWriter.write("cubeNew.obj", model);
        System.out.println("succ");
    }
}