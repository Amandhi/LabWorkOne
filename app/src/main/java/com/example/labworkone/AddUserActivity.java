package com.example.labworkone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;

import repository.UserRepository;
import bo.User;


public class AddUserActivity extends AppCompatActivity implements View.OnClickListener {
    //The tag used into this screen for the logs
    public static final String TAG = AddUserActivity.class.getSimpleName();

    private EditText name;

    private EditText phoneNumber;

    private EditText address;

    private EditText about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        //Then we retrieved the widget we will need to manipulate into the
        name = findViewById(R.id.editTextName);
        phoneNumber = findViewById(R.id.editTextPhone);
        address = findViewById(R.id.editTextAddress);
        about = findViewById(R.id.editTextAbout);

        //We configure the click on the save button
        findViewById(R.id.buttonSave).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //we first retrieve user's entries
        final String userName = name.getEditableText().toString();
        final String userPhoneNumber = phoneNumber.getEditableText().toString();
        final String userAddress = address.getEditableText().toString();
        final String aboutUser = about.getEditableText().toString();

        //We display the properties into the logcat
        displayUserEntries(userName, userPhoneNumber, userAddress, aboutUser);

        //We check if all entries are valid (not null and not empty)
        final boolean canAddUser = checkFormEntries(userName, userPhoneNumber, userAddress, aboutUser);

        if (canAddUser == true)
        {
            //We add the user to the list and we reset the form
            saveUser(userName, userPhoneNumber, userAddress, aboutUser);
            resetForm();
        }
        else
        {
            //we display a log error and a Toast
            Log.w(AddUserActivity.TAG, "Cannot add the user");
            Toast.makeText(this, R.string.cannot_add_user, Toast.LENGTH_SHORT).show();
        }
    }

    private void resetForm() {
        name.setText(null);
        address.setText(null);
        phoneNumber.setText(null);
        about.setText(null);
    }

    private void saveUser(String userName, String userPhoneNumber, String userAddress, String aboutUser) {
        UserRepository.getInstance().addUser(new User(userName, userPhoneNumber, userAddress, aboutUser));
    }


    private boolean checkFormEntries(String userName, String userPhoneNumber, String userAddress, String aboutUser) {
        return TextUtils.isEmpty(userName) == false && TextUtils.isEmpty(userPhoneNumber) == false && TextUtils.isEmpty(userAddress) == false && TextUtils.isEmpty(aboutUser) == false;
    }

    private void displayUserEntries(String userName, String userPhoneNumber, String userAddress, String aboutUser) {
        Log.d(AddUserActivity.TAG, "name : '" + userName + "'");
        Log.d(AddUserActivity.TAG, "phone number : '" + userPhoneNumber + "'");
        Log.d(AddUserActivity.TAG, "address : '" + userAddress + "'");
        Log.d(AddUserActivity.TAG, "about : '" + aboutUser + "'");
    }
}