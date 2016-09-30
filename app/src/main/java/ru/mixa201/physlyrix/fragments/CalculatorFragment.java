package ru.mixa201.physlyrix.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ru.mixa201.physlyrix.R;

/**
 * Created by 79114 on 30.09.2016.
 */
public class CalculatorFragment extends Fragment implements View.OnClickListener {

    private boolean calculation;
    private double num1;
    private double num2;
    private int action;
    private EditText ed;

    public CalculatorFragment() {
        calculation=false;
        action=0;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calculator_fragment, container, false);
        ed=(EditText)view.findViewById(R.id.ed_calc);

        view.findViewById(R.id.bt_calc_plus).setOnClickListener(this);
        view.findViewById(R.id.bt_calc_minus).setOnClickListener(this);
        view.findViewById(R.id.bt_calc_multiply).setOnClickListener(this);
        view.findViewById(R.id.bt_calc_divide).setOnClickListener(this);
        view.findViewById(R.id.bt_calc_sin).setOnClickListener(this);
        view.findViewById(R.id.bt_calc_cos).setOnClickListener(this);
        view.findViewById(R.id.bt_calc_tan).setOnClickListener(this);
        view.findViewById(R.id.bt_calc_ctg).setOnClickListener(this);
        view.findViewById(R.id.bt_calc_result).setOnClickListener(this);
        view.findViewById(R.id.bt_calc_clear).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Log.i("APP/CALCULATOR","Click handled!");
        switch (v.getId()) {
            case R.id.bt_calc_plus: {
                if(!calculation){
                    calculation=true;
                    num1=Double.parseDouble(ed.getText().toString());
                    action=1;
                    ed.setText("");
                }
                break;
            }
            case R.id.bt_calc_minus: {
                if(!calculation){
                    calculation=true;
                    num1=Double.parseDouble(ed.getText().toString());
                    action=2;
                    ed.setText("");
                }
                break;
            }
            case R.id.bt_calc_multiply: {
                if(!calculation){
                    calculation=true;
                    num1=Double.parseDouble(ed.getText().toString());
                    action=3;
                    ed.setText("");
                }
                break;
            }
            case R.id.bt_calc_divide: {
                if(!calculation){
                    calculation=true;
                    num1=Double.parseDouble(ed.getText().toString());
                    action=4;
                    ed.setText("");
                }
                break;
            }
            case R.id.bt_calc_sin: {
                ed.setText(""+(Math.sin(Math.toRadians(Double.parseDouble(ed.getText().toString())))));
                break;
            }
            case R.id.bt_calc_cos: {
                ed.setText(""+(Math.cos(Math.toRadians(Double.parseDouble(ed.getText().toString())))));
                break;
            }
            case R.id.bt_calc_tan: {
                ed.setText(""+(Math.tan(Math.toRadians(Double.parseDouble(ed.getText().toString())))));
                break;
            }
            case R.id.bt_calc_ctg: {
                ed.setText(""+(1/Math.tan(Math.toRadians(Double.parseDouble(ed.getText().toString())))));
                break;
            }
            case R.id.bt_calc_result: {
                if(calculation) {
                    num2 = Double.parseDouble(ed.getText().toString());
                    switch (action){
                        case 1:{
                            ed.setText(""+(num1+num2));
                            break;
                        }
                        case 2:{
                            ed.setText(""+(num1-num2));
                            break;
                        }
                        case 3:{
                            ed.setText(""+(num1*num2));
                            break;
                        }
                        case 4:{
                            ed.setText(""+(num1/num2));
                            break;
                        }
                    }
                }
                break;
            }
            case R.id.bt_calc_clear: {
                calculation=false;
                ed.setText("");
                break;
            }
        }
    }
}
