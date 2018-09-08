package alex.example.com.exchangeapps;

public interface Lifecycle<V> {
    void bind(V view);

    void unbind();
}
