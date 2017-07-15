package com.cleancoder.args;

import static com.cleancoder.args.ArgsException.ErrorCode.INVALID_ARGUMENT_FORMAT;

public enum ArgMarshalerType {
	BOOLEAN("", BooleanArgumentMarshaler.class),
	DOUBLE("##", DoubleArgumentMarshaler.class),
	INTEGER("#", IntegerArgumentMarshaler.class),
	MAP("&", MapArgumentMarshaler.class),
	STRING("*", StringArgumentMarshaler.class),
	STRING_ARRAY("[*]", StringArrayArgumentMarshaler.class);
	
	private String schema;
	private Class<? extends ArgumentMarshaler> marshaler;
	
	private ArgMarshalerType(String schema, Class<? extends ArgumentMarshaler> marshaler){
		this.schema = schema;
		this.marshaler = marshaler;
	}

	public static ArgMarshalerType findBySchema(char elementId, String elementTail) throws ArgsException {
		for (ArgMarshalerType type : values()){
			if (type.schema.equals(elementTail)){
				return type;
			}
		}
		throw new ArgsException(INVALID_ARGUMENT_FORMAT, elementId, elementTail);
	}

	public ArgumentMarshaler getNewMarshaler() throws ArgsException {
		try {
			return marshaler.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new ArgsException(e.getMessage());
		}
	}

}
