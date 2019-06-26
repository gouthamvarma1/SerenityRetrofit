package com.bluzone.steps;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.bluzone.apis.RestApi;
import com.bluzone.apis.SamplePost;
import com.bluzone.apis.Tag;
import com.bluzone.test.StartingPoint;
import com.fasterxml.jackson.databind.JsonNode;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import retrofit2.Response;
import com.bluzone.apis.Category;
import com.bluzone.apis.CreateUserRequest;
@ContextConfiguration(classes = StartingPoint.class)
public class TestSteps {
	
	@Autowired
	private RestApi restApi;
	
	@Steps
	private CreateUserRequest createUserRequest; //Pojo Class
	
	private SamplePost samplePost=new SamplePost();
	
	Category cat=new Category();
	Tag tag=new Tag();
	
	@Step 
	public void runSingleUser() throws IOException {
		Response<JsonNode> sample = restApi.singleUser("2").execute();	
		System.out.println(sample.body().asText());

	}
		
	@Step 
	public void runPostRequest() throws IOException {
		createUserRequest.setJob("morpheus");
		createUserRequest.setName("leader");		
		Response<JsonNode> sample = restApi.createuser(createUserRequest).execute();				
		System.out.println("Response : "+sample.body().toString());			
		JsonNode recentMail = sample.body().get("createdAt");
		System.out.println("Name :"+recentMail);

	}
	
	@Step 
	public void runPostSwagger() throws IOException {
		List<String> photoUrls=new ArrayList<String>();  
		ArrayList<Tag> tags=new ArrayList<Tag>();
		
		photoUrls.add("string");
		samplePost.setId(0);
		
		cat.setId(0);
		cat.setName("string");
		
		samplePost.setCategory(cat);
		
		samplePost.setName("doggie");
		
		samplePost.setPhotoUrls(photoUrls);
		
		samplePost.setTags(tags);	
		
		tag.setId(0);
		tag.setName("Name");
				
		tags.add(tag);
		
		samplePost.setTags(tags);
		
		samplePost.setStatus("available");
		
		Response<JsonNode> sample = restApi.swaggerPost(samplePost).execute();				
		System.out.println("Response : "+sample.body().toString());			
		JsonNode recentMail = sample.body().get("tags");		
		System.out.println("Node values :"+recentMail);

	}
	
	

}
