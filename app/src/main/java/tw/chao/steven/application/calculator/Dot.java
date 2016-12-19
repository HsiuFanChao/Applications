package tw.chao.steven.application.calculator;

/**
 * Created by hsiu-fanchao on 2016/12/19.
 */

public class Dot implements CalculatorButton {

    private String mText;

    public Dot(CharSequence num) {
        mText = new String(num.toString());
    }

    @Override
    public String getText() {
        return mText;
    }

    @Override
    public void accept(UserInputHandler userInputHandler) {
        userInputHandler.handleUserInput(this);
    }
}
