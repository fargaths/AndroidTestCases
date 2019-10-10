package com.example.androidtestssample;

import com.example.androidtestssample.profile.ProfileService;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.ResponseBody;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertTrue;

public class ProfileTestUseCaseOne {

    @Test
    public void testProfileService() throws IOException {

        MockWebServer mockWebServer = new MockWebServer();
        String mockUrl = "profile/";
        MockResponse mockResponse = new MockResponse()
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .addHeader("Cache-Control", "no-cache")
                .setBody(FAKE_JSON);
        mockResponse.throttleBody(1024, 3, TimeUnit.SECONDS);
        mockWebServer.enqueue(mockResponse);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mockWebServer.url(mockUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ProfileService profileService = retrofit.create(ProfileService.class);
        Call<ResponseBody> call = profileService.getProfile();
        try {
            //assertTrue(call.execute() != null);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
            assertTrue(call.isExecuted());
            mockWebServer.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static final String FAKE_JSON = "{\n" +
            "  \"login\": \"riggaroo\",\n" +
            "  \"id\": 9973046,\n" +
            "  \"node_id\": \"MDQ6VXNlcjk5NzMwNDY=\",\n" +
            "  \"avatar_url\": \"https://avatars0.githubusercontent.com/u/9973046?v=4\",\n" +
            "  \"gravatar_id\": \"\",\n" +
            "  \"url\": \"https://api.github.com/users/riggaroo\",\n" +
            "  \"html_url\": \"https://github.com/riggaroo\",\n" +
            "  \"followers_url\": \"https://api.github.com/users/riggaroo/followers\",\n" +
            "  \"following_url\": \"https://api.github.com/users/riggaroo/following{/other_user}\",\n" +
            "  \"gists_url\": \"https://api.github.com/users/riggaroo/gists{/gist_id}\",\n" +
            "  \"starred_url\": \"https://api.github.com/users/riggaroo/starred{/owner}{/repo}\",\n" +
            "  \"subscriptions_url\": \"https://api.github.com/users/riggaroo/subscriptions\",\n" +
            "  \"organizations_url\": \"https://api.github.com/users/riggaroo/orgs\",\n" +
            "  \"repos_url\": \"https://api.github.com/users/riggaroo/repos\",\n" +
            "  \"events_url\": \"https://api.github.com/users/riggaroo/events{/privacy}\",\n" +
            "  \"received_events_url\": \"https://api.github.com/users/riggaroo/received_events\",\n" +
            "  \"type\": \"User\",\n" +
            "  \"site_admin\": false,\n" +
            "  \"name\": \"Rebecca Franks\",\n" +
            "  \"company\": \"@overhq \",\n" +
            "  \"blog\": \"http://riggaroo.co.za\",\n" +
            "  \"location\": \"Johannesburg, South Africa\",\n" +
            "  \"email\": null,\n" +
            "  \"hireable\": null,\n" +
            "  \"bio\": \"Google Developer Expert for Android. Android Lead based in South Africa. Love working with Firebase and Android in general. \",\n" +
            "  \"public_repos\": 33,\n" +
            "  \"public_gists\": 24,\n" +
            "  \"followers\": 1503,\n" +
            "  \"following\": 41,\n" +
            "  \"created_at\": \"2014-11-27T06:32:40Z\",\n" +
            "  \"updated_at\": \"2019-06-24T13:07:48Z\"\n" +
            "}";
}
