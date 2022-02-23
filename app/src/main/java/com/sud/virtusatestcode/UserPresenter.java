package com.sud.virtusatestcode;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.sud.virtusatestcode.model.UserResponse;
import com.sud.virtusatestcode.network.NetworkClient;
import com.sud.virtusatestcode.network.NetworkInterface;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
public class UserPresenter implements UserContract.Presenter {
    String TAG = "UserPresenter";
    @NonNull
    UserContract.View mView;
    Context mContext;
    public UserPresenter(@NonNull UserContract.View view, Context context) {
        mView = view;
        mContext = context;
    }
    @Override
    public void getUserData(String id) {
        getUserObservable(id).subscribeWith(getUserObserver());
    }
    public Observable<UserResponse> getUserObservable(String id) {
        mView.showProgressBar();
        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                .getUserList(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
    public DisposableObserver<UserResponse> getUserObserver() {
        return new DisposableObserver<UserResponse>() {

            @Override
            public void onNext(@NonNull UserResponse userResponse) {
                Log.i(TAG, "OnNext" + userResponse);
                mView.hideProgressBar();
                mView.UserResponse(userResponse);
            }
            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG, "Error" + e);
                e.printStackTrace();
                mView.displayError(e.toString());
                mView.hideProgressBar();
            }
            @Override
            public void onComplete() {
                Log.i(TAG, "Completed");
                mView.hideProgressBar();
            }
        };
    }

}
