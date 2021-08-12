package com.samasat.civalidator;

import com.samasat.civalidator.entity.IdentityCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public class IdentityCardValidationTest {

    @Test
    public void validateCI (String numCI){
            boolean result  = false;

            byte sum = 0;
            try {
                if (numCI.trim().length() != 10)
                    result =  false;
                String[] data = numCI.split("");
                byte verifier = Byte.parseByte(data[0] + data[1]);
                if (verifier < 1 || verifier > 24)
                    result =  false;
                byte[] digits = new byte[data.length];
                for (byte i = 0; i < digits.length; i++)
                    digits[i] = Byte.parseByte(data[i]);
                if (digits[2] > 6)
                    result =  false;
                for (byte i = 0; i < digits.length - 1; i++) {
                    if (i % 2 == 0) {
                        verifier = (byte) (digits[i] * 2);
                        if (verifier > 9)
                            verifier = (byte) (verifier - 9);
                    } else
                        verifier = (byte) (digits[i] * 1);
                    sum = (byte) (sum + verifier);
                }
                if ((sum - (sum % 10) + 10 - sum) == digits[9])
                    result =  true;
            } catch (Exception e) {
                e.printStackTrace();
                result = false;
            }


        Assertions.assertTrue(result);
    }

}
