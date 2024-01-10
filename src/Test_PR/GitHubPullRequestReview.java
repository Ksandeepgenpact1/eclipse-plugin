package Test_PR;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;



import java.io.IOException;

public class GitHubPullRequestReview {
    
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static final String GITHUB_API_URL = "https://api.github.com";
    public static final String ACCESS_TOKEN = "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";
    public static final String OWNER = "Ksandeepgenpact1";
    public static final String REPO = "eclipse-plugin";
    public static final int PULL_NUMBER = 1; 

    public static void main(String[] args) {
        String reviewBody = "This is my review comment.";
        String event = "COMMENT"; // Event type: COMMENT, APPROVE, REQUEST_CHANGES, DISMISS

        createPullRequestReview(reviewBody, event);
    }

    @SuppressWarnings("deprecation")
	public static void createPullRequestReview(String reviewBody, String event) {    	
        String url = GITHUB_API_URL + "/repos/" + OWNER + "/" + REPO + "/pulls/" + PULL_NUMBER + "/reviews";
        String json = new JSONObject()
                .put("commit_id", "75a3e932564eb58fed72d0541fe689ba27e4b844")
                .put("body", TestReviewBody)
                .put("event", event)
                .toString();

        OkHttpClient client = new OkHttpClient();
        @SuppressWarnings("deprecation")
		RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("Accept", "application/vnd.github.v3+json")
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();            
            if (response.isSuccessful()) {
                System.out.println("Review submitted successfully.");
                System.out.println("Added the review Comment onto The PR");
            } else {
                System.out.println("Error submitting the review.");
                System.out.println("Check the Api endpoint or otherwise the access Token");
            }
        } catch (IOException e) {        	 
            e.printStackTrace();
        }
    }
}
