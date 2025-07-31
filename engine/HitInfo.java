package engine;
import coordinateSystem.Vector3;

/**
 * Information about ray-object intersection.
 * Информация о пересечении луча с объектом.
 */
public class HitInfo {
    public boolean hit;          // был ли удар was there a hit
    public float distance;       // расстояние до точки удара distance to point of impact
    public Vector3 position;     // точка удара impact point
    public Vector3 normal;       // нормаль в точке удара normal at the point of impact
    public Color color;          // цвет объекта object color

    public HitInfo() {
        this.hit = false;
    }
}
