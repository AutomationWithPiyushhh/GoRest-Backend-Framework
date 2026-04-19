package com.automationwithpiyush.gorest.endpoints;

public class Routes {
    public static String base_url = "https://gorest.co.in/public/v2";

    // User Management module
    public static String post_url = "https://gorest.co.in/public/v2/users";
    public static String get_url = base_url + "/users/{id}";
    public static String put_url = base_url + "/users/{id}";
    public static String delete_url = base_url + "/users/{id}";
}
