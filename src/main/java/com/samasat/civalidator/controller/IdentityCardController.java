package com.samasat.civalidator.controller;

import com.samasat.civalidator.entity.IdentityCard;
import com.samasat.civalidator.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IdentityCardController {

    @Autowired
    IdentityService identityService;

    @GetMapping("/validate/{numCI}")
    public ResponseEntity<IdentityCard> validateCI(@PathVariable String numCI){
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

        if(!result) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }

    @GetMapping("/find/{numCi}")
    public ResponseEntity<IdentityCard> findById(@PathVariable String numCi){
        IdentityCard identityCard = identityService.findByNumCi(numCi);
        return ResponseEntity.ok(identityCard);
    }


}
