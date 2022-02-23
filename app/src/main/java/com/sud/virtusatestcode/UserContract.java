package com.sud.virtusatestcode;
import com.sud.virtusatestcode.model.UserResponse;

public interface UserContract {
    interface View {
        void showProgressBar();
        void hideProgressBar();
        void UserResponse(UserResponse userResponse);
        void displayError(String s);
    }
    interface Presenter {
        void getUserData(String id);
    }

}
