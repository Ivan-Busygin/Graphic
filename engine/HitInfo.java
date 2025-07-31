package engine;
import coordinateSystem.Vector3;

/**
 * Information about ray-object intersection.
 * Информация о пересечении луча с объектом.
 */
public class HitInfo {
    public boolean hit;          // был ли удар
    public float distance;       // расстояние до точки удара
    public Vector3 position;     // точка удара
    public Vector3 normal;       // нормаль в точке удара
    public Color color;          // цвет объекта

    public HitInfo() {
        this.hit = false;
    }
}
