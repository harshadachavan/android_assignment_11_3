package com.example.harshadachavan.imagesaveindb;

/**
 * Created by Harshada Chavan on 10/3/2017.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowStudent extends Activity{
    TextView tvName,tvAge;    //Creating references of TextView.
    ImageView empPhoto;      //Creating references of ImageView.

    @Override
    //onCreate method.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_student_details);    //Setting content view with its Layout.

        //Setting references with its IDs.
        tvName=(TextView)findViewById(R.id.name_tv);
        tvAge=(TextView)findViewById(R.id.age_tv);
        empPhoto=(ImageView)findViewById(R.id.employee_photo);

        //Getting the Intent object which is passed.
        Intent intent=getIntent();

        //Creating reference of DBHelper class.
        DBHelper db=new DBHelper(getApplicationContext());

        //fetching the id of student which is passed in the intent.
        int id=intent.getIntExtra("stud_id",0);

        //Getting the Student object by its ID using the method of DBHelper class.
        Student student=db.getDataByID(id);


        //Setting the Views According to the information in the object.
        tvName.setText("Name : "+student.nameOfStudent);
        tvAge.setText("Age : "+student.ageOfStudent);
        empPhoto.setImageBitmap(student.employeePhoto);
    }

}
