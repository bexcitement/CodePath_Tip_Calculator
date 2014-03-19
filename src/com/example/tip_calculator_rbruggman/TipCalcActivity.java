package com.example.tip_calculator_rbruggman;

import java.text.NumberFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalcActivity extends Activity {
	private Button btnTen;
	private Button btnFifteen;
	private Button btnTwenty;
	private Button btnDiffTip;
	private EditText diffTip;
	private EditText totalAmount;
	private TextView finalTip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calc);
		btnTen = (Button) findViewById(R.id.btnten);
		btnFifteen = (Button) findViewById(R.id.btnfifteen);
		btnTwenty = (Button) findViewById(R.id.btntwenty);
		btnDiffTip = (Button) findViewById(R.id.btnDiff);
		totalAmount = (EditText) findViewById(R.id.totalAmount);
		finalTip = (TextView) findViewById(R.id.tipFinalAmount);
		diffTip = (EditText) findViewById(R.id.diffTipAmount);
	
		btnTen.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	double percentTen = 0.1;
		    	tippingMath(percentTen);
		    }
		});
		
		btnFifteen.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	double percentFifteen = 0.15;
		    	tippingMath(percentFifteen);
		    }
		});
		
		btnTwenty.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	double percentTwenty = 0.2;
		    	tippingMath(percentTwenty);
		    }
		});
		
		btnDiffTip.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	if (diffTip.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(), "What is the tip?", Toast.LENGTH_SHORT).show();
				}
		    	else {
			    	double diffNum = (new Double(diffTip.getText().toString()))/100;
			    	tippingMath(diffNum);
		    	}
		    }
		});
	}
	
	public void tippingMath(double percent) {
		if (totalAmount.getText().toString().equals("")) {
			Toast.makeText(getApplicationContext(), "Need the numbers!", Toast.LENGTH_SHORT).show();
		}
		else {
			double itemText = new Double(totalAmount.getText().toString());
	    	NumberFormat format = NumberFormat.getCurrencyInstance();
	    	double tipTotal = percent * itemText;
	    	finalTip.setText(format.format(tipTotal));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calc, menu);
		return true;
	}

}
