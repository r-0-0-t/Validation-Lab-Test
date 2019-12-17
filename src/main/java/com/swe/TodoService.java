package com.swe;

import java.util.List;

public interface TodoService {
    public List<String> retrieveTodos(String user);
    boolean deleteTodo(String todo);
}
