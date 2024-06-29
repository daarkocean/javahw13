import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
    @Test
    public void shouldFalseWhenQueryNotInSubtasks() {
        Epic epic = new Epic(1, new String[]{"Subtask 1", "Subtask 2", "Subtask 3"});

        String query = "Subtask 4";
        boolean expected = false;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTrueWhenQueryInSubtasks() {
        String[] subtasks = {"Subtask 1", "Subtask 2", "Subtask 3"};
        Epic epic = new Epic(1, subtasks);

        String query = "Subtask 3";
        boolean expected = true;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTrueWhenQueryInTitle() {
        SimpleTask task = new SimpleTask(1, "Some task");

        String query = "Some";
        boolean expected = true;
        boolean actual = task.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFalseWhenQueryNotInTitle() {
        SimpleTask task = new SimpleTask(1, "Some task");

        String query = "false";
        boolean expected = false;
        boolean actual = task.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTrueWhenQueryInTopic() {
        Meeting meeting = new Meeting(1, "Some topic", "Some project", "28.06.2024-14:00");

        String query = "Some";
        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTrueWhenQueryInProject() {
        Meeting meeting = new Meeting(1, "Some topic", "Some project", "28.06.2024-14:00");

        String query = "project";
        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFalseWhenQueryNotInTopicOrProject() {
        Meeting meeting = new Meeting(1, "Some topic", "Some project", "28.06.2024-14:00");

        String query = "false";
        boolean expected = false;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }
}