package com.example.androidtestssample;

import android.content.Context;

import com.example.androidtestssample.login.LoginRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginTestUseCaseTwo {

    @Mock
    Context context;

    private LoginRepository loginRepository;

    @Before
    public void setUp() {
        loginRepository = LoginRepository.getInstance();
    }

    @Test
    public void appNameTest() {

        // mock android framework class and substitute with mock data

        String testData = "AndroidTestsSample";

        when(context.getString(R.string.app_name)).thenReturn(testData);

        String result = loginRepository.getAppName(context);

        assertEquals("Wrong app name", result, testData);
    }

}
