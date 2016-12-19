package tw.chao.steven.application.calculator;

/**
 * Created by hsiu-fanchao on 2016/12/19.
 */

public class Equal implements CalculatorButton {

    private String mText;

    public Equal(CharSequence equal) {
        mText = new String(equal.toString());
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
