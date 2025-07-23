package coordinateSystem;

/**
 * 3D вектор с базовыми операциями над ним.
 * 3D vector with basic vector operations.
 */
public class Vector3 {

    private double x;
    private double y;  
    private double z;

    /** 
     * Main constructor 
     * Основной конструктор 
     */
    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /** 
     * Returns X component 
     * Возвращает компонент X 
     */
    public double getX() {
        return x;
    }

    /** 
     * Returns Y component 
     * Возвращает компонент Y 
     */
    public double getY() {
        return y;
    }

    /** 
     * Returns Z component 
     * Возвращает компонент Z 
     */
    public double getZ() {
        return z;
    }

    /** 
     * Adds a vector or scalar to this vector 
     * Складывает вектор с текущим вектором 
     */
    public void add(Vector3 other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
    }

    /** 
     * Adds a vector or scalar to this vector 
     * Складывает вектор или скаляр с текущим вектором 
     */
    public void add(double scalar) {
        this.x += scalar;
        this.y += scalar;
        this.z += scalar;
    }

    /** 
     * Returns sum of two vectors 
     * Возвращает сумму двух векторов 
     */
    public static Vector3 add(Vector3 a, Vector3 b) {
        return new Vector3(a.x + b.x, a.y + b.y, a.z + b.z);
    }

    /** 
     * Subtracts a vector or scalar from this vector 
     * Вычитает вектор или скаляр из текущего вектора 
     */
    public void subtract(Vector3 other) {
        this.x -= other.x;
        this.y -= other.y;
        this.z -= other.z;
    }

    /** 
     * Subtracts a vector or scalar from this vector 
     * Вычитает вектор или скаляр из текущего вектора 
     */
    public void subtract(double scalar) {
        this.x -= scalar;
        this.y -= scalar;
        this.z -= scalar;
    }

    /** 
     * Returns difference of two vectors 
     * Возвращает разность двух векторов 
     */
    public static Vector3 subtract(Vector3 a, Vector3 b) {
        return new Vector3(a.x - b.x, a.y - b.y, a.z - b.z);
    }

    /** 
     * Performs component-wise multiplication 
     * Поэлементное умножение вектора на вектор или скаляр 
     */
    public void multiply(Vector3 other) {
        this.x *= other.x;
        this.y *= other.y;
        this.z *= other.z;
    }

    /** 
     * Performs component-wise multiplication 
     * Поэлементное умножение вектора на вектор или скаляр 
     */
    public void multiply(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
    }

    /** 
     * Returns component-wise product of two vectors 
     * Возвращает поэлементное произведение двух векторов 
     */
    public static Vector3 multiply(Vector3 a, Vector3 b) {
        return new Vector3(a.x * b.x, a.y * b.y, a.z * b.z);
    }

    /** 
     * Performs component-wise division 
     * Поэлементное деление вектора на вектор или скаляр 
     */
    public void divide(Vector3 other) {
        this.x /= other.x;
        this.y /= other.y;
        this.z /= other.z;
    }

    /** 
     * Performs component-wise division 
     * Поэлементное деление вектора на вектор или скаляр 
     */
    public void divide(double scalar) {
        if (scalar == 0){
            throw new ArithmeticException("Division by zero");
        }
        this.x /= scalar;
        this.y /= scalar;
        this.z /= scalar;
    }

    /** 
     * Returns component-wise division of two vectors 
     * Возвращает поэлементное деление двух векторов 
     */
    public static Vector3 divide(Vector3 a, Vector3 b) {
        return new Vector3(a.x / b.x, a.y / b.y, a.z / b.z);
    }

    /** 
     * Calculates distance between two points 
     * Вычисляет расстояние между двумя точками 
     */
    public static double computeDistance(Vector3 p1, Vector3 p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        double dz = p1.z - p2.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /** 
     * Returns negated vector 
     * Возвращает отрицательный вектор 
     */
    public static Vector3 negate(Vector3 v) {
        return new Vector3(-v.x, -v.y, -v.z);
    }

    /** 
     * Converts vector to string 
     * Преобразует вектор в строку 
     */
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    /** 
     * Returns vector length (magnitude) 
     * Возвращает длину (модуль) вектора 
     */
    public double getLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    /** 
     * Returns normalized vector (unit vector) 
     * Возвращает нормализованный вектор (единичной длины) 
     */
    public Vector3 normalize() {
        double len = getLength();
        if (len == 0) {
            return new Vector3(0, 0, 0);
        }
        else {
            return new Vector3(x / len, y / len, z / len);
        }
    }

    /** 
     * Computes dot product of two vectors 
     * Вычисляет скалярное произведение двух векторов 
     */
    public static double computeDotProduct(Vector3 a, Vector3 b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    /** 
     * Computes cross product of two vectors 
     * Вычисляет векторное произведение двух векторов 
     */
    public static Vector3 computeCrossProduct(Vector3 a, Vector3 b) {
        return new Vector3(
            a.y * b.z - a.z * b.y,
            a.z * b.x - a.x * b.z,
            a.x * b.y - a.y * b.x);
    }
}