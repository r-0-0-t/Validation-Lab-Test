package com.swe;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.invocation.Invocation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class TodoServiceTest {
    @Test
    public void retrieveTodo() {
        TodoService todoService = mock(TodoService.class);
        List<String> allTodos = Arrays.asList("Spring","Summer","Winter");
        when(todoService.retrieveTodos(anyString())).thenReturn(allTodos);
    }

    @Test
    void deleteTodoServiceTest() {
        TodoService todoService = mock(TodoService.class);
        List<String> allTodo = Arrays.asList("Spring","Summer","Winter");
        TodoBusinessImpl todoImpl = new TodoBusinessImpl(todoService);
        when(todoService.retrieveTodos("User")).thenReturn(allTodo);
        todoImpl.deleteTodosNotRelatedToSpring("User");

        verify(todoService,times(2)).deleteTodo(anyString());
        verify(todoService, Mockito.never()).deleteTodo("spring");
        then(todoService).should().deleteTodo("Winter");
        then(todoService).should().deleteTodo("Summer");

    }

    @Test
    void captureArguments() {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        TodoService todoService = mock(TodoService.class);
        List<String> allTodo = Arrays.asList("Spring","Summer","Winter");
        TodoBusinessImpl todoImpl = new TodoBusinessImpl(todoService);
        when(todoService.retrieveTodos("User")).thenReturn(allTodo);

        todoImpl.deleteTodosNotRelatedToSpring("User");
        verify(todoService,times(2)).deleteTodo(captor.capture());
        System.out.println(captor.getAllValues());
    }
}