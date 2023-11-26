package main;

import main.IO.math.Vector3f;
import main.IO.model.Model;
import main.IO.model.Polygon;

import java.util.ArrayList;
import java.util.Iterator;

public class ModelProcessor {

    public static void removeVertices(Model model, int[] vertexIndicesToRemove) {
        // Удаление выбранных вершин
        ArrayList<Vector3f> newVertices = new ArrayList<>(model.getVertices());
        for (int index : vertexIndicesToRemove) {
            newVertices.remove(index);
        }
        model.setVertices(newVertices);
        // Удаление связанных полигонов
        Iterator<Polygon> iterator = model.getPolygons().iterator();
        while (iterator.hasNext()) {
            Polygon polygon = iterator.next();
            ArrayList<Integer> vertexIndices = polygon.getVertexIndices();
            vertexIndices.removeIf(index -> containsIndex(vertexIndicesToRemove, index));

            if (vertexIndices.size() < 3) {
                iterator.remove(); // Удаляем полигоны с менее чем тремя вершинами
            }
        }
        // Переставляем индексы для корректной привязки вершин к полигонам
        for (Polygon polygon : model.getPolygons()) {
            ArrayList<Integer> vertexIndices = polygon.getVertexIndices();
            ArrayList<Integer> newVertexIndices = new ArrayList<>();
            for (int x : vertexIndices) {
                for(int y : vertexIndicesToRemove) {
                    if (x >= y) {
                        x = x - 1;
                    }
                }
                newVertexIndices.add(x);
            }

            polygon.setVertexIndices(newVertexIndices);
            System.out.println(polygon.getVertexIndices());
        }

    }
    private static boolean containsIndex(int[] indices, int targetIndex) {
        for (int index : indices) {
            if (index == targetIndex) {
                return true;
            }
        }
        return false;
    }
}
