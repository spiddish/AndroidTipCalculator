package spiddish.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

public class CalculateTip extends Activity {
	DecimalFormat myFormatter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculate_tip);
		myFormatter = new DecimalFormat("$###,###.##");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculate_tip, menu);
		return true;
	}
	
	public void onSmallTip(View v) {
		displayTip(v, 0.1);
	}
	
	public void onMediumTip(View v) {
		displayTip(v, 0.15);
	}
	
	public void onLargeTip(View v) {
		displayTip(v, 0.2);
	}
	
	private void displayTip(View v, double tipPercent) {
		TextView inputBill = (TextView) this.findViewById(R.id.inputBill);
		Double billAmount = Double.valueOf(inputBill.getText().toString());
		double tipAmount = billAmount * tipPercent;
		TextView outputTip =(TextView) this.findViewById(R.id.outputTip);
		String formattedOutputTip = myFormatter.format(tipAmount);
		outputTip.setText(formattedOutputTip);
	}
}
