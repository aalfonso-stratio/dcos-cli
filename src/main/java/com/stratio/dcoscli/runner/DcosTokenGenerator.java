package com.stratio.dcoscli.runner;

import com.auth0.jwt.JWTSigner;
import java.util.HashMap;
import java.util.Date;

public class DcosTokenGenerator {
    public static void main (String[] args) {
        String DCOSsecret = args[0].trim();
        String user = args[1].trim();

        final JWTSigner signer = new JWTSigner(DCOSsecret);
        final HashMap<String, Object> claims = new HashMap();
        claims.put("uid", user);

        // Date now = new Date();
        // Long exp = new Long(now.getTime()/1000) + 3600;

        // claims.put("exp", exp);

        final String jwt = signer.sign(claims);

        System.out.println(jwt);
    }
}
