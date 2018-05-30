package com.mblinn.oo.tinyweb;

public class HttpRequest {
    /* set request header */

    public static Builder builderFrom(HttpRequest request) {
        Builder builder = new Builder();
        builder.path(request.getPath());
        builder.body(request.getBody());
    
        Map<String, String> headers = request.getHeaders();
        for (String headerName : headers.keySet())
                builder.addHeader(headerName,
                headers.get(headerName));
    
        return builder;
    }
}

