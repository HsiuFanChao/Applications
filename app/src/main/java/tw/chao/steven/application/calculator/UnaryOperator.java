package tw.chao.steven.application.calculator;

/**
 * Created by hsiu-fanchao on 2016/12/19.
 */

public class UnaryOperator implements CalculatorButton {

    private String mText ;

    public UnaryOperator(CharSequence op) {
        mText = new String(op.toString());
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
