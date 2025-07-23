package coordinateSystem;
/**
 * 2D вектор с базовыми операциями над ним.
 * 3D vector with basic vector operations.
 */
public class Vector2{

    private double x;
    private double y;

    /**
     * Main constructor
     * Основной конструктор
     */
    public Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Returns X component
     * Возвращает компонент X
     */
    public double getX(){
        return x;
    }

    /**
     * Returns Y component
     * Возвращает компонент Y
     */
    public double getY(){
        return y;
    }

    /**
     * set x
     * получение х новое значение
     */
    public void setX(double x){
        this.x = x;
    }

    /**
     * set y
     * получение у значение
     */
    public void setY(double x){
        this.x = x;
    }

    /**
     * Adds a vector or scalar to this vector
     * Складывает вектор или скаляр с текущим вектором
     */
    public void add(Vector2 other){
        this.x += other.x;
        this.y += other.y;
    }

    /**
     * Adds a vector or scalar to this vector
     * Складывает вектор или скаляр с текущим вектором
     */
    public void add(double scalar){
        this.x += scalar;
        this.y += scalar;
    }

    /**
     * Returns sum of two vectors
     * Возвращает сумму двух векторов
     */
    public static Vector2 add(Vector2 a, Vector2 b){
        return new Vector2(a.x + b.x, a.y + b.y);
    }

    /**
     * Subtracts a vector or scalar from this vector
     * Вычитает вектор или скаляр из текущего вектора
     */
    public void subtract(Vector2 other){
        this.x -= other.x;
        this.y -= other.y;
    }

    /**
     * Subtracts a vector or scalar from this vector
     * Вычитает вектор или скаляр из текущего вектора
     */
    public void subtract(double scalar){
        this.x -= scalar;
        this.y -= scalar;
    }

    /**
     * Returns difference of two vectors
     * Возвращает разность двух векторов
     */
    public static Vector2 subtract(Vector2 a, Vector2 b){
        return new Vector2(a.x - b.x, a.y - b.y);
    }

    /**
     * Performs component-wise multiplication
     * Поэлементное умножение вектора на вектор или скаляр
     */
    public void multiply(Vector2 other){
        this.x *= other.x;
        this.y *= other.y;
    }

    /**
     * Performs component-wise multiplication
     * Поэлементное умножение вектора на вектор или скаляр
     */
    public void multiply(double scalar){
        this.x *= scalar;
        this.y *= scalar;
    }

    /**
     * Returns component-wise product of two vectors
     * Возвращает поэлементное произведение двух векторов
     */
    public static Vector2 multiply(Vector2 a, Vector2 b){
        return new Vector2(a.x * b.x, a.y * b.y);
    }

    /**
     * Performs component-wise division
     * Поэлементное деление вектора на вектор или скаляр
     */
    public void divide(Vector2 other){
        this.x /= other.x;
        this.y /= other.y;
    }

    /**
     * Performs component-wise division
     * Поэлементное деление вектора на вектор или скаляр
     */
    public void divide(double scalar){
        if (scalar == 0){
            throw new ArithmeticException("Division by zero");
        }
        this.x /= scalar;
        this.y /= scalar;
    }

    /**
     * Returns component-wise division of two vectors
     * Возвращает поэлементное деление двух векторов
     */
    public static Vector2 divide(Vector2 a, Vector2 b){
        return new Vector2(a.x / b.x, a.y / b.y);
    }

    /**
     * Calculates distance between two points
     * Вычисляет расстояние между двумя точками
     */
    public static double computeDistance(Vector2 p1, Vector2 p2){
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Returns negated vector
     * Возвращает отрицательный вектор
     */
    public static Vector2 negate(Vector2 v){
        return new Vector2(-v.x, -v.y);
    }

    /**
     * Converts vector to string
     * Преобразует вектор в строку
     */
    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    /**
     * Returns vector length (magnitude)
     * Возвращает длину (модуль) вектора
     */
    public double getLength(){
        return Math.sqrt(x * x + y * y);
    }

    /**
     * Returns normalized vector (unit vector)
     * Возвращает нормализованный вектор (единичной длины)
     */
    public Vector2 normalize(){
        double len = getLength();
        if (len == 0){
            return new Vector2(0, 0);
        }
        else{
            return new Vector2(x / len, y / len);
        }
    }

    /**
     * Computes dot product of two vectors
     * Вычисляет скалярное произведение двух векторов
     */
    public static double computeDotProduct(Vector2 a, Vector2 b){
        return a.x * b.x + a.y * b.y;
    }

    /**
     * Computes cross product of two vectors
     * Вычисляет векторное произведение двух векторов
     */
    /** public static Vector2 computeCrossProduct(Vector2 a, Vector2 b){
        return new Vector2(
                a.y * b.z - a.z * b.y,
                a.z * b.x - a.x * b.z,
                a.x * b.y - a.y * b.x);
    }
     in 2D not be cross product, only dot product
     */
}
