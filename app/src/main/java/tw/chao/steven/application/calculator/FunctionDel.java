package tw.chao.steven.application.calculator;

/**
 * Created by hsiu-fanchao on 2016/12/19.
 */

public class FunctionDel implements CalculatorButton  {

    private String mText;

    public FunctionDel(CharSequence fn) {
        mText = new String(fn.toString());
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
