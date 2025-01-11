package org.url.shorten.util;

import java.util.Base64;

public class CustomBase64 implements UrlAlgorithm {

    public String encode(long id) {
        return Base64.getEncoder().encodeToString(String.valueOf(id).getBytes());
    }

    public long decode(String shorten) {
        byte[] decodedBytes = Base64.getUrlDecoder().decode(shorten);
        return Long.parseLong(new String(decodedBytes));
    }
}
