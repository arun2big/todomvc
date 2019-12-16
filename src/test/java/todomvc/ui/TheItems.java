package todomvc.ui;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

public class TheItems {
    public static <T> Question<List<String>> displayed() {
        return actor -> Text.of(TodoList.ITEMS).viewedBy(actor).asList();
    }
}
