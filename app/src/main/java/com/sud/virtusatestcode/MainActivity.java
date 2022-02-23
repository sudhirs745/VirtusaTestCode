package com.sud.virtusatestcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.sud.virtusatestcode.model.UserResponse;

public class MainActivity extends AppCompatActivity implements UserContract.View {

    private String TAG = "MainActivity";
    private UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.e(TAG, "Example 1 Output 1 -:" + RemoveStringClass.remove("ABC", "BC")  + "  Example 1 Output 2 -:" + RemoveStringClass.remove("BC", "ABC") );
        Log.e(TAG, "Example 2 Output 1 -:" + RemoveStringClass.remove("BC", "BANGALORE")  + "  Example 2 Output 2 -:" + RemoveStringClass.remove("BANGALORE", "BC") );


        userPresenter = new UserPresenter(this, this);
        userPresenter.getUserData("1");
        userPresenter.getUserData("3");
        userPresenter.getUserData("10");

    }

    @Override
    public void showProgressBar() {
        Log.i(TAG, "showProgressBar: ");
    }

    @Override
    public void hideProgressBar() {
        Log.i(TAG, "hideProgressBar: ");
    }

    @Override
    public void UserResponse(UserResponse userResponse) {

        Log.e(TAG, "Outputs email id " + userResponse.getData().getEmail());

    }

    @Override
    public void displayError(String s) {
        Log.e(TAG, "displayError: " + s);

    }
}