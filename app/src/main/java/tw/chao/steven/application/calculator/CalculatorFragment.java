package tw.chao.steven.application.calculator;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import tw.chao.steven.application.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculatorFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "CalculatorFragment";
    private TextView mResultView = null;
    private EditText mEditText = null;

    private UserInputHandler mUserInputHandler = null;
    private CalculationCompleteListener mListener = null;

    public CalculatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment CalculatorFragment.
     */
    public static CalculatorFragment newInstance() {
        CalculatorFragment fragment = new CalculatorFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }

        mListener = new CalculationCompleteListener() {
            @Override
            public void onCalculationComplete(float result) {
                mResultView.setText(Float.toString(result));
            }
        };

        mUserInputHandler = new UserInputHandlerImpl(mListener);

        String res = "5+5*(4/2)-7+1";
        System.out.println(engine.eval(res));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_calculator, container, false);

        mEditText = (EditText) rootView.findViewById(R.id.editText);
        mResultView = (TextView) rootView.findViewById(R.id.textView2);

        GridLayout gridLayout = (GridLayout) rootView.findViewById(R.id.grid);
        for(int i=0; i < gridLayout.getChildCount(); ++i) {
            gridLayout.getChildAt(i).setOnClickListener(this);
        }

        TextView tv;
        tv = (TextView) gridLayout.findViewById(R.id.button);tv.setTag(new FunctionClear(tv.getText()));
        tv = (TextView) gridLayout.findViewById(R.id.button2);tv.setTag(new UnaryOperator(tv.getText()));
        tv = (TextView) gridLayout.findViewById(R.id.button3);tv.setTag(new BinaryOperator(tv.getText()));
        tv = (TextView) gridLayout.findViewById(R.id.button4);tv.setTag(new FunctionDel(tv.getText()));

        tv = (TextView) gridLayout.findViewById(R.id.button5);tv.setTag(new Number(tv.getText()));
        tv = (TextView) gridLayout.findViewById(R.id.button6);tv.setTag(new Number(tv.getText()));
        tv = (TextView) gridLayout.findViewById(R.id.button7);tv.setTag(new Number(tv.getText()));
        tv = (TextView) gridLayout.findViewById(R.id.button8);tv.setTag(new BinaryOperator(tv.getText()));

        tv = (TextView) gridLayout.findViewById(R.id.button9);tv.setTag(new Number(tv.getText()));
        tv = (TextView) gridLayout.findViewById(R.id.button10);tv.setTag(new Number(tv.getText()));
        tv = (TextView) gridLayout.findViewById(R.id.button11);tv.setTag(new Number(tv.getText()));
        tv = (TextView) gridLayout.findViewById(R.id.button12);tv.setTag(new BinaryOperator(tv.getText()));

        tv = (TextView) gridLayout.findViewById(R.id.button13);tv.setTag(new Number(tv.getText()));
        tv = (TextView) gridLayout.findViewById(R.id.button14);tv.setTag(new Number(tv.getText()));
        tv = (TextView) gridLayout.findViewById(R.id.button15);tv.setTag(new Number(tv.getText()));
        tv = (TextView) gridLayout.findViewById(R.id.button16);tv.setTag(new BinaryOperator(tv.getText()));

        tv = (TextView) gridLayout.findViewById(R.id.button17);tv.setTag(new Number(tv.getText()));
        tv = (TextView) gridLayout.findViewById(R.id.button18);tv.setTag(new Dot(tv.getText()));
        tv = (TextView) gridLayout.findViewById(R.id.button19);tv.setTag(new Equal(tv.getText()));
        tv = (TextView) gridLayout.findViewById(R.id.button20);tv.setTag(new BinaryOperator(tv.getText()));
        return rootView;
    }

    //@Override
    public void onClick(View view) {

        CalculatorButton btn = (CalculatorButton) view.getTag();
        btn.accept(mUserInputHandler);

        mEditText.setText(mUserInputHandler.getProcessedUserInput());
    }
}
