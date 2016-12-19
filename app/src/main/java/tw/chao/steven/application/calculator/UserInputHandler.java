package tw.chao.steven.application.calculator;

/**
 * Created by hsiu-fanchao on 2016/12/19.
 */

public interface UserInputHandler {
    void handleUserInput(Dot dot);
    void handleUserInput(Number number);
    void handleUserInput(UnaryOperator op);
    void handleUserInput(BinaryOperator op);
    void handleUserInput(FunctionClear fn);
    void handleUserInput(FunctionDel fn);
    void handleUserInput(Equal qual);
    CharSequence getProcessedUserInput();
}
