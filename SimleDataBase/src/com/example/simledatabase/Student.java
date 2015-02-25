package com.example.simledatabase;

public class Student {

	int _id;
	String _student_name;
	int _roll;
	String _phone_number;
	String _email;
	String _session;
	int _semester;
	Float _cgpa;
	String _blood_group;

	public Student() {

	}

	public Student(int _id, String _student_name, int _roll,
			String _phone_number, String _email, String _session,
			int _semester, Float _cgpa, String _blood_group) {
		super();
		this._id = _id;
		this._student_name = _student_name;
		this._roll = _roll;
		this._phone_number = _phone_number;
		this._email = _email;
		this._session = _session;
		this._semester = _semester;
		this._cgpa = _cgpa;
		this._blood_group = _blood_group;
	}

	public Student(String _student_name, int _roll, String _phone_number,
			String _email, String _session, int _semester, Float _cgpa,
			String _blood_group) {
		super();
		this._student_name = _student_name;
		this._roll = _roll;
		this._phone_number = _phone_number;
		this._email = _email;
		this._session = _session;
		this._semester = _semester;
		this._cgpa = _cgpa;
		this._blood_group = _blood_group;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_student_name() {
		return _student_name;
	}

	public void set_student_name(String _student_name) {
		this._student_name = _student_name;
	}

	public int get_roll() {
		return _roll;
	}

	public void set_roll(int _roll) {
		this._roll = _roll;
	}

	public String get_phone_number() {
		return _phone_number;
	}

	public void set_phone_number(String _phone_number) {
		this._phone_number = _phone_number;
	}

	public String get_email() {
		return _email;
	}

	public void set_email(String _email) {
		this._email = _email;
	}

	public String get_session() {
		return _session;
	}

	public void set_session(String _session) {
		this._session = _session;
	}

	public int get_semester() {
		return _semester;
	}

	public void set_semester(int _semester) {
		this._semester = _semester;
	}

	public Float get_cgpa() {
		return _cgpa;
	}

	public void set_cgpa(Float _cgpa) {
		this._cgpa = _cgpa;
	}

	public String get_blood_group() {
		return _blood_group;
	}

	public void set_blood_group(String _blood_group) {
		this._blood_group = _blood_group;
	}

}
