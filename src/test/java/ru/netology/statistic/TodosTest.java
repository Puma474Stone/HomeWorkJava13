package ru.netology.statistic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);

        Task[] expectedEpic = {epic};
        Task[] actualEpic = todos.search("Яйца");
        Assertions.assertArrayEquals(expectedEpic, actualEpic);

        Task[] expectedMeeting = {meeting};
        Task[] actualMeeting = todos.search("НетоБанк");
        Assertions.assertArrayEquals(expectedMeeting, actualMeeting);
    }

    @Test
    public void shouldFindMultipleTasks() {
        SimpleTask task1 = new SimpleTask(1, "Позвонить родителям");
        SimpleTask task2 = new SimpleTask(2, "Позвонить другу");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);

        Task[] expected = {task1, task2};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTask() {
        SimpleTask task1 = new SimpleTask(1, "Позвонить родителям");
        SimpleTask task2 = new SimpleTask(2, "Позвонить другу");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);

        Task[] expected = {task1};
        Task[] actual = todos.search("родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoTasks() {
        SimpleTask task1 = new SimpleTask(1, "Позвонить родителям");
        SimpleTask task2 = new SimpleTask(2, "Позвонить другу");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);

        Task[] expected = {};
        Task[] actual = todos.search("написать письмо");
        Assertions.assertArrayEquals(expected, actual);
    }
}


