import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
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

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldArrayNoMatches() {
        Todos todos = new Todos();

        todos.add(new SimpleTask(1, "Купить сыр"));
        todos.add(new Epic(2, new String[]{"Погладить рубашку"}));

        Task[] expected = {};
        Task[] actual = todos.search("Посмотреть фильм");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldArrayWithOneMatch() {
        Todos todos = new Todos();

        todos.add(new SimpleTask(1, "Купить сыр"));
        todos.add(new Epic(2, new String[]{"Погладить рубашку"}));

        Task[] expected = { new SimpleTask(1, "Купить сыр") };
        Task[] actual = todos.search("Купить");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldArrayOfAllTasksWithEmptyQuery() {
        Todos todos = new Todos();

        todos.add(new SimpleTask(1, "Купить сыр"));
        todos.add(new Epic(2, new String[]{"Погладить рубашку"}));

        Task[] expected = { new SimpleTask(1, "Купить сыр"), new Epic(2, new String[]{"Погладить рубашку"}) };
        Task[] actual = todos.search("");

        Assertions.assertArrayEquals(expected, actual);
    }
}