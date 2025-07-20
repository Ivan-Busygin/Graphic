public class Vector3 {

    double x;
    double y;  
    double z;

    // Основной конструктор
    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Динамический метод сложения двух векторов
    public void add(Vector3 other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
    }
    // Статический метод сложения двух векторов
    public static Vector3 add(Vector3 a, Vector3 b) {
        return new Vector3(a.x + b.x, a.y + b.y, a.z + b.z);
    }

    // Динамический метод вычитания двух векторов
    public void subtract(Vector3 other) {
        this.x -= other.x;
        this.y -= other.y;
        this.z -= other.z;
    }
    // Статический метод вычитания двух векторов
    public static Vector3 subtract(Vector3 a, Vector3 b) {
        return new Vector3(a.x - b.x, a.y - b.y, a.z - b.z);
    }
}


class Get_Distance {
    public static double get_Distance(Vector3 point1, Vector3 point2) {
        double delta_x = Math.abs(point1.x - point2.x);
        double delta_y = Math.abs(point1.y - point2.y);
        double delta_z = Math.abs(point1.z - point2.z);
        // нашли изменение по осям координат

        double delta_x_y = Math.sqrt(delta_x * delta_x + delta_y * delta_y);
        // нашли изменение по xy

        double distance = Math.sqrt(delta_x_y * delta_x_y + delta_z * delta_z);
        // нашли дистанцию между 2 точками
        return distance;
    }
}


class Test {
    public static void main(String[] args) {
        Vector3 a = new Vector3(0, 0, 0);
        Vector3 b = new Vector3(1, 1, 1);
        double distance = Get_Distance.get_Distance(a, b);
        System.out.print(distance);
    }
}