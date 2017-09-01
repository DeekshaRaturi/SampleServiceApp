package com.example.cynopc.app;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Deeksha PC on 12/27/2016.
 */

public class Fb_login
{
    private static AccessToken accessToken;
    public static CallbackManager callbackManager;
    private static String fbUserId, fbloginObject, email, fname, lname, data, imageUrl;
    private static Context context;
    private static LoginButton loginButton;
    private static TextView textView;

    public static void FBSdkInitialization(Context context) {
        FacebookSdk.sdkInitialize(context);
        callbackManager = CallbackManager.Factory.create();
        fb_init();

    }

    public static void fb_init(){

        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                accessToken = loginResult.getAccessToken();
                fbUserId = loginResult.getAccessToken().getUserId();

                Toast.makeText(context, "successful", Toast.LENGTH_LONG).show();

                GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        try {
                            Log.e("Facebook Login", "" + response.toString());
                            Log.e("Facebook Object", "" + object.toString());

                          /*  JSONObject object1 = response.getJSONObject();
                            if (object1 != null) {
                                fbloginObject = object1.toString();

                                if (object1.getString("email") == null) {
                                    Log.d("THE EMAIL IS NULL", "EMAIL IS NULL");
                                } else {
                                    email = object1.getString("email");
                                }*/


                        }
                        catch (Exception e) {
                            Toast.makeText(context, "error", Toast.LENGTH_LONG).show();
                            e.printStackTrace();
                        }
                    }
                });


            }

            @Override
            public void onCancel() {
                Toast.makeText(context, "canceled", Toast.LENGTH_LONG).show();
                Log.e("FBLogin Canceled", "Facebook Login failed!!");
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(context, "unsuccesful", Toast.LENGTH_LONG).show();
                Log.e("FBLogin Error", "Facebook Login failed!!");
            }
        });
    }

}





