package com.example.simledatabase;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	DatabaseHandler db;
	EditText edtName, edtRoll, edtPhone, edtEmail, edtSession, edtSemester,
			edtCgpa, edtBloodGroup;

	Button btn_Registration, btn_Show_details;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		db = new DatabaseHandler(this);
		btn_Registration = (Button) findViewById(R.id.btn_submit);
		
		btn_Registration.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {

				// Done Initialisation
				edtName = (EditText) findViewById(R.id.edtStudentName);
				edtRoll = (EditText) findViewById(R.id.edtRoll);
				edtPhone = (EditText) findViewById(R.id.edtPhoneNumber);
				edtEmail = (EditText) findViewById(R.id.edtEmail);
				edtSession = (EditText) findViewById(R.id.edtSession);
				edtSemester = (EditText) findViewById(R.id.edtSemester);
				edtCgpa = (EditText) findViewById(R.id.edtCGPA);
				edtBloodGroup = (EditText) findViewById(R.id.edtBloodGroup);

				// Getting Data

				String studentName = edtName.getText().toString();
				int studentRoll = Integer.parseInt(edtRoll.getText().toString());
				String studentPhoneNumber = edtPhone.getText().toString();
				String studentEmail = edtEmail.getText().toString();
				String studetnSession = edtSession.getText().toString();
				int studentSemester = Integer
						.parseInt(edtSemester.getText().toString());
				Float studetnCGPA = Float.parseFloat(edtCgpa.getText().toString());
				String studentBloodGroup = edtBloodGroup.getText().toString();

				Student aStudent = new Student(studentName, studentRoll,
						studentPhoneNumber, studentEmail, studetnSession,
						studentSemester, studetnCGPA, studentBloodGroup);

				db.addContact(aStudent);
				Toast.makeText(getApplicationContext(), "Saved Successfully",
						Toast.LENGTH_LONG).show();				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

//	public void onRegisteredButton_clicked(View view) {
//
//		// Done Initialisation
//		edtName = (EditText) findViewById(R.id.edtStudentName);
//		edtRoll = (EditText) findViewById(R.id.edtRoll);
//		edtPhone = (EditText) findViewById(R.id.edtPhoneNumber);
//		edtEmail = (EditText) findViewById(R.id.edtEmail);
//		edtSession = (EditText) findViewById(R.id.edtSession);
//		edtSemester = (EditText) findViewById(R.id.edtSemester);
//		edtCgpa = (EditText) findViewById(R.id.edtCGPA);
//		edtBloodGroup = (EditText) findViewById(R.id.edtBloodGroup);
//
//		// Getting Data
//
//		String studentName = edtName.getText().toString();
//		int studentRoll = Integer.parseInt(edtRoll.getText().toString());
//		String studentPhoneNumber = edtPhone.getText().toString();
//		String studentEmail = edtEmail.getText().toString();
//		String studetnSession = edtSession.getText().toString();
//		int studentSemester = Integer
//				.parseInt(edtSemester.getText().toString());
//		Float studetnCGPA = Float.parseFloat(edtCgpa.getText().toString());
//		String studentBloodGroup = edtBloodGroup.getText().toString();
//
//		Student aStudent = new Student(studentName, studentRoll,
//				studentPhoneNumber, studentEmail, studetnSession,
//				studentSemester, studetnCGPA, studentBloodGroup);
//
//		db.addContact(aStudent);
//		Toast.makeText(getApplicationContext(), "Saved Successfully",
//				Toast.LENGTH_LONG).show();
//
//	}
}
