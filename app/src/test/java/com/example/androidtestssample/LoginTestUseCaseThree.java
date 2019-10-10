package com.example.androidtestssample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Utils.class})
public class LoginTestUseCaseThree {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(Utils.class);
        PowerMockito.when(Utils.isValidEmail(anyString())).thenReturn(true);
    }

    @Test
    public void testValidEmail() {
        assertTrue(Utils.isValidEmail("abc@example.com"));
    }
}
