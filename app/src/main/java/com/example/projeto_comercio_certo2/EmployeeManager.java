package com.example.projeto_comercio_certo2;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private static final String PREF_NAME = "EmployeePref";
    private static final String KEY_EMPLOYEE_LIST = "employeeList";

    public static void saveEmployeeList(Context context, List<Employee> employeeList) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(employeeList);
        editor.putString(KEY_EMPLOYEE_LIST, json);
        editor.apply();
    }

    public static List<Employee> loadEmployeeList(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(KEY_EMPLOYEE_LIST, null);
        Type type = new TypeToken<ArrayList<Employee>>() {}.getType();
        return gson.fromJson(json, type);
    }
}

