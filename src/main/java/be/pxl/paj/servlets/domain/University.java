package be.pxl.paj.servlets.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class University {
	private String name;
	@JsonProperty("web_pages")
	private List<String> webPages;

	public String getName() {
		return name;
	}

	public List<String> getWebPages() {
		return webPages;
	}
}
