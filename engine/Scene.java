package engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Сцена, содержащая объекты для рендеринга.
 * Scene containing renderable objects.
 */
public class Scene {
    private final List<Sphere> objects;

    public Scene() {
        this.objects = new ArrayList<>();
    }

    public void addObject(Sphere object) {
        objects.add(object);
    }

    public List<Sphere> getObjects() {
        return objects;
    }
}
