// Posted from EduTools plugin
class Box<T> {

    private T t;

    public Box() {

    }

    public Box(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public void put(T t) {
        this.t = t;
    }
}