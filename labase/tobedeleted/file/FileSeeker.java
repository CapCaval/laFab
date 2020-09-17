/*
Copyright (C) 2012 by CapCaval.org

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/
package org.capcaval.lafab.labase.file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;



public class FileSeeker extends SimpleFileVisitor<Path> {
	private PathMatcher matcher;
	public List<Path> fileList = new ArrayList<Path>();
	public Map<String, Path> excludeFileMap = new HashMap<String, Path>();
	public Map<String, Path> mustNotContainMap = new HashMap<String, Path>();
	public Map<String, Path> mustContainMap = new HashMap<String, Path>();
	private Path startingDir;
	private boolean insideJar = true;
	
	public FileSeeker(String pattern, Path... excludeList){
		// by default seek inside jar
		this.init(pattern, true, excludeList);
	}

	public FileSeeker(String pattern, List<Path> excludeList){
		// by default seek inside jar
		this.init(pattern, true, excludeList.toArray(new Path[0]));
	}
	
	public FileSeeker(String pattern, List<Path> excludeList, List<String> mustContainList, List<String> mustNotContainList){
		// by default seek inside jar
		this.init(pattern, true, excludeList.toArray(new Path[0]));
	}

	
	public FileSeeker(String pattern,  boolean insideJar, Path... excludeList){
		this.init(pattern, insideJar, excludeList);
	} 

	public void init(String pattern, boolean insideJar, Path... excludeList){
		this.matcher = FileSystems.getDefault()
                    .getPathMatcher("glob:" + pattern);
		
		this.insideJar = insideJar;
		
		for(Path path : excludeList){
			this.excludeFileMap.put(path.toFile().getName(), path);
		}
	} 

	@Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		if((this.insideJar == true)&&(file.toString().endsWith(".jar")==true)){
			try {
				System.out.println(file.toFile().getAbsolutePath());
				final JarFile jarFile = new JarFile(file.toFile());
				Enumeration<JarEntry> entries = jarFile.entries();
				while(entries.hasMoreElements()){
					JarEntry entry = (JarEntry) entries.nextElement();
					String name = entry.getName();
					this.find(Paths.get(name));
				}
			} catch (Exception e) {
				throw new RuntimeException("["+ this.getClass().getName() + "] WARNING : Cannot not read the following file : " + file.toFile(), e);
			}
		}
        find(file);
        return FileVisitResult.CONTINUE;
    }
	
	void find(Path file) {
        Path name = file.getFileName();
        
        Path p = this.excludeFileMap.get(name.toFile().getName());
        if(p != null){
        	if(p.equals(file)){
        		// do nothing do not add this file
        	}
        }
        else if(name != null && this.matcher.matches(name)) {
        	//Path relPath = Paths.get(file.toString().substring(this.startingDir.toString().length()+1));
            this.fileList.add(file); // MLB 
            }
    }
	

	public FileSeekerResult seek(Path startingDir){
		return this.seek(startingDir, null);
	}

	public FileSeekerResult seek(Path startingDir, FileSeekerResult result){
		// init result list
		this.fileList.clear();
		
		// keep a ref on the starting directory
		this.startingDir = startingDir;
		// Go 
		try {
			Files.walkFileTree(startingDir, this);
		} catch (IOException e) {
			throw new RuntimeException("[laFabrique] Error : can walk file tree from  " + startingDir);
		}
		
		if(result == null){
			result = new FileSeekerResult();
		}
		result.addFiles(this.fileList.toArray(new Path[0]));
		
		return result;
	}
}
