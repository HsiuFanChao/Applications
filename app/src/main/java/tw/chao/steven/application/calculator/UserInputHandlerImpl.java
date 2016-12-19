package tw.chao.steven.application.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hsiu-fanchao on 2016/12/19.
 */

public class UserInputHandlerImpl implements UserInputHandler {

    private static final String TAG = "UserInputHandlerImpl";
    private List<CalculatorButton> mUserInput;
    private CalculationCompleteListener mCallback;

    public UserInputHandlerImpl(CalculationCompleteListener listener) {
        mUserInput = new ArrayList<>();
        mCallback = listener;
    }

    @Override
    public CharSequence getProcessedUserInput() {
        StringBuilder sb = new StringBuilder();
        for(CalculatorButton btn : mUserInput) {
            sb.append(btn.getText());
        }
        return sb.toString();
    }

    @Override
    public void handleUserInput(Dot dot) {
        CalculatorButton last = mUserInput.get(mUserInput.size()-1);
        if (!(last instanceof Dot)) {
            mUserInput.add(dot);
        }
    }

    @Override
    public void handleUserInput(Number number) {
        mUserInput.add(number);
    }

    @Override
    public void handleUserInput(UnaryOperator op) {

        int firstUnaryIdx = -1;
        for (int i = 0; i < mUserInput.size(); ++i) {
            CalculatorButton btn = mUserInput.get(i);
            if (btn instanceof UnaryOperator) {
                firstUnaryIdx = i;
                break;
            }
        }
        if (firstUnaryIdx != -1) {
            mUserInput.remove(firstUnaryIdx);
        } else {

            int firstNumIdx = -1;
            for (int i = 0; i < mUserInput.size(); ++i) {
                CalculatorButton btn = mUserInput.get(i);
                if (btn instanceof Number) {
                    firstNumIdx = i;
                    break;
                }
            }

            if (firstNumIdx != -1) {
                mUserInput.add(firstNumIdx, op);
            }
        }
    }

    @Override
    public void handleUserInput(BinaryOperator op) {
        if (mUserInput.size() > 0) {
            CalculatorButton last = mUserInput.get(mUserInput.size() - 1);
            if (last instanceof BinaryOperator) {
                mUserInput.remove(mUserInput.size() - 1);
            }
        }
        mUserInput.add(op);
    }

    @Override
    public void handleUserInput(FunctionDel fn) {
        if (mUserInput.size() > 0) {
            mUserInput.remove(mUserInput.size() - 1);
        }
    }

    @Override
    public void handleUserInput(Equal qual) {
        mCallback.onCalculationComplete(5566.0f);
    }

    @Override
    public void handleUserInput(FunctionClear fn) {
        mUserInput.clear();
    }
}
