package com.example.listview.utils;

import com.example.listview.model.UserModel;
import java.util.ArrayList;

public class TaskFactory {
    public static UserModel getUserModel() {
        return new UserModel(
                TestUtils.getRandomAvatar(),
                TestUtils.getRandomFirstName(),
                TestUtils.getRandomLastName(),
                TestUtils.getRandomInteger(14, 99),
                TestUtils.getRandomCountry(),
                TestUtils.getRandomCity()
        );
    }

    public static ArrayList<UserModel> getUserModels(int count) {
        ArrayList<UserModel> users = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            users.add(getUserModel());
        }

        return users;
    }
}
