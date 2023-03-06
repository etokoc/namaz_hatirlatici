package com.ertugrul.myjava.utils;

public class NetworkResult<T> {
    private final T _data;
    private final String _message;

    public NetworkResult(T data, String message) {
        _data = data;
        _message = message;
    }

    public T get_data() {
        return _data;
    }

    public static final class Success<T> extends NetworkResult<T> {
        public Success(T data) {
            super(data, null);
        }
    }

    public static final class Error<T> extends NetworkResult<T> {
        public Error(String message) {
            super(null,message);
        }
    }

    public static final class Loading<T> extends NetworkResult<T> {
        public Loading() {
            super(null, null);
        }
    }
}
