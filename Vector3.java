public class Vector3{

    double x;
    double y;  
    double z;

    // Main constructor
    // Основной конструктор
    public Vector3(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Instance method for adding two vectors
    // Динамический метод сложения двух векторов
    public void add(Vector3 other){
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
    }
    // Static method for adding two vectors
    // Статический метод сложения двух векторов
    public static Vector3 add(Vector3 a, Vector3 b){
        return new Vector3(a.x + b.x, a.y + b.y, a.z + b.z);
    }
    // Method for adding scalar to vector
    // Метод сложения вектора и скаляра
    public void addScalar(double scalar){
        this.x += scalar;
        this.y += scalar;
        this.z += scalar;
    }

    // Instance method for subtracting two vectors
    // Динамический метод вычитания двух векторов
    public void subtract(Vector3 other){
        this.x -= other.x;
        this.y -= other.y;
        this.z -= other.z;
    }
    // Static method for subtracting two vectors
    // Статический метод вычитания двух векторов
    public static Vector3 subtract(Vector3 a, Vector3 b){
        return new Vector3(a.x - b.x, a.y - b.y, a.z - b.z);
    }
    // Method for subtracting scalar from vector
    // Метод вычитания скаляра из вектора
    public void subtractScalar(double scalar){
        this.x -= scalar;
        this.y -= scalar;
        this.z -= scalar;
    }

    // Instance method for multiplying two vectors
    // Динамический метод умножения двух векторов
    public void multiply(Vector3 other){
        this.x *= other.x;
        this.y *= other.y;
        this.z *= other.z;
    }
    // Static method for multiplying two vectors
    // Динамический метод умножения двух векторов
    public static Vector3 multiply(Vector3 a, Vector3 b){
        return new Vector3(a.x * b.x, a.y * b.y, a.z * b.z);
    }
    // Method for multiplying vector by scalar
    // Метод умножения вектора на скаляр
    public void multiplyScalar(double scalar){
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
    }

    // Instance method for dividing two vectors
    // Динамический метод деления двух векторов
    public void divide(Vector3 other){
        this.x /= other.x;
        this.y /= other.y;
        this.z /= other.z;
    }
    // Static method for dividing two vectors
    // Динамический метод деления двух векторов
    public static Vector3 divide(Vector3 a, Vector3 b){
        return new Vector3(a.x / b.x, a.y / b.y, a.z / b.z);
    }
    // Method for dividing vector by scalar
    // Метод деления вектора на скаляр
    public void divideScalar(double scalar) {
        if (scalar != 0){
            this.x /= scalar;
            this.y /= scalar;
            this.z /= scalar;
        }
    }

    // Distance between two points
    // Рассстояние между точками
    public static double getDistance(Vector3 point1, Vector3 point2){
        double deltaX = Math.abs(point1.x - point2.x);
        double deltaY = Math.abs(point1.y - point2.y);
        double deltaZ = Math.abs(point1.z - point2.z);

        double deltaXY = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        double distance = Math.sqrt(deltaXY * deltaXY + deltaZ * deltaZ);

        return distance;
    }

    // Negate a vector
    // Отрицает вектор
    public static Vector3 negative(Vector3 vector3){
        return new Vector3(vector3.x * -1, vector3.y * -1, vector3.z * -1);
    }

    // Convert to string
    // Преобрразование в строку
    public String toString(){
        return "(" + x + ", " + y + ", " + z + ")";
    }

    // Length of vector
    // Длинна вектора
    public double length(Vector3 vector3){
        return Math.sqrt(vector3.x * vector3.x + vector3.y * vector3.y + vector3.z * vector3.z);
    }

    // Normalize the vector
    // Нормализация
    public Vector3 normalize(){
        double len = length(this);
        if (len == 0){
            return new Vector3(0, 0, 0);
        }
        else{
            return new Vector3(x / len, y / len, z / len);
        }
    }
    
    // Dot product
    // Скалярное произведение
    public static double dot(Vector3 a, Vector3 b){
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    // Cross product
    // Векторное произведение
    public static Vector3 cross(Vector3 a, Vector3 b) {
    return new Vector3(
        a.y * b.z - a.z * b.y,
        a.z * b.x - a.x * b.z,
        a.x * b.y - a.y * b.x);
    }
}
