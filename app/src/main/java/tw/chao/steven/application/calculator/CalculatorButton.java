package tw.chao.steven.application.calculator;

/**
 * Created by hsiu-fanchao on 2016/12/19.
 */

public interface CalculatorButton {

    String getText();
    void accept(UserInputHandler userInputHandler);
}
