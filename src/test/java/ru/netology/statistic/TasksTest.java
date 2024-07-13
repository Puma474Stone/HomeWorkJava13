package ru.netology.statistic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldMatchSimpleTask() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");
        Assertions.assertTrue(task.matches("Позвонить"));
        Assertions.assertFalse(task.matches("Написать"));
    }

    @Test
    public void shouldMatchEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(1, subtasks);
        Assertions.assertTrue(epic.matches("Яйца"));
        Assertions.assertFalse(epic.matches("Сыр"));
    }

    @Test
    public void shouldMatchMeeting() {
        Meeting meeting = new Meeting(1, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        Assertions.assertTrue(meeting.matches("НетоБанк"));
        Assertions.assertTrue(meeting.matches("Выкатка"));
        Assertions.assertFalse(meeting.matches("Совещание"));
    }
}

