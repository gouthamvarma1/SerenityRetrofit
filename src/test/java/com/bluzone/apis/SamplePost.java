package com.bluzone.apis;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "id", "category", "name", "photoUrls", "tags", "status" })
public class SamplePost {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("category")
	private Category category;
	@JsonProperty("name")
	private String name;
	@JsonProperty("photoUrls")
	private List<String> photoUrls = null;
	@JsonProperty("tags")
	private List<Tag> tags = null;
	@JsonProperty("status")
	private String status;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("category")
	public Category getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(Category category) {
		this.category = category;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("photoUrls")
	public List<String> getPhotoUrls() {
		return photoUrls;
	}

	@JsonProperty("photoUrls")
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}

	@JsonProperty("tags")
	public List<Tag> getTags() {
		return tags;
	}

	@JsonProperty("tags")
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

}