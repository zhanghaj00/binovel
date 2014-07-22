package com.binovel.common;

import java.nio.file.attribute.FileAttribute;

public class MyFileAttr implements FileAttribute<String>{

	public String name() {
		return "novel";
	}

	public String value() {
		return "novel";
	}

}
