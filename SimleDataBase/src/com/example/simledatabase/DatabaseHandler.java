package com.example.simledatabase;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static Variable

	// Database Version

	//
	private static final int DATABASE_VERSION = 1;
	//
	// // Database Name
	private static final String DATABASE_NAME = "studentInfoDb";
	//
	// // Student Table Name
	//
	private static final String TABLE_STUDENTS = "tb_student";

	// Student Table Column Name
	private static final String KEY_ID = "id";
	private static final String KEY_STUDENT_NAME = "student_name";
	private static final String KEY_STUDENT_ROLL = "student_roll";
	private static final String KEY_STUDENT_PHONE = "student_phone";
	private static final String KEY_STUDENT_EMAIL = "student_email";
	private static final String KEY_STUDENT_SESSION = "student_session";
	private static final String KEY_STUDENT_SEMESTER = "studetn_semester";
	private static final String KEY_STUDENT_CGPA = "student_cgpa";
	private static final String KEY_STUDENT_BLOOD_GROUP = "student_blood_group";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		String CREATE_STUDENTS_TABLE = "CREATE TABLE" + TABLE_STUDENTS + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_STUDENT_NAME
				+ " TEXT," + KEY_STUDENT_ROLL + " INTEGER," + KEY_STUDENT_PHONE
				+ " TEXT," + KEY_STUDENT_EMAIL + " TEXT," + KEY_STUDENT_SESSION
				+ " TEXT," + KEY_STUDENT_SEMESTER + " INTEGER,"
				+ KEY_STUDENT_CGPA + " FLOAT," + KEY_STUDENT_BLOOD_GROUP
				+ " TEXT" + ")";

		db.execSQL(CREATE_STUDENTS_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_STUDENTS);

		onCreate(db);

	}

	void addContact(Student student) {

		SQLiteDatabase db = super.getReadableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_STUDENT_NAME, student.get_student_name());
		values.put(KEY_STUDENT_ROLL, student.get_roll());
		values.put(KEY_STUDENT_PHONE, student.get_phone_number());
		values.put(KEY_STUDENT_EMAIL, student.get_email());
		values.put(KEY_STUDENT_SESSION, student.get_session());
		values.put(KEY_STUDENT_SEMESTER, student.get_semester());
		values.put(KEY_STUDENT_CGPA, student.get_cgpa());
		values.put(KEY_STUDENT_BLOOD_GROUP, student.get_blood_group());

		// Inserting Row

		db.insert(TABLE_STUDENTS, null, values);
		db.close();

	}

	// Getting All Contacts
	public List<Student> getAllContacts() {

		List<Student> studentList = new ArrayList<Student>();

		// Select All Query

		String selectQuery = "SELECT * FROM " + TABLE_STUDENTS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all row and adding to list

		if (cursor.moveToFirst()) {
			do {
				Student student = new Student();
				student.set_id(Integer.parseInt(cursor.getString(0)));
				student.set_student_name(cursor.getString(1));
				student.set_roll(Integer.parseInt(cursor.getString(2)));
				student.set_phone_number(cursor.getString(3));
				student.set_email(cursor.getString(4));
				student.set_session(cursor.getString(5));
				student.set_semester(Integer.parseInt(cursor.getString(6)));
				student.set_cgpa(Float.parseFloat(cursor.getString(7)));
				student.set_blood_group(cursor.getString(8));

				// Adding Contact To List

				studentList.add(student);

			} while (cursor.moveToNext());

		}
		return studentList;
	}

	// Getting contacts Count
	public int getContactsCount() {
		String countQuery = "SELECT  * FROM " + TABLE_STUDENTS;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

}
