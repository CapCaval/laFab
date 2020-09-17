package org.capcaval.lafab.labase.file;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Rules {
	private List<Path> rootPathList = new ArrayList<>();
	private List<Path> excludePathList = new ArrayList<>();
	private String pattern;

	public List<Path> getRootPathList() {
		return rootPathList;
	}

	public List<Path> getExcludePathList() {
		return excludePathList;
	}

	public String getPattern() {
		return pattern;
	}

	public Rules excludeDirContaining(String pathStr) {
		Path p = Paths.get(pathStr);
		this.excludePathList.add(p);
		
		return this;
	}
	
	public Rules addRootDir(String pathStr) {
		this.rootPathList.add(Paths.get(pathStr));
		
		return this;
	}
	
	public Rules addExcludePath(String pathStr) {
		this.excludePathList.add(Paths.get(pathStr));
		
		return this; 
	}
	
	public Rules withPattern(String pattern) {
		this.pattern = pattern;
		
		return this; 
	}
}
