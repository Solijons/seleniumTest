public class HttpRequest {

private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void main(String[] args) throws Exception {
        Oauth oauth = new Oauth();
        oauth.getToken();
        String token = oauth.readToken();

        HttpRequest http = new HttpRequest();

        try {
            System.out.println("Getting Token - Send Http POST request");
            System.out.println(token);
            System.out.println("Printing result- Send Http GET request");
            http.sendGet(token);

        } finally {
            http.close();
        }
    }

    private void close() throws IOException {
        httpClient.close();
    }

    private void sendGet(String token) throws Exception {

        String api_url = "https://api_url.com";
        HttpGet request = new HttpGet(api_url);

        // add request headers
        request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            // Get HttpResponse Status
            if(response.getStatusLine().toString().contains("200")) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    String result = EntityUtils.toString(entity);

                }
            }
        }

    }
}
