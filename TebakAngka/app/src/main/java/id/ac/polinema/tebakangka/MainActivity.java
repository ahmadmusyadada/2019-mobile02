package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private EditText angkaInput;
	private Button button;
	private int number;
	Random random = new Random();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		number = random.nextInt(100) + 1;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		angkaInput = findViewById(R.id.number_input);
		int angkaTebakan = Integer.parseInt(String.valueOf(angkaInput.getText()));
		if (angkaTebakan < number){
			Toast.makeText(this, "Tebakan anda lebih kecil dari jawaban", Toast.LENGTH_SHORT).show();
		} else if (angkaTebakan > number) {
			Toast.makeText(this, "Tebakan anda lebih besar dari jawaban", Toast.LENGTH_SHORT).show();
		} else if (angkaTebakan == number) {
			Toast.makeText(this, "Tebakan anda benar", Toast.LENGTH_SHORT).show();
			Button btn = (Button) findViewById(R.id.guess_button);
			btn.setEnabled(false);
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		setContentView(R.layout.activity_main);
		initRandomNumber();
	}
}