package se2xb3.data.processing;

/**
 * Classes that implement this interface provide a strategy for processing an
 * instance of a generic parametrized type.
 * @author Dawson
 * @version 1.0
 * @since 3/11/2017
 */
public interface IProcessor<T> {
    Object process(T t);
}
